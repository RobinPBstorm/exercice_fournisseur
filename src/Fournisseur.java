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

    // Accesseurs
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Fournisseur(int id, String nom, String email, String telephone) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return " Le Fournisseur avec l'id (" + id +") se nomme " + nom +
                ", est contactable via cet email :" + email +
                " ou par téléphone :" + telephone ;
    }
}
