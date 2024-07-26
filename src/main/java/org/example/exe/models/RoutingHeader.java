package org.example.exe.models;

public class RoutingHeader {
    private Shard shard;
    private Long sid;
    public Shard getShard() {
        return shard;
    }
    public void setShard(Shard shard) {
        this.shard = shard;
    }
    public Long getSid() {
        return sid;
    }
    public void setSid(Long sid) {
        this.sid = sid;
    }
}
