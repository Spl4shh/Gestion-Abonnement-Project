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

    public String normalizeVoie(String voie) 
    {
        return (", " + voie);
    }
}
