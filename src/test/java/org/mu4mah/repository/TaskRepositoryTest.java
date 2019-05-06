package org.mu4mah.repository;

import org.junit.Assert;
import org.junit.Test;
import org.mu4mah.entity.Task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TaskRepositoryTest {

    @Test
    public void persist() throws SQLException {
        final String DBUSER = "postgres";
        final String DBPASS = "postgres";
        final String DBURL = "jdbc:postgresql://localhost:5432/postgres";
        Connection connection = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        TaskRepository taskRepository = new TaskRepository(connection);
        Task task1 = new Task();
        Task task2 = new Task();
        task1.setName("task1");
        task2.setName("task2");
        task1.setDateEnd(LocalDate.parse("2020-01-01"));
        task2.setDateEnd(LocalDate.parse("2021-01-01"));
        List<Task> expected = new ArrayList<>();
        expected.add(task1);
        expected.add(task2);
        taskRepository.persist(task1);
        taskRepository.persist(task2);
        List<Task> actual = taskRepository.findAll();
        Assert.assertEquals(expected, actual);
    }
}