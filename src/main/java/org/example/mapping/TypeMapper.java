package org.example.mapping;

public interface TypeMapper<T, V> {
    V map(T tObject);
}
