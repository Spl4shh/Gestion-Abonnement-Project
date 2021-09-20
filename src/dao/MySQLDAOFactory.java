package dao;

import dao.mysql.MySqlAbonnementDAO;
import dao.mysql.MySqlClientDAO;
import dao.mysql.MySqlPeriodiciteDAO;
import dao.mysql.MySqlRevueDAO;

public class MySQLDAOFactory extends DAOFactory {

    @Override
    public AbonnementDAO getAbonnementDAO() {
        return MySqlAbonnementDAO.getInstance();
    }

    @Override
    public ClientDAO getClientDAO() {
        return MySqlClientDAO.getInstance();
    }

    @Override
    public PeriodiciteDAO getPeriodiciteDAO() {
        return MySqlPeriodiciteDAO.getInstance();
    }

    @Override
    public RevueDAO getRevueDAO() {
        return MySqlRevueDAO.getInstance();
    }
    
}
