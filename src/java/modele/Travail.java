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
public class Travail {
    private String idTravail;
    private String numEmploye;
    private String numEntreprise;
    private int nbHeure;
    
    public Travail() {
    }
    
    public Travail(String idTravail, String numEmploye, String numEntreprise, int nbHeure) {
   
        this.idTravail = idTravail;
        this.numEmploye = numEmploye;
        this.numEntreprise = numEntreprise;
        this.nbHeure= nbHeure; 
     }
    
   /* public Integer getNbHeure() {
        return nbHeure;
    }*/

    public String getidTravail() {
        return idTravail;
    }
    
     public void setidTravail(String idTravail) {
        this.idTravail = idTravail;
    } 

    public String getnumEmploye() {
        return numEmploye;
    }
    
    public void setnumEmploye(String numEmploye) {
        this.numEmploye = numEmploye;
    } 

    public String getnumEntreprise() {
       return numEntreprise;
    }
    public void setnumEntreprise(String numEntreprise) {
        this.numEntreprise = numEntreprise;
    } 

    public int getnbHeure() {
        return nbHeure;
    }
    
     public void setnbHeure(int nbHeure) {
        this.nbHeure = nbHeure;
    } 
            
    
}
