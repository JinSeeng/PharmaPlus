package PharmacySystem;

public class Product {
    private int id;
    private String nom;
    private double prix;
    private int quantiteStock;
    private String categorie;
    private String sousCategorie;
    private String description;

    // Constructor
    public Product(int id, String nom, double prix, int quantiteStock, String categorie, String sousCategorie, String description) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.quantiteStock = quantiteStock;
        this.categorie = categorie;
        this.sousCategorie = sousCategorie;
        this.description = description;
    }

    // Getters
    public int getId() { return id; }
    public String getNom() { return nom; }
    public double getPrix() { return prix; }
    public int getQuantiteStock() { return quantiteStock; }
    public String getCategorie() { return categorie; }
    public String getSousCategorie() { return sousCategorie; }
    public String getDescription() { return description; }

    // Setter for quantiteStock
    public void setQuantiteStock(int quantiteStock) {
        this.quantiteStock = quantiteStock;
    }
}