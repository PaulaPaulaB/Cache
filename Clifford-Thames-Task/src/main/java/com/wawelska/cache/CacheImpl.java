package com.wawelska.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class CacheImpl implements Cache, CacheView {

    final private Map<String, CacheItem> storage;
    final private int capacity;

    CacheImpl(int capacity) {
        if(capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be equal or greater than 1.");
        }
        this.storage = new LinkedHashMap<>(16, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public synchronized CacheItem getItem(int index) {
        return (CacheItem) storage.values().toArray()[index];
    }

    @Override
    public synchronized CacheItem getItem(String key) {
        return storage.get(key);
    }

    @Override
    public synchronized CacheItem cacheItem(Object item, String key) {
        CacheItem cacheItem = new CacheItemImpl(item, key);
        if (storage.size() < capacity) {
            storage.put(key, cacheItem);
        } else{
            storage.remove(storage.entrySet().iterator().next().getKey());
            storage.put(key, cacheItem);
        }

        return cacheItem;
    }

    @Override
    public synchronized void  invalidateCache() {
        storage.clear();
    }

    @Override
    public CacheView getView() {
        return this;
    }
}
