package org.example.mime.beans;



import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.zip.CRC32;
import java.util.zip.Checksum;
import java.util.zip.Deflater;
import java.util.zip.DeflaterInputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;

/**
 * Common utility methods
 */
@SuppressWarnings({"PMD.GodClass", "PMD.TooManyMethods", "PMD.CyclomaticComplexity"})
public final class CommonUtils {

    private static final Logger logger = LoggerFactory.getLogger(CommonUtils.class);

    private static final String GZIP_ENCODING = "gzip";
    public static final String ZLIB_ENCODING = "zlib";
    private static final String MULTIPART = "multipart";

    private static final int MAX_SKIP_BUFFER_SIZE = 2048;

    private static final ObjectMapper YAML_OBJECT_MAPPER = new ObjectMapper(new YAMLFactory());

    private CommonUtils() {
        //Utility class
    }




    @Nullable
    public static InputStream getResourceAsStream(String fileName) {
        return CommonUtils.class.getClassLoader().getResourceAsStream(fileName);
    }

    public static byte[] toUTF8Bytes(@Nonnull String s) {
        return s.getBytes(StandardCharsets.UTF_8);
    }

    /**
     * Get resource URL from classpath
     *
     * @param fileName file name
     * @return resource URL
     */
    public static URL getResourceURL(String fileName) {
        return CommonUtils.class.getClassLoader().getResource(fileName);
    }

    /**
     * Sets interrupted flag if the exception being passed is {@link java.lang.InterruptedException}.
     *
     * @param e throwable to inspect
     */
    public static void checkInterrupted(final Throwable e) {
        if (e instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Write string into the given path. It opens the file for writing initially truncating an existing regular-file to 0. If parent directory is not
     * present, it will try to create it.
     *
     * @param destination path to write
     * @param content     string content
     * @throws IOException if file write fails
     */
    public static void writeFile(Path destination, String content) throws IOException {
        createParentPathIfMissing(destination);
        Files.writeString(destination, content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public static void writeFile(Path destination, InputStream sourceStream) throws IOException {
        createParentPathIfMissing(destination);
        Files.copy(sourceStream, destination, StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * Write string into the given path. It opens the file for writing by appending. If the parent directory is not present, it will try to create
     * it.
     *
     * @param destination path to write
     * @param content     string content
     * @throws IOException if file write fails
     */
    public static void writeFileAppend(Path destination, String content) throws IOException {
        createParentPathIfMissing(destination);
        Files.writeString(destination, content, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    public static void writeFromResourceFile(Path destination, String resourceName) throws IOException {
        writeFile(destination, getResourceAsStream(resourceName));
    }

    /**
     * Writes content to a temp file at a sibling location for {@code destinationPath} and then moves the temp file to the destination. The move will
     * not be performed if  {@code finalGoAhead} returns false. Temp file will be removed in all cases. This method may create directories even when
     * the destinationPath is not created.
     *
     * @param tempFileSuffix  suffix for temp file
     * @param destinationPath path to write
     * @param content         string content
     * @param finalGoAhead    boolean supplier to decide if the move should be performed
     * @param fileAttributes  file attributes for temp file
     * @return true if the move was performed
     * @throws IOException if file write fails
     */
    public static boolean writeAndMove(@Nonnull String tempFileSuffix, @Nonnull Path destinationPath, @Nonnull String content,
                                       @Nonnull BooleanSupplier finalGoAhead, FileAttribute<?>... fileAttributes) throws IOException {
        Path parentDir = destinationPath.getParent();
        if (parentDir == null) {
            throw new IOException(String.format("destination dir is null for path=%s", destinationPath));
        }
        String fileName = destinationPath.toFile().getName();
        createPathIfMissing(parentDir);
        Path tempFilePath = Files.createTempFile(parentDir, fileName, tempFileSuffix, fileAttributes);
        try {
            Files.write(tempFilePath, content.getBytes(StandardCharsets.UTF_8));
            if (finalGoAhead.getAsBoolean()) {
                Files.move(tempFilePath, destinationPath, StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
                return true;
            } else {
                logger.warn("writeAndMove couldn't move file because finalGoAhead returned false parentDir={}, tempFilePath={}", parentDir,
                        tempFilePath);
                return false;
            }
        } finally {
            CommonUtils.deleteFileIfExists(tempFilePath);
        }
    }



    /**
     * @param fileToBeDeleted file to be deleted
     * @return true if the file was actually present and deleted
     * @throws IOException if file deletion fails
     */
    public static boolean deleteFileIfExists(Path fileToBeDeleted) throws IOException {
        return Files.deleteIfExists(fileToBeDeleted);
    }



    /**
     * If the parent path doesn't exist, it will create
     *
     * @param filePath file path
     * @param content  content to be written
     * @throws IOException if file write fails
     */
    public static void appendToFile(Path filePath, String content) throws IOException {
        createParentPathIfMissing(filePath);
        Files.writeString(filePath, content, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    /**
     * Creates a path up to parent dir, if missing.
     *
     * @param filePath file path
     * @throws IOException if path creation fails
     */
    public static void createParentPathIfMissing(@Nonnull Path filePath) throws IOException {
        createPathIfMissing(filePath.getParent());
    }

    /**
     * Create a directory path if missing. This does not throw an exception if the path is already present
     *
     * @param directoryPath directory path
     * @throws IOException if path creation fails
     */
    public static void createPathIfMissing(@Nullable Path directoryPath) throws IOException {
        if (directoryPath != null && !Files.isDirectory(directoryPath)) {
            Files.createDirectories(directoryPath);
        }
    }



    /**
     * In general, use try-resource. This is only for exceptional cases like test cases and where stream is closed elsewhere
     *
     * @param closeables closeables
     */
    public static void closeQuietly(@Nullable AutoCloseable... closeables) {
        if (closeables != null) {
            for (AutoCloseable c : closeables) {
                if (c != null) {
                    try {
                        c.close();
                    } catch (Exception e) {
                        //ignore
                    }
                }
            }
        }
    }



    /**
     * @param str string
     * @return true if the string is null or empty
     */
    public static boolean isEmpty(@Nullable String str) {
        return str == null || str.isEmpty();
    }


    /**
     * @param str string
     * @return true if the string is "unknown"
     */


    /**
     * @param enumClass enum class
     * @param keyMapper key mapper
     * @param <E>       enum type
     * @param <K>       key type
     * @return map of a key to enum
     */
    public static <E extends Enum<E>, K> Map<K, E> mapEnum(@Nonnull Class<E> enumClass, @Nonnull Function<E, K> keyMapper) {
        Map<K, E> map = new HashMap<>();
        for (E enumVal : enumClass.getEnumConstants()) {
            final K key = keyMapper.apply(enumVal);
            final E oldVal = map.put(key, enumVal);
            if (oldVal != null) {
                throw new IllegalStateException(String.format("duplicate mapping for key=%s, value1=%s, value2=%s", key, oldVal, enumVal));
            }
        }
        return Map.copyOf(map);
    }


}