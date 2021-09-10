import java.util.Scanner;;

public class Main {

    public static void main(String[] args) {
        Connexion connect = new Connexion();
        // Périodicité
        Periodicite periodicite = new Periodicite();
        System.out.println("1- Ajouter");
        System.out.println("2- Supprimer");
        System.out.println("3- Modifier");
        System.out.print("Votre choix: ");
        
        Scanner sc = new Scanner(System.in);

        try {
            Integer str = Integer.parseInt(sc.nextLine());
            switch (str) {
                case 1 :
                    System.out.print("Veuillez entrer le libellé : ");
                    String a1 = sc.nextLine();
                    periodicite.add(a1);
                    break;


                case 2 :
                    System.out.print("Veuillez entrer l'identifiant : ");
                    int r1 = Integer.parseInt(sc.nextLine());
                    periodicite.remove(r1);
                    break;

                case 3 :
                    System.out.print("Veuillez entrer l'identifiant : ");
                    int e1 = Integer.parseInt(sc.nextLine());
                    System.out.print("Et le libellé à modifier : ");
                    String e2 = sc.nextLine();
                    periodicite.edit(e1, e2);
                    break;
            }

        }
        catch(Exception e) {
            System.out.println("Erreur, veuillez entrer un nombre entre 1 et 3");
        }


    }

}
