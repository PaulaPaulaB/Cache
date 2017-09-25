package com.wawelska.cache;

public interface CacheItem {

    String getKey(); // zwraca klucz obiektu

    Object getValue(); //zwraca obiekt zapisanych w com.wawelska.cache.Cache’u

}
