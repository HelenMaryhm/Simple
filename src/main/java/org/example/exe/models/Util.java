package org.example.exe.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Base64;

public final class Util {

    private Util() {
    }

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String getShardHeader(String instance, String database, Integer shardId, Long sid) throws JsonProcessingException {
        Info info = new Info();
        info.setInstance(instance);
        info.setDb(database);

        Shard shard = new Shard();
        shard.setId(shardId);
        shard.setInfo(info);

        RoutingHeader routingHeader = new RoutingHeader();
        routingHeader.setSid(sid);
        routingHeader.setShard(shard);

        return Base64.getEncoder().encodeToString(objectMapper.writeValueAsBytes(routingHeader));
    }

    public static String getReversedSid(Long sid) {
        return String.valueOf(Long.reverseBytes(sid));
    }
}
