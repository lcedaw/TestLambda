package com.molvse.java8.service;

import com.molvse.java8.entity.Employee;

@FunctionalInterface
public interface MyPredicate<T> {

    public boolean compare(T t);

}
