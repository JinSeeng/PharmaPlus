package PharmacySystem;

public class Product {
    private int id;
    private String nom;
    private double prix;
    private int quantiteStock;
    private String categorie;
    private String sousCategorie;
    private String description;

    // Default constructor (required for Jackson)
    public Product() {
    }

    // Constructor with arguments
    public Product(int id, String nom, double prix, int quantiteStock, String categorie, String sousCategorie, String description) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.quantiteStock = quantiteStock;
        this.categorie = categorie;
        this.sousCategorie = sousCategorie;
        this.description = description;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }

    public int getQuantiteStock() { return quantiteStock; }
    public void setQuantiteStock(int quantiteStock) { this.quantiteStock = quantiteStock; }

    public String getCategorie() { return categorie; }
    public void setCategorie(String categorie) { this.categorie = categorie; }

    public String getSousCategorie() { return sousCategorie; }
    public void setSousCategorie(String sousCategorie) { this.sousCategorie = sousCategorie; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}