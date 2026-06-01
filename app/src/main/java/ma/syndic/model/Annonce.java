package ma.syndic.model;

public class Annonce {
    private String id;
    private String titre;
    private String contenu;
    private long date;

    public Annonce() {}
    public Annonce(String titre, String contenu, long date) {
        this.titre = titre; this.contenu = contenu; this.date = date;
    }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTitre() { return titre; }
    public void setTitre(String t) { this.titre = t; }
    public String getContenu() { return contenu; }
    public void setContenu(String c) { this.contenu = c; }
    public long getDate() { return date; }
    public void setDate(long d) { this.date = d; }
}
