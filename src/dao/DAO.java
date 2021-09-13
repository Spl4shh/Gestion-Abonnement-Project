package dao;

import java.util.ArrayList;

public interface DAO<T>
{
    public boolean create(T objet);
    public boolean update(T objet);
    public boolean delete(T objet);
    public T getById(int i);
    public ArrayList<T> findAll();
}
