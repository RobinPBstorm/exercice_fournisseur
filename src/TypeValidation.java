// Emploit d'une énumération pour montrer une utilisation d'enum propre à Java
public enum TypeValidation {
    standard (false, false, false),
    stricte (true, true, true);

    private boolean estAutoriseNomVide;
    private boolean estStrictFormatMail;
    private boolean estStrictFormatTelephone;

    /**
     * Accesseur permettant la lecture de l'attribut estAutoriseNomVide
     * Ce boolean indique si on applique la règle interdisant un nom vide
     */
    public boolean isEstAutoriseNomVide() {
        return estAutoriseNomVide;
    }
    /**
     * Accesseur permettant la lecture de l'attribut estStrictFormatMail
     * Ce boolean indique si on vérifie respect d'un format stricte pour le mail
     */
    public boolean isEstStrictFormatMail() {
        return estStrictFormatMail;
    }
    /**
     * Accesseur permettant la lecture de l'attribut estStrictFormatMail
     * Ce boolean indique si on vérifie respect d'un format stricte pour le téléphone
     */
    public boolean isEstStrictFormatTelephone() {
        return estStrictFormatTelephone;
    }

    TypeValidation(boolean validationNom, boolean validationMail, boolean validationTelephone)
    {
        this.estAutoriseNomVide = validationNom;
        this.estStrictFormatMail = validationMail;
        this.estStrictFormatTelephone = validationTelephone;
    }
}
