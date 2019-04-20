package org.mu4mah.repository;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mu4mah.api.entity.AbstractEntity;
import org.mu4mah.api.repository.IRepository;
import org.mu4mah.entity.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
public class EmployeeRepository implements IRepository {

    private final Map<String, AbstractEntity> staff = new HashMap<>();

    @Override
    public void persist(AbstractEntity employee) {
        staff.put(employee.getUID(), employee);
    }

    @Nullable
    public AbstractEntity findOne(String uid) {
        return staff.get(uid);
    }

    @Override
    @NotNull
    public Collection<AbstractEntity> findAll() {
        return staff.values();
    }

    @Override
    public void remove(String uid) {
        staff.remove(uid);
    }

    @Override
    public void removeAll() {
        staff.clear();
    }

    public void merge(@NotNull List<Employee> list) {
        for (Employee e : list) {
            staff.put(e.getUID(), e);
        }
    }

}
