package org.mu4mah.repository;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mu4mah.entity.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
public class EmployeeRepository {

    private final Map<String, Employee> staff = new HashMap<>();

    public void persist(Employee employee) {
        staff.put(employee.getUID(), employee);
    }

    @Nullable
    public Employee findOne(String uid) {
        return staff.get(uid);
    }

    @NotNull
    public Collection<Employee> findAll() {
        return staff.values();
    }

    public void remove(String uid) {
        staff.remove(uid);
    }

    public void removeAll() {
        staff.clear();
    }

    public void merge(List<Employee> list) {
        for (Employee e : list) {
            staff.put(e.getUID(), e);
        }
    }

}
