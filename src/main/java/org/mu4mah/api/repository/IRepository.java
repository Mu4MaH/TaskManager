package org.mu4mah.api.repository;

import org.mu4mah.api.entity.AbstractEntity;

import java.sql.SQLException;
import java.util.Collection;

public interface IRepository <E extends AbstractEntity> {

    void persist(E entity) throws SQLException;

    E findOne(String s);

    Collection<E> findAll();

    void remove(String uid);

    void removeAll();

}
