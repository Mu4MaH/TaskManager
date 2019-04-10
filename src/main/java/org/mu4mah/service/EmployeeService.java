package org.mu4mah.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mu4mah.entity.Employee;
import org.mu4mah.repository.EmployeeRepository;

import java.util.Collection;
import java.util.List;

public class EmployeeService {

    private final EmployeeRepository employeeRepository = new EmployeeRepository();

    public void persist(@NotNull Employee employee) {
        employeeRepository.persist(employee);
    }

    @Nullable
    public Employee findOne(@NotNull String uid) {
        if (uid.isEmpty()) return null;
        return employeeRepository.findOne(uid);
    }

    @NotNull public Collection<Employee> findAll() {
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
