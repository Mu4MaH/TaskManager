package org.mu4mah.repository;

import org.junit.Assert;
import org.junit.Test;
import org.mu4mah.entity.Assignee;
import org.mu4mah.entity.Employee;
import org.mu4mah.entity.Task;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AssigneeRepositoryTest {

    @Test
    public void persist() {
    }

    @Test
    public void getTasksByEmployee() {
        AssigneeRepository assigneeRepository = new AssigneeRepository();
        Employee employee = new Employee();
        employee.setName("emp1");
        employee.setLogin("emp1");
        employee.setPassword("12345");
        employee.setRole("tester");
        Task task1 = new Task();
        Task task2 = new Task();
        task1.setName("task1");
        task2.setName("task2");
        task1.setDateEnd(LocalDate.parse("2020-01-01"));
        task2.setDateEnd(LocalDate.parse("2021-01-01"));
        Assignee assignee1 = new Assignee();
        Assignee assignee2 = new Assignee();
        assignee1.setTaskUid(task1.getUid());
        assignee2.setTaskUid(task2.getUid());
        assignee1.setEmployeeUid(employee.getUID());
        assignee2.setEmployeeUid(employee.getUID());
        List<String> expected = new ArrayList<>();
        expected.add(task1.getUid());
        expected.add(task2.getUid());
        assigneeRepository.persist(assignee1);
        assigneeRepository.persist(assignee2);
        List<String> actual = assigneeRepository.getTasksByEmployee(employee.getUID());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getEmployeesByTask() {
    }

    @Test
    public void removeAssignee() {
    }

    @Test
    public void removeAll() {
    }

    @Test
    public void merge() {
    }

    @Test
    public void findAll() {
    }
}