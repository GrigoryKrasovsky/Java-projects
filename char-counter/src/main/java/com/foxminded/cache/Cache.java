package com.foxminded.cache;

public interface Cache<T, K> {
    void put(K key, T value);

    T get(K key);

    boolean contains(K key);
}
