import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.AbonnementDAO;
import dao.ClientDAO;
import dao.DAOFactory;
import dao.PeriodiciteDAO;
import dao.Persistance;
import dao.RevueDAO;
import metier.Abonnement;
import metier.Client;
import metier.Periodicite;
import metier.Revue;

public class Main
{

    public static void main(String[] args) throws SQLException 
    {
        Scanner sc = new Scanner(System.in);

        Persistance persistance;
        boolean continueOperation = false;
        DAOFactory daoUse;

        System.out.println("Indiquez le numero du moyen de persistance choisi : \n1 - MySQL \n2 - Liste Memoire");
        int choixPersistance = sc.nextInt();
        sc.nextLine();

        switch (choixPersistance) 
        {
            case 1:
                persistance = Persistance.MYSQL;
                break;
        
            case 2 : 
                persistance = Persistance.ListeMemoire;
                break;

            default :
                System.out.println("Persistance par defaut : MySQL");
                persistance = Persistance.MYSQL;
                break;
        }

        daoUse = DAOFactory.getDAOFactory(persistance);

        do 
        {
            try
            {
                int choixTable;
                do
                {
                    System.out.println("\n1- Client \n2- Abonnement \n3- Revue \n4- Periodicite");
                    choixTable = sc.nextInt();
                    sc.nextLine();
                }while(choixTable > 4 || choixTable < 1);

                switch(choixTable)
                {
                    case 1 :
                    {
                        ClientDAO daoClient = daoUse.getClientDAO();

                        System.out.println("Bienvenue dans la partie Client");
                        System.out.println("1- Ajouter \n2- Supprimer \n3- Edit \n4- Affichez tout \n5- Rechercher par ID \n6- Rechercher par Nom et Prenom \n7- Rechercher par Adresse");

                        try
                        {
                            int numChoix = sc.nextInt();
                            sc.nextLine();
                            switch (numChoix)
                            {
                                case 1 :
                                {
                                    System.out.println("Indiquer le nom du client");
                                    String nom = sc.nextLine();
                                    System.out.println("Indiquer le prenom du client");
                                    String prenom = sc.nextLine();
                                    System.out.println("Indiquer le n° de la rue");
                                    String noRue = sc.nextLine();
                                    System.out.println("Indiquer le nom de la rue");
                                    String voie = sc.nextLine();
                                    System.out.println("Indiquer le code Postal");
                                    String codePostal = sc.nextLine();
                                    System.out.println("Indiquer le nom de la ville");
                                    String ville = sc.nextLine();
                                    System.out.println("Indiquer le nom du Pays");
                                    String pays = sc.nextLine();
                                    daoClient.create(new Client(nom, prenom, noRue, voie, codePostal, ville, pays));
                                    break;
                                }
                                case 2 :
                                {
                                    System.out.println("Indiquer l'ID du Client à supprimer");
                                    int id = sc.nextInt();
                                    sc.nextLine();
                                    daoClient.delete(new Client(id));
                                    break;
                                }
                                case 3 :
                                {
                                    System.out.println("Indiquer le l'ID du client");
                                    int id = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("Indiquer le nom du client");
                                    String nom = sc.nextLine();
                                    System.out.println("Indiquer le prenom du client");
                                    String prenom = sc.nextLine();
                                    System.out.println("Indiquer le n° de la rue");
                                    String noRue = sc.nextLine();
                                    System.out.println("Indiquer le nom de la rue");
                                    String voie = sc.nextLine();
                                    System.out.println("Indiquer le code Postal");
                                    String codePostal = sc.nextLine();
                                    System.out.println("Indiquer le nom de la ville");
                                    String ville = sc.nextLine();
                                    System.out.println("Indiquer le nom du Pays");
                                    String pays = sc.nextLine();
                                    daoClient.update(new Client(id, nom, prenom, noRue, voie, codePostal, ville, pays));
                                    break;
                                }
                                case 4 :
                                {
                                    List<Client> listeClient = new ArrayList<Client>();

                                    listeClient = daoClient.findAll();
                                    for (Client client : listeClient) 
                                    {
                                        System.out.println(client.toString());
                                    }
                                    break;
                                }
                                case 5 :
                                {

                                    System.out.println("Indiquer l'ID à rechercher");
                                    int id = sc.nextInt();
                                    sc.nextLine();

                                    Client client = daoClient.getById(id);
                                    System.out.println(client.toString());

                                    break;
                                }
                                case 6 :
                                {
                                    List<Client> listeClient = new ArrayList<Client>();

                                    System.out.println("Indiquer le nom de la personne à rechercher");
                                    String nom = sc.nextLine();
                                    System.out.println("Puis le prenom");
                                    String prenom = sc.nextLine();

                                    //Affichage du resultat
                                    listeClient = daoClient.getByNomPrenom(nom, prenom);
                                    for (Client client : listeClient) 
                                    {
                                        System.out.println(client.toString());
                                    }
                                    break;
                                }
                                case 7 :
                                {
                                    List<Client> listeClient = new ArrayList<Client>();

                                    System.out.println("Indiquer le n° de la rue");
                                    String noRue = sc.nextLine();
                                    System.out.println("Indiquer le nom de la rue");
                                    String voie = sc.nextLine();
                                    System.out.println("Indiquer le code Postal");
                                    String codePostal = sc.nextLine();

                                    //Affichage du resultat
                                    listeClient = daoClient.getByAdresse(noRue, voie, codePostal);
                                    for (Client client : listeClient) 
                                    {
                                        System.out.println(client.toString());
                                    }
                                    break;
                                }
                            }
                        }
                        catch (Exception e)
                        {
                            System.out.println(e);
                        }
                        break;
                    }
                    case 2 :
                    {
                        AbonnementDAO daoAbonnement = daoUse.getAbonnementDAO();

                        System.out.println("\nBienvenue dans la partie Abonnement");
                        System.out.println("1- Ajouter \n2- Supprimer \n3- Edit \n4- Affichez tout \n5- Rechercher par ID \n6- Selectionner par Date \n7- Selectionner par Nom-Prenom");

                        try
                        {
                            int numChoix = sc.nextInt();
                            sc.nextLine();
                            switch (numChoix)
                            {
                                case 1 :
                                {

                                    DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                                    System.out.println("Indiquer la date de debut de l'abonnement à ajouter \nAu format JJ/MM/AAAA");

                                    String dateDebutJava = sc.nextLine();

                                    LocalDate dateDebutFormate = LocalDate.parse(dateDebutJava, formatage);

                                    System.out.println("Indiquer la date de fin de l'abonnement à ajouter \nAu format JJ/MM/AAAA");
                                    String dateFinJava = sc.nextLine();

                                    LocalDate dateFinFormate = LocalDate.parse(dateFinJava, formatage);
                                

                                    System.out.println("Indiquer l'ID du Client de l'abonnement à ajouter");
                                    int idClient = sc.nextInt();
                                    sc.nextLine();

                                    System.out.println("Indiquer l'ID de la Revue à ajouter");
                                    int idRevue = sc.nextInt();
                                    sc.nextLine();

                                    daoAbonnement.create(new Abonnement(dateDebutFormate, dateFinFormate, idClient, idRevue));
                                    break;
                                }
                                case 2 :
                                {
                                    System.out.println("Indiquer l'ID de l'abonnement à supprimer");
                                    int id = sc.nextInt();
                                    sc.nextLine();
                                    daoAbonnement.delete(new Abonnement(id));
                                    break;
                                }
                                case 3 :
                                {
                                    DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                                    System.out.println("Indiquer l'ID de la l'abonnement à modifier");
                                    int id = sc.nextInt();
                                    sc.nextLine();

                                    System.out.println("Indiquer la date de debut de l'abonnement à modifier \nAu format JJ/MM/AAAA");
                                    String dateDebutJava = sc.nextLine();

                                    LocalDate dateDebutFormate = LocalDate.parse(dateDebutJava, formatage);

                                    System.out.println("Indiquer la date de fin de l'abonnement à modifier \nAu format JJ/MM/AAAA");
                                    String dateFinJava = sc.nextLine();

                                    LocalDate dateFinFormate = LocalDate.parse(dateFinJava, formatage);

                                    System.out.println("Indiquer l'ID du Client de l'abonnement à modifier");
                                    int idClient = sc.nextInt();
                                    sc.nextLine();

                                    System.out.println("Indiquer l'ID de la Revue à modifier");
                                    int idRevue = sc.nextInt();
                                    sc.nextLine();

                                    daoAbonnement.update(new Abonnement(id, dateDebutFormate, dateFinFormate, idClient, idRevue));
                                    break;
                                }
                                case 4 :
                                {
                                    List<Abonnement> listeAbonnement = new ArrayList<Abonnement>();

                                    listeAbonnement = daoAbonnement.findAll();
                                    for (Abonnement abonnement : listeAbonnement) 
                                    {
                                        System.out.println(abonnement.toString());   
                                    }
                                    break;
                                }
                                case 5 :
                                {

                                    System.out.println("Indiquer l'ID à rechercher");
                                    int id = sc.nextInt();
                                    sc.nextLine();

                                    Abonnement abonnement = daoAbonnement.getById(id);
                                    System.out.println(abonnement.toString());

                                    break;
                                }
                                case 6 :
                                {
                                    DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                    List<Abonnement> listeAbonnement = new ArrayList<Abonnement>();

                                    System.out.println("Indiquer la date de debut de l'abonnement à rechercher \nAu format JJ/MM/AAAA");
                                    String dateDebutJava = sc.nextLine();

                                    LocalDate dateDebutFormate = LocalDate.parse(dateDebutJava, formatage);

                                    System.out.println("Indiquer la date de fin de l'abonnement à rechercher \nAu format JJ/MM/AAAA");
                                    String dateFinJava = sc.nextLine();

                                    LocalDate dateFinFormate = LocalDate.parse(dateFinJava, formatage);

                                    //Affichage du resultat
                                    listeAbonnement = daoAbonnement.getByDate(dateDebutFormate, dateFinFormate);
                                    for (Abonnement abonnement : listeAbonnement) 
                                    {
                                        System.out.println(abonnement.toString());
                                    }
                                    break;
                                }

                                case 7 :
                                {
                                    List<Abonnement> listeAbonnement = new ArrayList<Abonnement>();

                                    System.out.println("Indiquer le nom de la personne à rechercher");
                                    String nom = sc.nextLine();
                                    System.out.println("Puis le prenom");
                                    String prenom = sc.nextLine();

                                    //Affichage du resultat
                                    listeAbonnement = daoAbonnement.getByNomPrenom(nom, prenom);
                                    for (Abonnement abonnement : listeAbonnement) 
                                    {
                                        System.out.println(abonnement.toString());
                                    }
                                    break;
                                }
                            }
                        }
                        catch (Exception e)
                        {
                            System.out.println(e);
                        }
                        break;
                    }
                    case 3 :
                    {
                        RevueDAO daoRevue = daoUse.getRevueDAO();
                        //Partie sur la revue a ajouter
                        System.out.println("\nBienvenue dans la partie Revue");
                        System.out.println("1- Ajouter \n2- Supprimer \n3- Edit \n4- Affichez tout \n5- Rechercher par ID \n6- Rechercher par Titre");

                        try
                        {
                            int numChoix = sc.nextInt();
                            sc.nextLine();
                            switch (numChoix)
                            {
                                case 1 :
                                {
                                    System.out.println("Indiquer le titre de la Revue a ajouter");
                                    String titre = sc.nextLine();
                                    System.out.println("Indiquer la description de la Revue a ajouter");
                                    String description = sc.nextLine();
                                    System.out.println("Indiquer le tarif de la Revue a ajouter");
                                    float tarifNumero = sc.nextFloat();
                                    sc.nextLine();
                                    System.out.println("Indiquer le visuel de la Revue a ajouter");
                                    String visuel = sc.nextLine();
                                    System.out.println("Indiquer l'ID de la periodicite a laquelle se refere la Revue a ajouter");
                                    int idPeriodicite = sc.nextInt();
                                    sc.nextLine();

                                    daoRevue.create(new Revue(titre, description, tarifNumero, visuel, idPeriodicite));
                                    break;
                                }
                                case 2 :
                                {
                                    System.out.println("Indiquer l'ID de la la Revue à supprimer");
                                    int idRevue = sc.nextInt();
                                    sc.nextLine();

                                    daoRevue.delete(new Revue(idRevue));
                                    break;
                                }
                                case 3 :
                                {
                                    System.out.println("Indiquer l'ID de la la Revue à modifier");
                                    int idRevue = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("Indiquer le titre de la Revue a modifier");
                                    String titre = sc.nextLine();
                                    System.out.println("Indiquer la description de la Revue a modifier");
                                    String description = sc.nextLine();
                                    System.out.println("Indiquer le tarif de la Revue a modifier");
                                    float tarifNumero = sc.nextFloat();
                                    sc.nextLine();
                                    System.out.println("Indiquer le visuel de la Revue a modifier");
                                    String visuel = sc.nextLine();
                                    System.out.println("Indiquer l'ID de la periodicite a laquelle se refere la Revue a modifier");
                                    int idPeriodicite = sc.nextInt();
                                    sc.nextLine();

                                    daoRevue.update(new Revue(idRevue, titre, description, tarifNumero, visuel, idPeriodicite));
                                    break;
                                }
                                case 4 :
                                {
                                    List<Revue> listeRevue = new ArrayList<Revue>();

                                    listeRevue = daoRevue.findAll();
                                    for (Revue revue : listeRevue) 
                                    {
                                        System.out.println(revue.toString());
                                    }
                                    break;
                                }
                                case 5 :
                                {

                                    System.out.println("Indiquer l'ID à rechercher");
                                    int id = sc.nextInt();
                                    sc.nextLine();

                                    Revue revue = daoRevue.getById(id);
                                    System.out.println(revue.toString());

                                    break;
                                }
                                case 6 :
                                {
                                    List<Revue> listeRevue = new ArrayList<Revue>();

                                    System.out.println("Indiquer le titre de la Revue à rechercher");
                                    String titre = sc.nextLine();

                                    listeRevue = daoRevue.getByTitre(titre);
                                    for (Revue revue : listeRevue) 
                                    {
                                        System.out.println(revue.toString());
                                    }

                                    break;
                                }
                            }
                        }
                        catch (Exception e)
                        {
                            System.out.println(e);
                        }
                        break;
                    }
                    case 4 :
                    {
                        PeriodiciteDAO daoPeriodicite = daoUse.getPeriodiciteDAO();

                        System.out.println("Bienvenue dans la partie Périodicité");
                        System.out.println("\n1- Ajouter \n2- Supprimer \n3- Edit \n4- Affichez tout \n5- Rechercher par ID \n6- Rechercher par Libellé\n");

                        try
                        {
                            int numChoix = sc.nextInt();
                            sc.nextLine();
                            switch (numChoix)
                            {
                                case 1 :
                                {
                                    System.out.println("Indiquer le libellé");
                                    String libelle = sc.nextLine();
                                    daoPeriodicite.create(new Periodicite(libelle));
                                    break;
                                }
                                case 2 :
                                {
                                    System.out.println("Indiquer l'ID de la périodicité à supprimer");
                                    int id = sc.nextInt();
                                    sc.nextLine();
                                    daoPeriodicite.delete(new Periodicite(id));
                                    break;
                                }
                                case 3 :
                                {
                                    System.out.println("Indiquer l'ID de la périodicité à modifier puis le libellé");
                                    int id = sc.nextInt();
                                    sc.nextLine();
                                    String libelle = sc.nextLine();
                                    daoPeriodicite.update(new Periodicite(id, libelle));
                                    break;
                                }
                                case 4 :
                                {
                                    List<Periodicite> listePeriodicite = new ArrayList<Periodicite>();

                                    listePeriodicite = daoPeriodicite.findAll();

                                    System.out.println();   
                                    for (Periodicite periodicite : listePeriodicite) 
                                    {
                                        System.out.println(periodicite.toString());   
                                    }
                                    break;
                                }
                                case 5 :
                                {

                                    System.out.println("Indiquer l'ID à rechercher");
                                    int id = sc.nextInt();
                                    sc.nextLine();

                                    Periodicite periodicite = daoPeriodicite.getById(id);
                                    System.out.println(periodicite.toString());

                                    break;
                                }
                                case 6 :
                                {
                                    List<Periodicite> listePeriodicite = new ArrayList<Periodicite>();

                                    System.out.println("Indiquer le libellé");
                                    String libelle = sc.nextLine();

                                    listePeriodicite = daoPeriodicite.getByLibelle(libelle);
                                    for (Periodicite periodicite : listePeriodicite) 
                                    {
                                        System.out.println(periodicite.toString());
                                    }
                                    break;
                                }
                            }
                        }
                        catch (Exception e)
                        {
                            System.out.println(e);
                        }
                        break;
                    }
                }
            }
            catch (Exception e)
            {
                System.out.println(e);
            }

            System.out.println("Voulez vous continuer ? Y/N\n");
            String test = sc.nextLine().toLowerCase();
            continueOperation = (test.equals("y"));


        } while(continueOperation);
        sc.close();
    }
}
