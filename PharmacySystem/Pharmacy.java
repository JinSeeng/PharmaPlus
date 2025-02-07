package PharmacySystem;

import java.util.List;

public class Pharmacy {
    private String nom;
    private String adresse;
    private List<Product> produits;

    // Default constructor (required for Jackson)
    public Pharmacy() {
    }

    // Constructor with arguments
    public Pharmacy(String nom, String adresse, List<Product> produits) {
        this.nom = nom;
        this.adresse = adresse;
        this.produits = produits;
    }

    // Getters and Setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public List<Product> getProduits() { return produits; }
    public void setProduits(List<Product> produits) { this.produits = produits; }
}