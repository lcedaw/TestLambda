package com.molvse.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Java8 内置四大核心函数式接口
 *
 * Comsumer<T> 消费型接口
 *      void accept(T t);
 *
 * Sopplier<T> 供给型接口
 *      T get();
 *
 * Function<T,R> 函数型接口
 *      R apply(T t);
 *
 * Predicate<T> 断言型接口
 *      boolean test(T t);
 */
public class testLambda1 {

    List<String> list = Arrays.asList("abc","abcde");

    @Test
    public void test1(){
        List<String> newList = filterStr(list,(str) -> {
            if(str.length() > 3) return false;
            return true;
        });
        newList.forEach(System.out::println);
    }

    public List<String> filterStr(List<String> list, Predicate<String> pre){
        List<String> newList = new ArrayList<>();

        for (String str : list){
            if(pre.test(str)) newList.add(str);
        }

        return newList;
    }
}
