package com.wawelska.cache;

public interface CacheView {
    int size();//zwraca wielkość com.wawelska.cache.Cache’a

    CacheItem getItem(int index);//zwraca obiekt o podanym indeksie

    CacheItem getItem(String key);//zwraca obiekt o podanym kluczu

}
