package JavaFX.Controller.DAO;

import JavaFX.Controller.Client.ClientHolder;
import dao.DAO;
import dao.DAOFactory;
import dao.Persistance;

public class DAOHandler
{
    private DAOFactory daoFactory;
    private DAO dao;

    private final static DAOHandler INSTANCE = new DAOHandler();

    private DAOHandler() {}

    public static DAOHandler getInstance()
    {
        return INSTANCE;
    }


    public DAO getDao()
    {
        return dao;
    }

    public DAOFactory getDaoFactory() {
        return daoFactory;
    }

    public void setDaoFactory(Persistance persistance) {
        this.daoFactory = DAOFactory.getDAOFactory(persistance);
    }

    public void setDao(String table)
    {
        switch (table)
        {
            case "client" :{

            }
        }
    }


}
