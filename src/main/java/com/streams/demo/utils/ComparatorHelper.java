package com.streams.demo.utils;

import com.streams.demo.entity.Employee;

import java.util.Comparator;

public class ComparatorHelper implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2) {
        if(e1.getSalary() < e2.getSalary())
        {
            return -1;
        } else if (e1.getSalary() == e2.getSalary()) {
            return 0;
        }
        else
        {
            return 1;
        }
    }

}
