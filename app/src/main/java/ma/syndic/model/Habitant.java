package ma.syndic.model;

/** Un résident de la copropriété. */
public class Habitant {
    private String id;
    private String nom;
    private String appartement;   // ex: "A-12"
    private String telephone;
    private boolean proprietaire;

    public Habitant() {}  // requis par Firestore

    public Habitant(String nom, String appartement, String telephone, boolean proprietaire) {
        this.nom = nom;
        this.appartement = appartement;
        this.telephone = telephone;
        this.proprietaire = proprietaire;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getAppartement() { return appartement; }
    public void setAppartement(String a) { this.appartement = a; }
    public String getTelephone() { return telephone; }
    public void setTelephone(String t) { this.telephone = t; }
    public boolean isProprietaire() { return proprietaire; }
    public void setProprietaire(boolean p) { this.proprietaire = p; }
}
