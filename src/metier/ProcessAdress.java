package metier;

public class ProcessAdress
{
    // Normalisation Adresse
    public static Adresse normalize(Adresse adresse)
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
                else if (string.equals("av.") || string.equals("av"))
                {
                    string = "avenue";
                }
                else if (string.equals("faub.") || string.equals("fg"))
                {
                    string = "faubourg";
                }
                else if(string.equals("pl.") || string.equals("pl"))
                {
                    string = "place";
                }

                if (!newVoie.equals(""))
                {
                    newVoie = newVoie + " ";
                }

                newVoie = newVoie + string;
            }

            if (!(newVoie.charAt(0) == ','))
            {
                newVoie = ", " + newVoie;
            }

            return (newVoie);
        }
        else
        {
            return null;
        }
    }
    
    // Normalisation Ville
    public static String normalizeVille(String ville) 
    {
        if(ville != null && !ville.equals(""))
        {
            ville = ville.trim().toLowerCase();             // Formattage en tout minuscule

            String[] tableauMot = ville.split(" ");         // Separation dans un tableau
            boolean testPlus1Mot = (tableauMot.length > 1);

            String nouveauVille = "";

            for (String string : tableauMot) //verification pour chaque mot du nom de la ville
            { 
                boolean modifAbrege = true;
                // /!\ au cas ou la ville n'a qu'1 seul mot et c'est un pronom
                if (string.equals("sous")) 
                {
                    string = "-sous-";
                }
                else if(string.equals("lès") || string.equals("les"))
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
                else if(string.equals("à") || string.equals("a"))
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
                    if (!nouveauVille.equals("") && nouveauVille.charAt(nouveauVille.length()-1) != '-')
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
        if (pays != null) 
        { // Si la chaine pays n'est pas null
            pays = pays.trim().toLowerCase(); //Chaine nettoyé et en minuscule
            if (!pays.equals(""))
            {

                switch (pays) 
                {
                    case "letzebuerg":
                        pays = "luxembourg";
                        break;
    
                    case "belgium":
                        pays = "belgique";
                        break;
    
                    case "switzerland", "schweiz":
                        pays = "suisse";
                        break;
                }
                pays = String.valueOf(pays.charAt(0)).toUpperCase() + pays.substring(1);
                //Ajout de la majuscule en premier caractere
            }    
        }
        return pays;
    }

    // Normalisation Code Postal
    public static String normalizeCode(String codePostal) 
    {
        if (codePostal != null)
        {
            codePostal = codePostal.trim();  //Le trim se fait ici car irréalisable sur un object null

            if (!codePostal.equals("")) 
            {
                boolean etranger = false;
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
                            etranger = true;
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
                } while (lettrePresente && !codePostal.equals(""));     //tant que il y a des lettres on repete l'operation

                if (codePostal.length() < 4 && !codePostal.equals(""))
                {
                    throw new IllegalArgumentException("code postal non conforme");
                }
                if (codePostal.length() < 5 && !codePostal.equals("") && !etranger)    // S'il n'y a que 4 chiffre on en rajoute
                {
                    codePostal = "0" + codePostal;
                }
            }
        }
        return codePostal;
    }
}
