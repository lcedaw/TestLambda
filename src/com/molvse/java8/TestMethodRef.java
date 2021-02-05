package com.molvse.java8;

import com.molvse.java8.entity.Employee;
import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 方法引用：若Lambda体中的内容有方法已经实现了，我们可以使用“方法引用”
 *          （可以理解为方法引用是Lambda表达式的另外一种表现形式）
 *
 * 主要有三种语法格式：
 *
 * 对象::实例方法名
 *
 * 类::静态方法名
 *
 * 类::实例方法名
 */
public class TestMethodRef {

    //对象：实例方法名
    @Test
    public void test1(){
        Consumer<String> con = (s) -> System.out.println(s);
        Consumer<String> con1 = System.out::println;//con.accept()中的参数列表和返回值要与pritln()一致

        con.accept("abcd");
        con1.accept("abcd1");
    }

    @Test
    public void test2(){
        Employee employee = new Employee();
        employee.setName("张三");
        Supplier<String> sup1 = () -> employee.getName();
        Supplier<String> sup2 = employee::getName;

        System.out.println(sup1.get());
        System.out.println(sup2.get());
    }

    //类：静态方法名
    @Test
    public void test3(){
        
    }
}
