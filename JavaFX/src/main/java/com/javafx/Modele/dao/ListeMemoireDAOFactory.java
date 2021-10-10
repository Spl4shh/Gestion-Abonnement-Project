package com.javafx.Modele.dao;

import com.javafx.Modele.dao.listememoire.ListeMemoireAbonnementDAO;
import com.javafx.Modele.dao.listememoire.ListeMemoireClientDAO;
import com.javafx.Modele.dao.listememoire.ListeMemoirePeriodiciteDAO;
import com.javafx.Modele.dao.listememoire.ListeMemoireRevueDAO;

public class ListeMemoireDAOFactory extends DAOFactory
{

    @Override
    public ListeMemoireAbonnementDAO getAbonnementDAO()
    {
        return ListeMemoireAbonnementDAO.getInstance();
    }

    @Override
    public ClientDAO getClientDAO()
    {
        return ListeMemoireClientDAO.getInstance();
    }

    @Override
    public PeriodiciteDAO getPeriodiciteDAO()
    {
        return ListeMemoirePeriodiciteDAO.getInstance();
    }

    @Override
    public RevueDAO getRevueDAO()
    {
        return ListeMemoireRevueDAO.getInstance();
    }
    
}
