package JavaFX.Controller.DAO;

import dao.DAO;
import dao.DAOFactory;
import dao.Persistance;

import java.util.Locale;

public class DAOHolder
{
    private DAOFactory daoFactory;
    private DAO<?> dao;
    private final static DAOHolder INSTANCE = new DAOHolder();
    private DAOHolder() {}
    public static DAOHolder getInstance()
    {
        return INSTANCE;
    }
    public DAO<?> getDao() {
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
        table = table.toLowerCase();
        switch (table)
        {
            case "client" :
            {
                dao = daoFactory.getClientDAO();
                break;
            }
            case "abonnement" :
            {
                dao = daoFactory.getAbonnementDAO();
                break;
            }
            case "periodicite" :
            {
                dao = daoFactory.getPeriodiciteDAO();
                break;
            }
            case "revue" :
            {
                dao = daoFactory.getRevueDAO();
                break;
            }
        }
    }
}
