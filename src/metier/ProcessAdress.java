package metier;

import com.mysql.cj.util.StringUtils;

public class ProcessAdress {
    // Normalisation Adresse
    public Adresse normalizeAdresse(Adresse adresse) {
        Adresse adresseNormalise;

        normalizePays(adresse.getPays());
    }

    // Normalisation du Pays
    public String normalizePays(String pays) {
        if (pays != null) { // Si la chaine pays n'est pas vide
            String paysMinus = pays.trim().toLowerCase(); // Chaine pays nettoyée et en minuscules
            switch (paysMinus) {
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
    public String normalizeVoie(String voie) {
        return (", " + voie);
    }

    // Normalisation Code Postal
    public String normalizeCode(String codePostal) {
        if (codePostal != null) {
            codePostal = codePostal.trim();
            if (isNumeric(codePostal) == true) {
                
            }
        }
        return codePostal;
    }

    public static boolean isNumeric(String codePostal) {
        int intValue;

        System.out.println(String.format("Parsing string: \"%s\"", codePostal));

        /* Si la chaine est vide : déjà vérifié
        if (codePostal == null || codePostal.equals(""))
        {
            System.out.println("String cannot be parsed, it is null or empty.");
            return false;
        }*/

        try 
        {
            intValue = Integer.parseInt(codePostal);
            // Si la chaine peut être convertie en int : c'est un entier
            return true;
        } 
        catch (NumberFormatException e) 
        {
            System.out.println("Input String cannot be parsed to Integer.");
            // Erreur sinon
        }
        return false;
    }
}
