package com.wawelska.cache;

import org.junit.Test;

import static org.junit.Assert.*;

public class CacheImplTest {


    @Test(expected = IllegalArgumentException.class)
    public void cacheCreationWithCapacityZeroShouldThrowException() {
        new CacheImpl(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cacheCreationWithNegativeCapacityShouldThrowException() {
        new CacheImpl(-1);
    }

    @Test
    public void cacheItemReturnCachedEntry() {
        CacheImpl cache = new CacheImpl(1);
        CacheItem cacheItem = cache.cacheItem("item", "key");
        assertEquals("key", cacheItem.getKey());
        assertEquals("item", cacheItem.getValue());
    }

    @Test
    public void cacheShouldStoreAnyValue() {
        CacheImpl cache = new CacheImpl(2);
        cache.cacheItem("string", "a");
        cache.cacheItem(1, "b");
        cache.cacheItem(new Object(), "c");
    }

    @Test
    public void cacheKeepsOrderOfItems() {
        CacheImpl cache = new CacheImpl(3);
        cache.cacheItem("A", "a");
        cache.cacheItem("B", "b");
        cache.cacheItem("C", "c");

        assertEquals(3, cache.size());

        assertEquals("A", cache.getItem(0).getValue());
        assertEquals("B", cache.getItem(1).getValue());
        assertEquals("C", cache.getItem(2).getValue());
    }

    @Test
    public void cacheRemovesEldestItemOnCapacityExceed() {
        CacheImpl cache = new CacheImpl(2);
        cache.cacheItem("A", "a");
        cache.cacheItem("B", "b");
        cache.cacheItem("A", "a");

        assertEquals("B", cache.getItem(0).getValue());
        assertEquals("A", cache.getItem(1).getValue());
    }


    @Test
    public void SizeTestWhenCacheIsEmpty() {
        CacheImpl cache = new CacheImpl(2);
        assertEquals(0, cache.size());
    }

    @Test
    public void getItemByIndexWhenIndexIsInRange() {
        CacheImpl cache = new CacheImpl(2);
        cache.cacheItem("A", "a");
        cache.cacheItem("B", "b");
        assertEquals("B", cache.getItem(1).getValue());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getItemByIndexWhenIndexIsInOutOfRange() {
        CacheImpl cache = new CacheImpl(1);
        cache.cacheItem("A", "a");
        cache.getItem(10).getValue();
    }

    @Test
    public void getItemByKeyWhenKeyIsCorrect() {
        CacheImpl cache = new CacheImpl(2);
        cache.cacheItem("A", "a");
        cache.cacheItem("B", "b");
        assertEquals("B", cache.getItem("b").getValue());
    }

    @Test
    public void getItemByKeyWithNoKeyShouldReturnNull() {
        CacheImpl cache = new CacheImpl(1);
        assertNull(cache.getItem("anyKey"));
    }

    @Test
    public void invalidateShouldClearCache() {
        CacheImpl cache = new CacheImpl(2);
        cache.cacheItem("A", "a");
        cache.cacheItem("B", "b");
        cache.invalidateCache();
        assertEquals(0, cache.size());
    }

    @Test
    public void invalideCacheOnEmptyCacheTest() {
        CacheImpl cache = new CacheImpl(2);
        cache.invalidateCache();
        assertEquals(0, cache.size());
    }

    @Test
    public void getViewShouldReturnSameObject() {
        Cache cache = new CacheImpl(1);
        assertSame(cache, cache.getView());
    }

}
