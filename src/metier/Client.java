package metier;

public class Client
{
    int id;
    String nom, prenom, noRue, voie, codePostal, ville, pays;

    public Client(String nom, String prenom, String noRue, String voie, String codePostal, String ville, String pays)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.noRue = noRue;
        this.voie = voie;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pays = pays;
    }

    public Client(int id, String nom, String prenom, String noRue, String voie, String codePostal, String ville, String pays)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.noRue = noRue;
        this.voie = voie;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pays = pays;
    }
}
