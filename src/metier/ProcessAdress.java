package metier;

import java.util.Arrays;

//import com.mysql.cj.util.StringUtils;

public class ProcessAdress {
    // Normalisation Adresse
    public Adresse normalize(Adresse adresse)
    {
        adresse.setVoie(normalizeVoie(adresse.getVoie()));
        adresse.setCodePostal(normalizeCode(adresse.getCodePostal()));
        adresse.setVille(normalizeVille(adresse.getVille()));
        adresse.setPays(normalizePays(adresse.getPays()));
        return adresse;
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

    // Normalisation Code Postal
    public String normalizeCode(String codePostal) {
        if (codePostal != null) {
            codePostal = codePostal.trim();
            if (isNumeric(codePostal) == true) //Si le code postal est un "int"
            {
                for (int i = 5; codePostal.length() < i; i--) //Dead code idk why, java 16 peut-être
                {
                    codePostal = ("0" + codePostal); 
                    //Si i < 5 (nombre max) alors on ajoute un 0
                }
            } 
            else 
            {
                String[] chaineCodePostal = codePostal.split("L-", -2);
                /* On split le code postal, lorsque l'on rencontre "L-"
                * La limite est -2 :
                * Limit < 0 – In this case, the pattern will be applied as many times as possible, and the resulting array can be of any size.
                */
                codePostal = Arrays.toString(chaineCodePostal);
                // On retourne le code postal (sans le L-) hehe
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
