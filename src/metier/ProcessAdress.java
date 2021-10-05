package metier;

import java.util.Arrays;


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
        if (voie != null)
        {
            voie = voie.trim().toLowerCase();
            
            if (voie.equals("boul") || voie.equals("boul.") || voie.equals("bd")) 
            {
                voie = "boulevard";
            }
            else if (voie.equals("av."))
            {
                voie = "avenue";
            }
            else if (voie.equals("faub.") || voie.equals("fg"))
            {
                voie = "faubourg";
            }
            else if(voie.equals("pl."))
            {
                voie = "place";
            }
        }
        return (", " + voie);
    }
    
    private String normalizeVille(String ville) 
    {
        if(ville != null)
        {
            ville = ville.trim();
            if (ville.contains(" sous ")) 
            {
                ville.replace(" sous ", "-sous-");
            }
            else if(ville.contains(" lès "))
            {
                ville.replace(" lès ", "-lès-");
            }
            else if (ville.contains(" sur ")) 
            {
                ville.replace(" sur ", "-sur-");
            }
            else if (ville.contains(" aux ")) 
            {
                ville.replace(" aux ", "-aux-");
            }
            else if (ville.contains(" le ")) 
            {
                ville.replace(" le ", "-le-");
            }
            else if(ville.contains(" à "))
            {
                ville.replace(" à ", "-à-");
            }
        }
        return ville;
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
                String[] chaineCodePostal = codePostal.split("-", -2);
                /* On split le code postal, lorsque l'on rencontre "L-"
                * La limite est -2 :
                * Limit < 0 – In this case, the pattern will be applied as many times as possible, and the resulting array can be of any size.
                */
                codePostal = chaineCodePostal[1];
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
