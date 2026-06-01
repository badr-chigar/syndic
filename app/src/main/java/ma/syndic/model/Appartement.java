package ma.syndic.model;

public class Appartement {
    private String id;
    private String numero;
    private int etage;
    private double surface;
    private String occupant;

    public Appartement() {}
    public Appartement(String numero, int etage, double surface, String occupant) {
        this.numero = numero; this.etage = etage; this.surface = surface; this.occupant = occupant;
    }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNumero() { return numero; }
    public void setNumero(String n) { this.numero = n; }
    public int getEtage() { return etage; }
    public void setEtage(int e) { this.etage = e; }
    public double getSurface() { return surface; }
    public void setSurface(double s) { this.surface = s; }
    public String getOccupant() { return occupant; }
    public void setOccupant(String o) { this.occupant = o; }
}
