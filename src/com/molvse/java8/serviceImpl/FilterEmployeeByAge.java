package com.molvse.java8.serviceImpl;

import com.molvse.java8.entity.Employee;
import com.molvse.java8.service.MyPredicate;

public class FilterEmployeeByAge implements MyPredicate<Employee> {
    @Override
    public boolean compare(Employee employee) {
        return employee.getAge() > 35;
    }
}
