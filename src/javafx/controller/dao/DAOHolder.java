package javafx.controller.dao;

import dao.DAOFactory;
import dao.Persistance;

public class DAOHolder
{
    private Persistance persistance = null;
    private DAOFactory daoFactory = null;
    private final static DAOHolder INSTANCE = new DAOHolder();

    private DAOHolder() {}

    public static DAOHolder getInstance()
    {
        return INSTANCE;
    }

    public DAOFactory getDaoFactory() {
        return daoFactory;
    }

    public Persistance getPersistance() {
        return persistance;
    }

    public void setDaoFactory(Persistance persistance)
    {
        this.persistance = persistance;
        this.daoFactory = DAOFactory.getDAOFactory(persistance);
    }

}
