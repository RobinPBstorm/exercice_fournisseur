public enum TypeValidation {
    standard (false, false, false),
    stricte (true, true, true);

    private boolean estAutoriseNomVide;
    private boolean estStrictFormatMail;
    private boolean estStrictFormatTelephone;

    // Accesseurs en lecture seule
    public boolean isEstAutoriseNomVide() {
        return estAutoriseNomVide;
    }

    public boolean isEstStrictFormatMail() {
        return estStrictFormatMail;
    }

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
