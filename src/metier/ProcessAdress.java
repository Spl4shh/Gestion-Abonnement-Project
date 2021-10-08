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
            String[] tableauMot = voie.split(" ");
            String newVoie = "";

            for (String string : tableauMot) 
            {
                if (string.equals("boul") || string.equals("boul.") || string.equals("bd")) 
                {
                    string = "boulevard";
                }
                else if (string.equals("av."))
                {
                    string = "avenue";
                }
                else if (string.equals("faub.") || string.equals("fg"))
                {
                    string = "faubourg";
                }
                else if(string.equals("pl."))
                {
                    string = "place";
                }

                if (newVoie != "") 
                {
                    newVoie = newVoie + " ";    
                }

                newVoie = newVoie + string; 
            }
            
            return (", " + voie);
        }
        else
        {
            return null;
        }
    }
    
    // Normalisation Ville
    public static String normalizeVille(String ville) 
    {
        if(ville != null && ville != "")
        {
            ville = ville.trim().toLowerCase();             // Formattage en tout minuscule

            String[] tableauMot = ville.split(" ");         // Separation dans un tableau
            boolean testPlus1Mot = (tableauMot.length > 1);

            String nouveauVille = "";

            for (String string : tableauMot)            //verification pour chaque mot du nom de la ville
            { 
                boolean modifAbrege = true;
                // /!\ au cas ou la ville n'a qu'1 seul mot et c'est un pronom
                if (string.equals("sous")) 
                {
                    string = "-sous-";
                }
                else if(string.equals("lès"))
                {
                    string = "-lès-";
                }
                else if (string.equals("sur")) 
                {
                    string = "-sur-";
                }
                else if (string.equals("aux")) 
                {
                    string = "-aux-";
                }
                else if (string.equals("le")) 
                {
                    string = "-le-";
                }
                else if(string.equals("à"))
                {
                    string = "-à-";
                }
                else if (string.equals("st")) 
                {
                    string = "Saint-";
                }
                else if (string.equals("ste")) 
                {
                    string = "Sainte-";  
                }
                else                      // Si pas de mot a remplacer, alors on suppose que c'est un nom de ville et pas un pronom
                {
                    modifAbrege = false;
                    string = String.valueOf(string.charAt(0)).toUpperCase() + string.substring(1);   // Premiere lettre majuscule
                                            // Si on a deja composé la nvle chaine et que le dernier carac n'est pas un - alors on met un espace 
                    if (nouveauVille != "" && nouveauVille.charAt(nouveauVille.length()-1) != '-') 
                    {
                        string = " " + string;
                    }
                }

                if (modifAbrege && !testPlus1Mot) 
                {
                    string = string.replace("-", "");
                }

                nouveauVille = nouveauVille + string;
            }
            ville = nouveauVille.trim();
        }             
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
        if (codePostal != null)
        {
            codePostal = codePostal.trim();  //Le trim se fait ici car irréalisable sur un object null

            if (!codePostal.equals("")) 
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
                        
                        if (nombre < 0)         // Dans le cas ou il reste plus que le - le nombre est negatif
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
                } while (lettrePresente && codePostal != "");     //tant que il y a des lettres on repete l'operation
                
                if (codePostal.length() < 5 && codePostal != "")    // S'il n'y a que 4 chiffre on en rajoute
                {
                    codePostal = "0" + codePostal;
                }
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
