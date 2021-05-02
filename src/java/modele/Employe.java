/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Faranirina
 */
public class Employe {
    private String numEmploye;
    private String nom;
    private String adresse;
    private Double tauxHoraire;
    
    public Employe() {
    }
    
    public Employe(String numEmploye, String nom, String adresse, Double tauxHoraire) {
   
        this.numEmploye = numEmploye;
        this.nom = nom;
        this.adresse = adresse;
        this.tauxHoraire= tauxHoraire; 
     }
    
    public String getnumEmploye() {
        return numEmploye;
    }
    
    public void setnumEmploye(String numEmploye) {
        this.numEmploye = numEmploye;
    }
           
    public String getnom() {
        return nom;
    }
    
    public void setnom(String nom) {
        this.nom = nom;
    }
    
    public String getadresse() {
        return adresse;
    }
    
    public void setadresse(String adresse) {
        this.adresse = adresse;
    }
            
   
    public double getTauxHoraire() {
        return tauxHoraire;
    }
    
     public void setTauxHoraire(double tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
    }
     
    
}
