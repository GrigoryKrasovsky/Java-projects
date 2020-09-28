package com.foxminded.cache;

import java.util.Map;

public interface Cache<T,K> {
    void put(K key, T value);

    T get(K key);

    boolean contains(K key);
}
