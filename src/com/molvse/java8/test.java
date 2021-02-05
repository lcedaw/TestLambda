package com.molvse.java8;

import com.molvse.java8.entity.Employee;
import com.molvse.java8.service.MyPredicate;
import com.molvse.java8.serviceImpl.FilterEmployeeByAge;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class test {

    @Test
    public void test1(){
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        System.out.println(comparator.compare(1,5));
    }

    @Test
    public void test2(){
        Comparator<Integer> comparator = (x,y) -> Integer.compare(x,y);

        Comparator<Integer> comparator1 = (o1, o2) -> 0;

        System.out.println(comparator.compare(1,6));
    }

    @Test
    public void test3(){
        List<Employee> list = Arrays.asList(
                new Employee("张三",18,555.55),
                new Employee("李四",38,666.66)
        );
        List<Employee> a = filterEmployee(list,new FilterEmployeeByAge());
        for (Employee employee : a){
            System.out.println(employee);
        }

        System.out.println("--------------------------");

        List<Employee> noname = filterEmployee(list, new MyPredicate<Employee>() {
            @Override
            public boolean compare(Employee employee) {
                return employee.getAge() < 20;
            }
        });
        for (Employee employee : noname){
            System.out.println(employee);
        }

        System.out.println("--------------------------");

        List<Employee> lambdE = filterEmployee(list, (e) -> e.getSalary() < 600);
        for(Employee employee : lambdE){
            System.out.println(employee);
        }

        System.out.println("--------------------------");

        lambdE.forEach(System.out::println);

        System.out.println("--------------------------");

        list.stream()
            .filter((e) -> e.getSalary() < 600)
            .forEach(System.out::println);

        System.out.println("--------------------------");

        list.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> mp){
        List<Employee> employees = new ArrayList<>();

        for (Employee employee : list){
            if(mp.compare(employee)){
                employees.add(employee);
            }
        }

        return employees;
    }
}
