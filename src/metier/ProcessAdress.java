package metier;

import com.mysql.cj.util.StringUtils;

public class ProcessAdress 
{
    public Adresse normalize(Adresse adresse)
    {
        adresse.setVoie(normalizeVoie(adresse.getVoie()));
        adresse.setCodePostal(normalizeCode(adresse.getCodePostal()));
        adresse.setVille(normalizeVille(adresse.getVille()));
        adresse.setPays(normalizePays(adresse.getPays()));
        
    }

    
    // Normalisation Voie
    public String normalizeVoie(String voie) 
    {
        return (", " + voie.trim());
    }
    
    private String normalizeVille(String ville) 
    {
        if(ville != null)
        {
            ville = ville.trim();
            if (ville.contains(" sous ")) 
            {
                
            }
            else if(ville.contains(" lès ") || ville.contains(" sur ") || ville.contains(" aux "))
            {

            }
            else if (ville.contains(" le ")) 
            {
                
            }
            else if(ville.contains(" à "))
            {

            }
        }
        return null;
    }

    // Normalisation du Pays
    public String normalizePays(String pays)
    {
        if (pays != null) 
        { // Si la chaine pays n'est pas vide
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
}
