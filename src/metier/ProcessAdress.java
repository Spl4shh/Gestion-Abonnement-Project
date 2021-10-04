package metier;

import com.mysql.cj.util.StringUtils;

public class ProcessAdress 
{
    public Adresse normalizeAdresse(Adresse adresse)
    {
        Adresse adresseNormalise;

        normalizePays(adresse.getPays());
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
