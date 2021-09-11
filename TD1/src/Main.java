//import java.text.DateFormat;
import java.util.Scanner;
import java.util.Date;

public class Main
{
    public static void main(String[] args)
    {
        Periodicite periodicite = new Periodicite();
        Client client = new Client();
        Abonnement abonnement = new Abonnement();
        //Revue revue = new Revue();


        try
        {
            System.out.println("1- Client \n2- Abonnement \n3- Revue \n4- Periodicite");
            Scanner sc = new Scanner(System.in);
            int choixTable = Integer.parseInt(sc.nextLine());

            while( choixTable > 4 || choixTable < 1)
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
                                switch (numChoix) {
                                    case 1 : {
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
                                    }
                                    case 2 : {
                                        System.out.println("Indiquer l'ID du Client à supprimer");
                                        int id = Integer.parseInt(sc.nextLine());
                                        client.remove(id);
                                    }
                                    case 3 : {
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
                                    }
                                }
                            }
                            catch (Exception e)
                            {
                                System.out.println(e);
                            }
                        }
                case 2 :
                        {
                            System.out.println("Bienvenue dans la partie Abonnement");
                            System.out.println("1- Ajouter \n2- Supprimer \n3- Edit");

                            try
                            {
                                int numChoix = Integer.parseInt(sc.nextLine());
                                switch (numChoix) {
                                    case 1 : {
                                        System.out.println("Indiquer la date de debut de l'abonnement à ajouter \nAu format JJ/MM/AAAA");
                                        java.sql.Date dateDebut = new java.sql.Date(new Date(sc.nextLine()).getTime());
                                        System.out.println("Indiquer la date de fin de l'abonnement à ajouter \nAu format JJ/MM/AAAA");
                                        java.sql.Date dateFin = new java.sql.Date(new Date(sc.nextLine()).getTime());
                                        System.out.println("Indiquer l'ID du Client de la l'abonnement à ajouter");
                                        int idClient = Integer.parseInt(sc.nextLine());
                                        System.out.println("Indiquer l'ID de la Revue à ajouter");
                                        int idRevue = Integer.parseInt(sc.nextLine());
                                        abonnement.add(dateDebut, dateFin, idClient, idRevue);
                                    }
                                    case 2 : {
                                        System.out.println("Indiquer l'ID de l'abonnement à supprimer");
                                        int id = Integer.parseInt(sc.nextLine());
                                        abonnement.remove(id);
                                    }
                                    case 3 : {
                                        System.out.println("Indiquer l'ID de la l'abonnement à modifier");
                                        int id = Integer.parseInt(sc.nextLine());
                                        System.out.println("Indiquer la date de debut de l'abonnement à modifier \nAu format JJ/MM/AAAA");
                                        java.sql.Date dateDebut = new java.sql.Date(new Date(sc.nextLine()).getTime());
                                        System.out.println("Indiquer la date de fin de l'abonnement à modifier \nAu format JJ/MM/AAAA");
                                        java.sql.Date dateFin = new java.sql.Date(new Date(sc.nextLine()).getTime());
                                        System.out.println("Indiquer l'ID du Client de la l'abonnement à modifier");
                                        int idClient = Integer.parseInt(sc.nextLine());
                                        System.out.println("Indiquer l'ID de la Revue à modifier");
                                        int idRevue = Integer.parseInt(sc.nextLine());
                                        abonnement.edit(id, dateDebut, dateFin, idClient, idRevue);
                                    }
                                }
                            }
                            catch (Exception e)
                            {
                                System.out.println(e);
                            }
                        }
                case 3 :                        {
                            //Partie sur la revue a ajouter
                        }
                case 4 :
                        {
                            System.out.println("Bienvenue dans la partie Périodicité");
                            System.out.println("1- Ajouter \n2- Supprimer \n3- Edit");

                            try
                            {
                                int numChoix = Integer.parseInt(sc.nextLine());
                                String libelle;
                                int id;
                                switch (numChoix) {
                                    case 1 : {
                                        System.out.println("Indiquer le libellé");
                                        libelle = sc.nextLine();
                                        periodicite.add(libelle);
                                    }
                                    case 2 : {
                                        System.out.println("Indiquer l'ID de la périodicité à supprimer");
                                        id = Integer.parseInt(sc.nextLine());
                                        periodicite.remove(id);
                                    }
                                    case 3 : {
                                        System.out.println("Indiquer l'ID de la périodicité à modifier puis le libellé");
                                        id = Integer.parseInt(sc.nextLine());
                                        libelle = sc.nextLine();
                                        periodicite.edit(id, libelle);
                                    }
                                }
                            }
                            catch (Exception e)
                            {
                                System.out.println(e);
                            }
                        }
            }
        }
        catch (Exception e)
        {

        }




    }
}
