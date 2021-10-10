package com.javafx.Modele.dao;

import com.javafx.Modele.metier.Periodicite;

import java.sql.SQLException;
import java.util.List;

public interface PeriodiciteDAO extends DAO<Periodicite>
{
    public List<Periodicite> getByLibelle(String libelle) throws SQLException;
}
