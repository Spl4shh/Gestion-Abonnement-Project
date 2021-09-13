import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Date;

public class Main
{
    public static void main(String[] args) throws SQLException {
        Periodicite periodicite = new Periodicite();
        Client client = new Client();
        Abonnement abonnement = new Abonnement();
        Revue revue = new Revue();

        boolean continueOperation = false;
        do 
        {
            Scanner sc = new Scanner(System.in);

            try
            {
                System.out.println("1- Client \n2- Abonnement \n3- Revue \n4- Periodicite");
                int choixTable = Integer.parseInt(sc.nextLine());

                while(choixTable > 4 || choixTable < 1)
                {
                    System.out.println("1- Client \n2- Abonnement \n3- Revue \n4- Periodicite");
                    choixTable = Integer.parseInt(sc.nextLine());
                }

                switch(choixTable)
                {
                    case 1 :
                    {
                        System.out.println("Bienvenue dans la partie Client");
                        System.out.println("1- Ajouter \n2- Supprimer \n3- Edit");

                        try
                        {
                            int numChoix = Integer.parseInt(sc.nextLine());
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
                                    client.add(nom, prenom, noRue, voie, codePostal, ville, pays);
                                    break;
                                }
                                case 2 :
                                {
                                    System.out.println("Indiquer l'ID du Client à supprimer");
                                    int id = Integer.parseInt(sc.nextLine());
                                    client.remove(id);
                                    break;
                                }
                                case 3 :
                                {
                                    System.out.println("Indiquer le l'ID du client");
                                    int id = Integer.parseInt(sc.nextLine());
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
                                    client.edit(id, nom, prenom, noRue, voie, codePostal, ville, pays);
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
                        System.out.println("Bienvenue dans la partie Abonnement");
                        System.out.println("1- Ajouter \n2- Supprimer \n3- Edit");

                        try
                        {
                            int numChoix = Integer.parseInt(sc.nextLine());
                            switch (numChoix)
                            {
                                case 1 :
                                {
                                    DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                                    System.out.println("Indiquer la date de debut de l'abonnement à ajouter \nAu format JJ/MM/AAAA");
                                    String dateDebutJava = sc.nextLine();

                                    LocalDate dateDebutFormate = LocalDate.parse(dateDebutJava, formatage);
                                    java.sql.Date dateDebutSql = java.sql.Date.valueOf(dateDebutFormate);

                                    System.out.println("Indiquer la date de fin de l'abonnement à ajouter \nAu format JJ/MM/AAAA");
                                    String dateFinJava = sc.nextLine();

                                    LocalDate dateFinFormate = LocalDate.parse(dateFinJava, formatage);
                                    java.sql.Date dateFinSql = java.sql.Date.valueOf(dateFinFormate);

                                    System.out.println("Indiquer l'ID du Client de l'abonnement à ajouter");
                                    int idClient = Integer.parseInt(sc.nextLine());

                                    System.out.println("Indiquer l'ID de la Revue à ajouter");
                                    int idRevue = Integer.parseInt(sc.nextLine());

                                    abonnement.add(dateDebutSql, dateFinSql, idClient, idRevue);
                                    break;
                                }
                                case 2 :
                                {
                                    System.out.println("Indiquer l'ID de l'abonnement à supprimer");
                                    int id = Integer.parseInt(sc.nextLine());
                                    abonnement.remove(id);
                                    break;
                                }
                                case 3 :
                                {
                                    DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                                    System.out.println("Indiquer l'ID de la l'abonnement à modifier");
                                    int id = Integer.parseInt(sc.nextLine());

                                    System.out.println("Indiquer la date de debut de l'abonnement à modifier \nAu format JJ/MM/AAAA");
                                    String dateDebutJava = sc.nextLine();

                                    LocalDate dateDebutFormate = LocalDate.parse(dateDebutJava, formatage);
                                    java.sql.Date dateDebutSql = java.sql.Date.valueOf(dateDebutFormate);

                                    System.out.println("Indiquer la date de fin de l'abonnement à modifier \nAu format JJ/MM/AAAA");
                                    String dateFinJava = sc.nextLine();

                                    LocalDate dateFinFormate = LocalDate.parse(dateFinJava, formatage);
                                    java.sql.Date dateFinSql = java.sql.Date.valueOf(dateFinFormate);

                                    System.out.println("Indiquer l'ID du Client de l'abonnement à modifier");
                                    int idClient = Integer.parseInt(sc.nextLine());

                                    System.out.println("Indiquer l'ID de la Revue à modifier");
                                    int idRevue = Integer.parseInt(sc.nextLine());

                                    abonnement.edit(id, dateDebutSql, dateFinSql, idClient, idRevue);
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
                        //Partie sur la revue a ajouter
                        System.out.println("Bienvenue dans la partie Périodicité");
                        System.out.println("1- Ajouter \n2- Supprimer \n3- Edit");

                        try
                        {
                            int numChoix = Integer.parseInt(sc.nextLine());
                            switch (numChoix)
                            {
                                case 1 :
                                {
                                    System.out.println("Indiquer le titre de la revue a ajouter");
                                    String titre = sc.nextLine();
                                    System.out.println("Indiquer la description de la revue a ajouter");
                                    String description = sc.nextLine();
                                    System.out.println("Indiquer le tarif de la revue a ajouter");
                                    float tarifNumero = Float.parseFloat(sc.nextLine());
                                    System.out.println("Indiquer le visuel de la revue a ajouter");
                                    String visuel = sc.nextLine();
                                    System.out.println("Indiquer l'ID de la periodicite a laquelle se refere la revue a ajouter");
                                    int idPeriodicite = Integer.parseInt(sc.nextLine());

                                    revue.add(titre, description, tarifNumero, visuel, idPeriodicite);
                                    break;
                                }
                                case 2 :
                                {
                                    System.out.println("Indiquer l'ID de la la revue à supprimer");
                                    int idRevue = Integer.parseInt(sc.nextLine());

                                    revue.remove(idRevue);
                                    break;
                                }
                                case 3 :
                                {
                                    System.out.println("Indiquer l'ID de la la revue à modifier");
                                    int idRevue = Integer.parseInt(sc.nextLine());
                                    System.out.println("Indiquer le titre de la revue a ajouter");
                                    String titre = sc.nextLine();
                                    System.out.println("Indiquer la description de la revue a ajouter");
                                    String description = sc.nextLine();
                                    System.out.println("Indiquer le tarif de la revue a ajouter");
                                    float tarifNumero = Float.parseFloat(sc.nextLine());
                                    System.out.println("Indiquer le visuel de la revue a ajouter");
                                    String visuel = sc.nextLine();
                                    System.out.println("Indiquer l'ID de la periodicite a laquelle se refere la revue a ajouter");
                                    int idPeriodicite = Integer.parseInt(sc.nextLine());

                                    revue.edit(idRevue, titre, description, tarifNumero, visuel, idPeriodicite);
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
                        System.out.println("Bienvenue dans la partie Périodicité");
                        System.out.println("1- Ajouter \n2- Supprimer \n3- Edit");

                        try
                        {
                            int numChoix = Integer.parseInt(sc.nextLine());
                            switch (numChoix)
                            {
                                case 1 :
                                {
                                    System.out.println("Indiquer le libellé");
                                    String libelle = sc.nextLine();
                                    periodicite.add(libelle);
                                    break;
                                }
                                case 2 :
                                {
                                    System.out.println("Indiquer l'ID de la périodicité à supprimer");
                                    int id = Integer.parseInt(sc.nextLine());
                                    periodicite.remove(id);
                                    break;
                                }
                                case 3 :
                                {
                                    System.out.println("Indiquer l'ID de la périodicité à modifier puis le libellé");
                                    int id = Integer.parseInt(sc.nextLine());
                                    String libelle = sc.nextLine();
                                    periodicite.edit(id, libelle);
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

            System.out.println("Voulez vous continuer ? Y/N");
            continueOperation = (sc.nextLine().toLowerCase().equals("y"));
        }while(continueOperation);

        revue.close();
        periodicite.close();
        abonnement.close();
        client.close();
    }
}
