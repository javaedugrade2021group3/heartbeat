package com.edugrade.heartbeat.DAO;

import java.util.List;

public interface DAOInterface<T> {
    // public int updateData(T data);
    List<T> searchById(short id);
    List<T> getAll();
}
