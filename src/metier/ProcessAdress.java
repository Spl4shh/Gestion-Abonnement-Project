package metier;

import com.mysql.cj.util.StringUtils;

public class ProcessAdress 
{
    // Normalisation Adresse

    public Adresse normalizeAdresse(Adresse adresse)
    {
        Adresse adresseNormalise;

        normalizePays(adresse.getPays());
    }

    // Normalisation du Pays

    public String normalizePays(String pays)
    {
        String paysMinus = pays.toLowerCase();

        switch (paysMinus) 
        {
            case "letzebuerg":
                pays = "Luxembourg";
                break;

            case "belgium":
                pays = "Belgique";
                break;

            case "switzerland", "schweiz":
                pays = "Suisse";
                break;
        }
        return pays;
    }

    // Normalisation Voie

    public String normalizeVoie(String voie) 
    {
        return (", " + voie);
    }
}
