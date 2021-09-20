package dao;

import dao.mysql.MySqlAbonnementDAO;

public class ListeMemoireDAOFactory extends DAOFactory
{

    @Override
    public AbonnementDAO getAbonnementDAO() 
    {
        return MySqlAbonnementDAO.getInstance();
    }

    @Override
    public ClientDAO getClientDAO() 
    {
        return null;
    }

    @Override
    public PeriodiciteDAO getPeriodiciteDAO() 
    {
        return null;
    }

    @Override
    public RevueDAO getRevueDAO() 
    {
        return null;
    }
    
}
