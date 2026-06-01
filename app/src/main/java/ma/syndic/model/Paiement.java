package ma.syndic.model;

/** Cotisation mensuelle d'un appartement. */
public class Paiement {
    private String id;
    private String appartement;
    private String mois;        // ex: "Juin 2026"
    private double montant;
    private boolean paye;

    public Paiement() {}
    public Paiement(String appartement, String mois, double montant, boolean paye) {
        this.appartement = appartement; this.mois = mois; this.montant = montant; this.paye = paye;
    }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getAppartement() { return appartement; }
    public void setAppartement(String a) { this.appartement = a; }
    public String getMois() { return mois; }
    public void setMois(String m) { this.mois = m; }
    public double getMontant() { return montant; }
    public void setMontant(double m) { this.montant = m; }
    public boolean isPaye() { return paye; }
    public void setPaye(boolean p) { this.paye = p; }
}
