package org.example.mime.beans;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * {@link ErrorNameSpace} keeps all the instances of given {@code InternalErrorCode} implementation class together and prevents code collision across
 * {@code InternalErrorCode} implementations. This facilitates independent error code enums inside an {@code InternalErrorCode} implementations.
 */

public enum ErrorNameSpace {
    WS(CMDAPIErrorCode.class);

    private static final Map<String, InternalErrorCode> errorCodeMsgToEnum = new HashMap<>();
    private static final Set<InternalErrorCode> allCodes;

    static {
        Set<InternalErrorCode> all = new HashSet<>();
        for (ErrorNameSpace s : ErrorNameSpace.values()) {
            for (InternalErrorCode internalErrorCode : s.internalCodeImplClass.getEnumConstants()) {
                if (null != errorCodeMsgToEnum.put(internalErrorCode.getErrorMessage(), internalErrorCode)) {
                    throw new IllegalStateException(String.format("duplicate mapping found for code=%s", internalErrorCode));
                }
                all.add(internalErrorCode);
            }
        }
        allCodes = Set.copyOf(all);
    }

    private final Class<? extends InternalErrorCode> internalCodeImplClass;

    ErrorNameSpace(Class<? extends InternalErrorCode> internalCodeImplClass) {
        this.internalCodeImplClass = internalCodeImplClass;
    }

    public static InternalErrorCode fromErrorMessage(final String errorMsg) {
        return errorCodeMsgToEnum.get(errorMsg);
    }

    public static Set<InternalErrorCode> getAllCodes() {
        return allCodes;
    }
}
