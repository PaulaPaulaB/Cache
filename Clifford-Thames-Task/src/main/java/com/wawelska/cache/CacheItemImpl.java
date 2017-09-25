package com.wawelska.cache;

public class CacheItemImpl implements CacheItem {

    private final String key;
    private final Object value;

    CacheItemImpl(Object value, String key) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public Object getValue() {
        return this.value;
    }


}
