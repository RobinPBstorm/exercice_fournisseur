//        Créer une classe Fournisseur qui représente un fournisseur.
//        Un fournisseur doit avoir les attributs suivants :
//
//        id (entier)
//        nom (chaîne de caractères)
//        email (chaîne de caractères)
//        telephone (chaîne de caractères)

public class Fournisseur {
    private int id;
    private String nom;
    private String email;
    private String telephone;

    /**
     * Accesseur permettant la lecture de l'attribut id
     */
    public int getId() {
        return id;
    }

    /**
     * Accesseur permettant la lecture de l'attribut nom
     */
    public String getNom() {
        return nom;
    }
    /**
     * Accesseur permettant l'écriture de l'attribut nom
     *
     * @param nom la nouvelle valeur
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Accesseur permettant la lecture de l'attribut email
     */
    public String getEmail() {
        return email;
    }
    /**
     * Accesseur permettant l'écriture de l'attribut email
     *
     * @param email la nouvelle valeur
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Accesseur permettant la lecture de l'attribut telephone
     */
    public String getTelephone() {
        return telephone;
    }
    /**
     * Accesseur permettant l'écriture de l'attribut téléphone
     *
     * @param telephone la nouvelle valeur
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * Constructeur avec tous les attributs
     *
     * @param id identifiant du forunisseur
     * @param nom le nom du fournisseur
     * @param email le mail du fournisseur
     * @param telephone le télephone du fournisseur
     */
    public Fournisseur(int id, String nom, String email, String telephone) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
    }

    /**
     * Description détaillé d'un fournisseur et de ses informations
     *
     * @return
     */
    @Override
    public String toString() {
        return " Le Fournisseur avec l'id (" + id +") se nomme " + nom +
                ", est contactable via cet email :" + email +
                " ou par téléphone :" + telephone ;
    }
}
