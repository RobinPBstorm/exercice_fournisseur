import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuInteractif {
    FournisseurService monFournisseurService;

    List<String> texteMenuPrincipal = new ArrayList<String>();

    public MenuInteractif()
    {
        monFournisseurService = new FournisseurService();
        _remplirTexteMenu();
    }


    public void run ()
    {
        boolean estEnCoursFonctionnement = true;
        boolean estSurMenuPrincipal = true;

        Scanner scan = new Scanner(System.in);
        String reponseUtilisateur = null;

        while (estEnCoursFonctionnement)
        {
            if (estSurMenuPrincipal) {
                _afficherMenu();
            }
            reponseUtilisateur = scan.nextLine();
            switch (reponseUtilisateur) {
                case "1":
                    try
                    {
                        System.out.println("Quel est le nom du fournisseur ?");

                        String nom = scan.nextLine();

                        System.out.println("Quel est le mail du fournisseur ?");

                        String mail = scan.nextLine();

                        System.out.println("Quel est le téléphone du fournisseur ?");

                        String telephone = scan.nextLine();

                        Fournisseur fournisseurAAjouter = new Fournisseur(FournisseurService.currentId++, nom, mail, telephone);

                        monFournisseurService.creerFournisseur(fournisseurAAjouter);
                    }
                    catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    try
                    {
                        System.out.println("Quel est l'id du fournisseur à afficher ?");

                        int id = _getId();

                        System.out.println(monFournisseurService.lireFournisseur(id));
                    }
                    catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "3":
                    try
                    {
                        System.out.println("Quel est l'id du fournisseur à modifier ?");

                        int id = _getId();

                        System.out.println("Quel est le nouveau nom du fournisseur ?");

                        String nom = scan.nextLine();

                        System.out.println("Quel est le nouveau mail du fournisseur ?");

                        String mail = scan.nextLine();

                        System.out.println("Quel est le nouveau téléphone du fournisseur ?");

                        String telephone = scan.nextLine();

                        Fournisseur fournisseurAModifier = new Fournisseur(id, nom, mail, telephone);

                        if (!monFournisseurService.lireFournisseur(id).equals(null))
                        {
                            System.out.println("Avant : "+ monFournisseurService.lireFournisseur(id));
                            System.out.println("Aprés : "+ fournisseurAModifier);

                            if (_getConfirmation("Souhaitez-vous confirmer la modification?"))
                            {
                                monFournisseurService.mettreAJourFournisseur(id,fournisseurAModifier);
                            }
                        }

                    }
                    catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "4":
                    try
                    {
                        System.out.println("Quel est l'id du fournisseur à supprimer ?");

                        int id = _getId();

                        monFournisseurService.supprimerFournisseur(id);
                    }
                    catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "5":
                    System.out.println("Voici la liste des fournisseurs :");
                    monFournisseurService.listerFournisseurs();
                    break;
                case "6":
                    // exemple de condition ternaire ( condition ? valeur si vrai : valeur si faux)
                    TypeValidation autreType = (monFournisseurService.getValidation().name().equals(TypeValidation.standard.name()) ? TypeValidation.stricte : TypeValidation.standard);

                    if (_getConfirmation("Souhaitez-vous passer en mode de validation "+autreType.name()+ "?"))
                    {
                        monFournisseurService.changerValidation(autreType);
                    }

                    break;
                case "7":
                    estEnCoursFonctionnement = false;
                    break;
            }

            // séparation avec les instructions suivantes
            System.out.println("--------------------");
        }
    }

    private void _remplirTexteMenu()
    {
        texteMenuPrincipal.add("1. Créer un fournisseur");
        texteMenuPrincipal.add("2. Lire un fournisseur");
        texteMenuPrincipal.add("3. Mettre à jour un fournisseur");
        texteMenuPrincipal.add("4. Supprimer un fournisseur");
        texteMenuPrincipal.add("5. Lister tous les fournisseurs");
        texteMenuPrincipal.add("6. Choisir le type de validation (standard/stricte)");
        texteMenuPrincipal.add("7. Quitter");
    }

    private void _afficherMenu()
    {
        for(String ligne: texteMenuPrincipal)
        {
            System.out.println(ligne);
        }
    }

    private int _getId() throws Exception
    {
        Scanner scan = new Scanner(System.in);
        try
        {
            int id = Integer.valueOf(scan.nextLine());

            return id;
        }
        catch (NumberFormatException nfe)
        {
            throw new Exception("Ce n'est pas un chiffre");
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    private boolean _getConfirmation(String message)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println(message);
        System.out.println("o - n");

        String reponseUtilisateur;
        // boucle pour obtenir un input valid
        do {
            reponseUtilisateur = scan.nextLine();
        }
        while (!reponseUtilisateur.toLowerCase().equals("o") && !reponseUtilisateur.toLowerCase().equals("n"));

        return reponseUtilisateur.toLowerCase().equals("o");
    }
}
