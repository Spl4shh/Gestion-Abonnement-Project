package metier;

public class ProcessAdress 
{
    public Adresse normalizeAdresse(Adresse adresse)
    {
        Adresse adresseNormalise;

        normalizePays(adresse.getPays());
    }

    public String normalizePays(String pays)
    {

    }

    public String normalizeVoie(String voie) 
    {
        return (", " + voie);
    }
}
