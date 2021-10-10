package com.javafx.Modele.dao;


import com.javafx.Modele.dao.mysql.MySqlAbonnementDAO;
import com.javafx.Modele.dao.mysql.MySqlClientDAO;
import com.javafx.Modele.dao.mysql.MySqlPeriodiciteDAO;
import com.javafx.Modele.dao.mysql.MySqlRevueDAO;

public class MySQLDAOFactory extends DAOFactory
{

    @Override
    public AbonnementDAO getAbonnementDAO()
    {
        return MySqlAbonnementDAO.getInstance();
    }

    @Override
    public ClientDAO getClientDAO()
    {
        return MySqlClientDAO.getInstance();
    }

    @Override
    public PeriodiciteDAO getPeriodiciteDAO()
    {
        return MySqlPeriodiciteDAO.getInstance();
    }

    @Override
    public RevueDAO getRevueDAO()
    {
        return MySqlRevueDAO.getInstance();
    }
    
}
