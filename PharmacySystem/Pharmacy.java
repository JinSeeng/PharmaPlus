package PharmacySystem;

import java.util.List;

public class Pharmacy {
    private String nom;
    private String adresse;
    private List<Product> produits;

    // Constructor
    public Pharmacy(String nom, String adresse, List<Product> produits) {
        this.nom = nom;
        this.adresse = adresse;
        this.produits = produits;
    }

    // Getters
    public String getNom() { return nom; }
    public String getAdresse() { return adresse; }
    public List<Product> getProduits() { return produits; }
}