package com.wawelska.cache;

public interface Cache {

    CacheItem cacheItem(Object item, String key);//zapisuje obiekt w com.wawelska.cache.Cache’u

    void invalidateCache();//czyści nasz com.wawelska.cache.Cache

    CacheView getView();//zwraca “widok” na nasz com.wawelska.cache.Cache
}
