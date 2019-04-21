package org.mu4mah.repository;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mu4mah.api.entity.AbstractEntity;
import org.mu4mah.api.repository.IRepository;
import org.mu4mah.entity.Employee;

import java.util.*;

@NoArgsConstructor
public class EmployeeRepository implements IRepository {

    private final Map<String, AbstractEntity> stuff = new HashMap<>();

    @Override
    public void persist(AbstractEntity employee) {
        stuff.put(employee.getUID(), employee);
    }

    @Nullable
    public AbstractEntity findOne(String uid) {
        return stuff.get(uid);
    }

    @Override
    @NotNull
    public ArrayList<AbstractEntity> findAll() {
        return new ArrayList<>(stuff.values());
    }

    @Override
    public void remove(String uid) {
        stuff.remove(uid);
    }

    @Override
    public void removeAll() {
        stuff.clear();
    }

    public void merge(@NotNull List<Employee> list) {
        for (Employee e : list) {
            stuff.put(e.getUID(), e);
        }
    }

}
