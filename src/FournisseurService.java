import java.util.ArrayList;
import java.util.List;

public class FournisseurService {
    // Sert à simuler la gestion d'id d'une db
    public static int currentId = 0;

    private TypeValidation validation = TypeValidation.standard;

    private List<Fournisseur> mesFournisseurs = new ArrayList<Fournisseur>();

    /**
     * Accesseur du Type de validation de ce service en lecture seule
     *
     * @return le type de validation du service
     */
    public TypeValidation getValidation() {
        return validation;
    }


    /**
     * Ajoute un fournisseur à la liste
     * Passe la validation de celui-ci avant de tenter de l'insertion
     *
     * @param fournisseur fournisseur à ajouter
     * @return l'identifiant du fournisseur ajouté
     * @throws Exception si le fournisseur n'est pas valide
     */
    public int creerFournisseur(Fournisseur fournisseur) throws Exception
    {
        _validation(fournisseur);

        mesFournisseurs.add(fournisseur);

        // sortir l'id du fournisseur
        return fournisseur.getId();
    }

    /**
     * Affichage d'un fournisseur spécifique selon son id
     *
     * @param id identifiant du fournisseur à afficher
     * @return message détaillé sur le fournisseur
     * @throws Exception si le fournisseur n'est pas trouvé
     */
    public String lireFournisseur(int id) throws Exception
    {
        Fournisseur fournisseur = _touverFournisseur(id);

        return fournisseur.toString();
    }

    /**
     * Affiche la liste des fournisseurs
     *
     * Un message indique quand la liste est vide
     */
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

    /**
     * Modification d'un fournisseur
     *
     * @param id identifiant du fournisseur à modifier
     * @param fournisseur fournisseur (avec ses nouvelles valeurs)
     * @throws Exception si le fournisseur n'a pas été trouvé
     */
    public void mettreAJourFournisseur(int id,Fournisseur fournisseur) throws Exception
    {
        Fournisseur fournisseurAvantModification = _touverFournisseur(id);

        _validation(fournisseur);

        // La modification s'effectue si aucune erreur n'a été relevé
        int index = mesFournisseurs.indexOf((fournisseurAvantModification));
        mesFournisseurs.set(index, fournisseur);
    }

    /**
     * Suppression d'un fournisseur dans la liste
     * Passe la validation de celui-ci avant de tenter de la modification
     *
     * @param id identifiant du fournisseur à supprimer
     * @throws Exception si fournisseur non trouvé
     */
    public void supprimerFournisseur(int id) throws Exception
    {
        Fournisseur fournisseur = _touverFournisseur(id);

        mesFournisseurs.remove(fournisseur);
    }

    /**
     * Changement de validation
     *
     * @param typeValidation nouveau type de validation
     */
    public void changerValidation(TypeValidation typeValidation)
    {
        this.validation = typeValidation;
    }

    /**
     * Validation d'un fournisseur
     * Les régles de validation dépendant du type de validation de ce service
     *
     * @param fournisseur le fournisseur à valider
     * @throws Exception dans le cas où une régle n'a pas été respecté
     */
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

    /**
     * Vérification de la présence d'un fournisseur avec id en paramètre
     *
     * @param id identifiant du fournisseur à chercher
     * @return fournisseur si trouvé
     * @throws Exception dans le cas où l'id n'a pas été trouvé
     */
    private Fournisseur _touverFournisseur(int id) throws Exception
    {
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

}
