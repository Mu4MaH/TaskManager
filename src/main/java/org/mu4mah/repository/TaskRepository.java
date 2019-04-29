package org.mu4mah.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mu4mah.api.entity.AbstractEntity;
import org.mu4mah.api.repository.IRepository;
import org.mu4mah.entity.Task;

import java.sql.*;
import java.util.*;

public class TaskRepository implements IRepository {

    private Connection connection;

    public TaskRepository(@NotNull Connection connection) {
        this.connection = connection;
    }

    public void persist(@NotNull AbstractEntity task) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO taskman.task (uid, name, parentprojectuid, datestart, dateend) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, task.getUID());
            ps.setString(2, task.getName());
            ps.setString(3, ((Task) task).getParentProjectUid());
            ps.setDate(4, (java.sql.Date) task.getDateStart());
            ps.setDate(5, (java.sql.Date) task.getDateEnd());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert ps != null;
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Nullable
    public AbstractEntity findOne(String uid) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("SELECT * FROM taskman.task WHERE uid=?");
            ps.setString(1, uid);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                return null;
            }
            final Task task = new Task();
            task.setUid(rs.getString("uid"));
            task.setName(rs.getString("name"));
            task.setParentProjectUid(rs.getString("parentprojectuid"));
            task.setDateStart(rs.getDate("datestart"));
            task.setDateEnd(rs.getDate("dateend"));
            return task;
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
    }

    @NotNull
    public List<Task> findAll() {
        List<Task> tasks = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM taskman.task");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                final Task task = new Task();
                task.setUid(rs.getString("uid"));
                task.setName(rs.getString("name"));
                task.setParentProjectUid(rs.getString("parentprojectuid"));
                task.setDateStart(rs.getDate("datestart"));
                task.setDateEnd(rs.getDate("dateend"));
                tasks.add(task);
            }
            return tasks;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<Task>();
        }
    }

    public void remove(String uid) {
        final Task task = (Task) findOne(uid);
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("DELETE FROM taskman.task WHERE uid=?");
            ps.setString(1, uid);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeAll() {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("DELETE FROM taskman.task");
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void merge(@NotNull List<Task> list) {
        for (Task e : list) {
            persist(e);
        }
    }

}
