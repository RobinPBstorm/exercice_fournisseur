import java.util.ArrayList;
import java.util.List;

// (BONUS)Créer une classe FournisseurService qui contient la logique métier pour la gestion des fournisseurs,
// y compris les méthodes CRUD :
//        creerFournisseur(Fournisseur fournisseur)
//        lireFournisseur(int id)
//        mettreAJourFournisseur(int id,Fournisseur fournisseur)
//        supprimerFournisseur(int id)
//        listerFournisseurs()
//Ajouter des validations lors de la création et de la mise à jour des fournisseurs :
//
//        Le nom ne doit pas être vide.
//        L'email doit avoir un format valide (exemple : example@domaine.com).
//        Le numéro de téléphone doit être composé uniquement de chiffres et contenir entre 10 et 15 caractères.

public class FournisseurService {
    public static int currentId = 0;

    private TypeValidation validation = TypeValidation.standard;

    private List<Fournisseur> mesFournisseurs = new ArrayList<Fournisseur>();

    // accesseur en lecture seule du type de validation
    public TypeValidation getValidation() {
        return validation;
    }
    // créer fournisseur
    public int creerFournisseur(Fournisseur fournisseur) throws Exception
    {
        _validation(fournisseur);

        mesFournisseurs.add(fournisseur);

        // sortir l'id du fournisseur
        return fournisseur.getId();
    }

    private void _validation(Fournisseur fournisseur) throws Exception
    {
        if (this.validation.isEstAutoriseNomVide())
        {
            if (fournisseur.getNom() == null || fournisseur.getNom().trim() == "")
            {
                throw new Exception ("Le nom du fournisseur ne peut être vide");
            }
        }

        if (this.validation.isEstStrictFormatMail())
        {
            String mail = fournisseur.getEmail();
            // Expression régulière (1 ou + caractére alphanumérique avec . et - accepté, 1 @, 1 ou + caractére alphanumérique avec . et - accepté, 1 ., 2 ou + lettres)
            String emailRegex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
            if (!mail.matches(emailRegex))
            {
                throw new Exception ("Le mail fournit n'a pas le bon format");
            }
        }


        if (this.validation.isEstStrictFormatTelephone())
        {
            String telephone = fournisseur.getTelephone();

            int min = 10, max = 15;
            if (telephone.length() < min || telephone.length() > max)
            {
                throw new Exception("Le téléphone doit contenir entre "+min+" et "+max+" caractères!");
            }

            // possibilité de parcourir en vérifiant chaque caractére
            //boolean isNumeric = true;
            //
            //for (int i = 0; i < telephone.length(); i++) {
            //    if (!Character.isDigit(telephone.charAt(i))) {
            //        isNumeric = false;
            //        break;
            //    }
            //}
            //
            //if (!isNumeric) {
            //    throw new Exception("Le téléphone doit contenir que des chiffres!");
            //}

            // OU vérifier avec une expression régulière (RegEx)
            if (!telephone.matches("\\d+"))
            {
                throw new Exception("Le téléphone doit contenir que des chiffres!");
            }
        }
    }

    private Fournisseur _touverFournisseur(int id) throws Exception {
        Fournisseur fournisseur = null;
        int i = 0;
        while (fournisseur == null && i < mesFournisseurs.size())
        {
            if(mesFournisseurs.get(i).getId() == id)
            {
                fournisseur = mesFournisseurs.get(i);
            }
            i++;
        }

        if (fournisseur == null)
        {
            // Exception car pas trouvé
            throw new Exception("Fournisseur avec l'id ("+id+") non trouvé");
        }

        return fournisseur;
    }

    public String lireFournisseur(int id) throws Exception
    {
        Fournisseur fournisseur = _touverFournisseur(id);

        return fournisseur.toString();
    }

    public void mettreAJourFournisseur(int id,Fournisseur fournisseur) throws Exception
    {
        Fournisseur fournisseurAvantModification = _touverFournisseur(id);

        _validation(fournisseur);

        // La modification s'effectue si aucune erreur n'a été relevé
        int index = mesFournisseurs.indexOf((fournisseurAvantModification));
        mesFournisseurs.set(index, fournisseur);
    }

    public void supprimerFournisseur(int id) throws Exception
    {
        Fournisseur fournisseur = _touverFournisseur(id);

        mesFournisseurs.remove(fournisseur);
    }

    public void listerFournisseurs()
    {
        if (mesFournisseurs.size() == 0)
        {
            System.out.println("Il n'y a aucun fournisseur enregistré");
        }
        else {
            for (Fournisseur fournisseur: mesFournisseurs)
            {
                System.out.println(fournisseur.toString());
            }
        }

    }

    public void changerValidation(TypeValidation typeValidation)
    {
        this.validation = typeValidation;
    }

}
