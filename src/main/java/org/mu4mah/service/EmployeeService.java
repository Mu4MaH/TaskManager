package org.mu4mah.service;

import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mu4mah.api.entity.AbstractEntity;
import org.mu4mah.entity.Employee;
import org.mu4mah.repository.EmployeeRepository;

import java.sql.Connection;
import java.util.Collection;
import java.util.List;

public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(@NotNull Connection connection) {
        employeeRepository = new EmployeeRepository(connection);
    }

    public void persist(@NotNull Employee employee) {
        employeeRepository.persist(employee);
    }

    @Nullable
    public Employee findOne(@NotNull String uid) {
        if (uid.isEmpty()) return null;
        return (Employee) employeeRepository.findOne(uid);
    }

    public @NotNull Collection<AbstractEntity> findAll() {
        return employeeRepository.findAll();
    }

    public void remove(@NotNull String uid) {
        if (uid.isEmpty()) return;
        employeeRepository.remove(uid);
    }

    public void removeAll() {
        employeeRepository.removeAll();
    }

    public void merge(@NotNull List<Employee> list) {
        employeeRepository.merge(list);
    }
}
