package metier;

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
    public static String normalizeVoie(String voie) 
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
    
    // Normalisation Ville
    private static String normalizeVille(String ville) 
    {
        if(ville != null)
        {
            ville = ville.trim();

            String[] tableauMot = ville.split(" ");

            if (tableauMot.length > 1) 
            { 
                String nouveauVille = "";

                for (String string : tableauMot)            //verification pour chaque mot du nom de la ville
                {
                    if (string.equals(" sous ")) 
                    {
                        string = "-sous-";
                    }
                    else if(string.equals(" lès "))
                    {
                        string.replace(" lès ", "-lès-");
                    }
                    else if (string.equals(" sur ")) 
                    {
                        string.replace(" sur ", "-sur-");
                    }
                    else if (string.equals(" aux ")) 
                    {
                        string.replace(" aux ", "-aux-");
                    }
                    else if (string.equals(" le ")) 
                    {
                        string.replace(" le ", "-le-");
                    }
                    else if(string.equals(" à "))
                    {
                        string.replace(" à ", "-à-");
                    }
                    else if (string.equals("St ")) 
                    {
                        string.replace("St ", "Saint-");
                    }
                    else if (string.equals("Ste ")) 
                    {
                        string.replace("Ste ", "Sainte-");  
                    }
                    else 
                    {
                        string = String.valueOf(string.charAt(0)).toUpperCase();
                    }

                    nouveauVille += string;
                }
                ville = nouveauVille;
            }
            
        }
    //Ajout de la majuscule au debut quoi qu'il arrive 

        ville = String.valueOf(ville.charAt(0)).toUpperCase() + ville.substring(1) ;    
        return ville;
    }

    public static String normalizeVille2(String ville) 
    {
        if(ville != null)
        {
            ville = ville.trim();

            if (ville.contains(" le ")) 
            {
                ville.replace(" le ", "-le-");
            }
            if(ville.contains(" à "))
            {
                ville.replace(" à ", "-à-");
            }
            if (ville.contains("St ")) 
            {
                ville.replace("St ", "Saint-");
            }
            if (ville.contains("Ste ")) 
            {
                ville.replace("Ste ", "Sainte-");  
            }
        }
        ville = String.valueOf(ville.charAt(0)).toUpperCase() + ville.substring(1) ;    
        return ville;   
    }

    // Normalisation du Pays
    public static String normalizePays(String pays)
    {
        pays = pays.trim();

        if (pays != null) 
        { // Si la chaine pays n'est pas vide
            String paysMinus = pays.toLowerCase(); // Chaine pays nettoyée et en minuscules

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

    // Normalisation Code Postal
    public static String normalizeCode2(String codePostal) 

    {

        //Le trim doit se faire avant (dans le cas ou la chaine est un espace)
        codePostal = codePostal.trim();

        if (codePostal != null) 
        {
            boolean lettrePresente = false;  //Le boolean sert juste a signifier si il y a une lettre ou pas
            do 
            {
                if (lettrePresente)         //Dans le cas ou on a deja fais 1 passage
                {
                    codePostal = codePostal.substring(1);       //on retire le premier element et on recomment
                }

                try 
                {
                    int nombre = Integer.parseInt(codePostal);
                    
                    if (nombre > 0)         // Dans le cas ou il reste plus que le -
                    {
                        lettrePresente = true;
                    }
                    else
                    {
                        lettrePresente = false;
                    }
                } 
                catch (IllegalArgumentException e) 
                {
                    lettrePresente = true;
                }
            } while (lettrePresente);     //tant que il y a des lettres on repete l'operation
            
            if (codePostal.length() < 5)    // S'il n'y a que 4 chiffre on en rajoute
            {
                codePostal = "0" + codePostal;
            }
        }

        return codePostal;
    }
   
    // Normalisation Code Postal
    public static String normalizeCode(String codePostal) 
    {
        codePostal = codePostal.trim();
        if (codePostal != null) 
        {
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
