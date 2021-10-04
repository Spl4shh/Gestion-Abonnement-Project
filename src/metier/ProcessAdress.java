package metier;

import com.mysql.cj.util.StringUtils;

public class ProcessAdress 
{
    public Adresse normalize(Adresse adresse)
    {
        String noRueNormalize;
        adresse.setVoie(normalizeVoie(adresse.getVoie()));
        String codePostalNormalize;
        adresse.setVille(normalizeVille(adresse.getVille()));
        adresse.setPays(normalizePays(adresse.getPays()));
        
    }

    // Normalisation du Pays
    public String normalizePays(String pays)
    {
        if (pays != null) { // Si la chaine pays n'est pas vide
            String paysMinus = pays.trim().toLowerCase(); // Chaine pays nettoyée et en minuscules
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
        }
        return pays;
    }

    // Normalisation Voie
    public String normalizeVoie(String voie) 
    {
        return (", " + voie);
    }
}
