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
public class Entreprise {
    private String numEntreprise;
    private String design;
    
    public Entreprise() {
    }
    
    public Entreprise(String numEntreprise, String design) {
   
        this.numEntreprise = numEntreprise;
        this.design = design;
     }

    public String getnumEntreprise() {
        return numEntreprise;
    }
    
    public void setnumEntreprise(String numEntreprise) {
        this.numEntreprise = numEntreprise;
    }

    public String getdesign() {
       return design;
    }
    
    public void setdesign(String design) {
        this.design = design;
    }
}
