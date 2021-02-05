package com.molvse.java8.service;

@FunctionalInterface
public interface MathPridicate<T,R> {

    public R getValue(T t1, T t2);
}
