package JavaFX.Controller.DAO;

import dao.DAO;
import dao.DAOFactory;
import dao.Persistance;

import java.util.Locale;

public class DAOHolder
{
    private DAOFactory daoFactory;
    private final static DAOHolder INSTANCE = new DAOHolder();

    private DAOHolder() {}

    public static DAOHolder getInstance()
    {
        return INSTANCE;
    }

    public DAOFactory getDaoFactory() {
        return daoFactory;
    }

    public void setDaoFactory(Persistance persistance) {
        this.daoFactory = DAOFactory.getDAOFactory(persistance);
    }

}
