package dao;

import java.sql.SQLException;
import java.util.ArrayList;


public interface DAO<T>
{
    public boolean create(T objet) throws SQLException;
    public boolean update(T objet) throws SQLException;
    public boolean delete(T objet) throws SQLException;
    public T getById(int i) throws SQLException;
    public ArrayList<T> findAll() throws SQLException;
}
