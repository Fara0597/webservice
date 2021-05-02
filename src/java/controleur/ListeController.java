/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import modele.ConnectDB;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Faranirina
 */
public class ListeController {

    public JSONArray getListe() throws JSONException {
      JSONArray resultat = new JSONArray();
        try {
            Connection con = ConnectDB.connect();
            PreparedStatement state = con.prepareStatement("SELECT `employe`.`numEmploye`, `nomEmploye`, `adresse`, `design`, `tauxHoraire`, `nbHeure`, (`tauxHoraire` * `nbHeure`) AS salaire FROM `employe`, `travail`,`entreprise` WHERE `employe`.`numEmploye`= `travail`.`numEmploye` && `entreprise`.`numEntreprise`=`travail`.`numEntreprise` ORDER BY `employe`.`numEmploye` ASC");
            ResultSet rs = state.executeQuery();
            while (rs.next()){
            	JSONObject object=new JSONObject();
            	object.put("numEmploye", rs.getString(1));
            	object.put("nomEmploye", rs.getString(2));
                object.put("adresse", rs.getString(3));
                object.put("design", rs.getString(4));
            	object.put("tauxHoraire", rs.getDouble(5));
                object.put("nbHeure", rs.getInt(6));
                object.put("salaire", rs.getDouble(7));
            	resultat.put(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultat;
    }

    public JSONArray getListe(String id) throws JSONException {
        JSONArray resultat = new JSONArray();
        //List<JSONObject> datas = new ArrayList<JSONObject>();
        
        try {
            Connection con = ConnectDB.connect();
            PreparedStatement state = con.prepareStatement("SELECT `entreprise`.`numEntreprise`,`employe`.`numEmploye`, `nomEmploye`, `adresse`, `design`, `tauxHoraire`, `nbHeure`, (`tauxHoraire` * `nbHeure`) AS salaire FROM `employe`, `travail`,`entreprise` WHERE `employe`.`numEmploye`= `travail`.`numEmploye` && `entreprise`.`numEntreprise`=`travail`.`numEntreprise` && `entreprise`.`numEntreprise`=?");            
            state.setString(1,id);            
            ResultSet rs = state.executeQuery();
            while(rs.next()){
                JSONObject object=new JSONObject();
                object.put("numEntreprise", rs.getString(1));
            	object.put("numEmploye", rs.getString(2));
            	object.put("nomEmploye", rs.getString(3));
                object.put("adresse", rs.getString(4));
                object.put("design", rs.getString(5));
            	object.put("tauxHoraire", rs.getDouble(6));
                object.put("nbHeure", rs.getInt(7));
                object.put("salaire", rs.getDouble(8));
             //   object.put("Nombre_Employe", rs.getInt(8));
                resultat.put(object);                
            }                                                
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultat;
    }
    

    public JSONArray getListeByRaisonSocial(String design) throws JSONException {
        JSONArray resultat = new JSONArray();
        
        //List<JSONObject> datas = new ArrayList<JSONObject>();
        
        try {
            Connection con = ConnectDB.connect();
            PreparedStatement state = con.prepareStatement("SELECT `entreprise`.`numEntreprise`,`employe`.`numEmploye`, `nomEmploye`, `adresse`, `design`, `tauxHoraire`, `nbHeure`, (`tauxHoraire` * `nbHeure`) AS salaire FROM `employe`, `travail`,`entreprise` WHERE `employe`.`numEmploye`= `travail`.`numEmploye` && `entreprise`.`numEntreprise`=`travail`.`numEntreprise` && `design`=?");            
           // PreparedStatement state1 = con.prepareStatement("SELECT COUNT(`travail`.`numEntreprise`) as Nombre_Employe FROM `travail`, `entreprise` WHERE`design`=? &&  `entreprise`.`numEntreprise`= `travail`.`numEntreprise`");
            state.setString(1,design);
          //  state1.setString(1,design);
           
            ResultSet rs = state.executeQuery();
            while(rs.next()){
                JSONObject object=new JSONObject();
                object.put("numEntreprise", rs.getString(1));
            	object.put("numEmploye", rs.getString(2));
            	object.put("nomEmploye", rs.getString(3));
                object.put("adresse", rs.getString(4));
                object.put("design", rs.getString(5));
            	object.put("tauxHoraire", rs.getDouble(6));
                object.put("nbHeure", rs.getInt(7));
                object.put("salaire", rs.getDouble(8));
             //   object.put("Nombre_Employe", rs.getInt(8));
                resultat.put(object);               
            }                                                
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultat;
    }

    public JSONArray getNombreByRaisonSocial(String design) throws JSONException {
      JSONArray resultat = new JSONArray();
        
        try {
            Connection con = ConnectDB.connect();
            //PreparedStatement state = con.prepareStatement("SELECT `entreprise`.`numEntreprise`,`employe`.`numEmploye`, `nomEmploye`, `adresse`, `design`, `tauxHoraire`, `nbHeure`, (`tauxHoraire` * `nbHeure`) AS salaire FROM `employe`, `travail`,`entreprise` WHERE `employe`.`numEmploye`= `travail`.`numEmploye` && `entreprise`.`numEntreprise`=`travail`.`numEntreprise` && `design`=?");            
            PreparedStatement state = con.prepareStatement("SELECT COUNT(`travail`.`numEntreprise`) as Nombre_Employe FROM `travail`, `entreprise` WHERE `design`=? &&  `entreprise`.`numEntreprise`= `travail`.`numEntreprise`");
            state.setString(1,design);
           
            ResultSet rs = state.executeQuery();
            while(rs.next()){
                JSONObject object=new JSONObject();
                object.put("nombre", rs.getString(1));
              //  object.put("design", rs.getString(2));
                //   object.put("Nombre_Employe", rs.getInt(8));
                resultat.put(object);               
            }                                                
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultat;
    }

    public JSONArray getNombreById(String id) throws JSONException {
       JSONArray resultat = new JSONArray();
        try {
            Connection con = ConnectDB.connect();
            //PreparedStatement state = con.prepareStatement("SELECT `entreprise`.`numEntreprise`,`employe`.`numEmploye`, `nomEmploye`, `adresse`, `design`, `tauxHoraire`, `nbHeure`, (`tauxHoraire` * `nbHeure`) AS salaire FROM `employe`, `travail`,`entreprise` WHERE `employe`.`numEmploye`= `travail`.`numEmploye` && `entreprise`.`numEntreprise`=`travail`.`numEntreprise` && `design`=?");            
            PreparedStatement state = con.prepareStatement("SELECT COUNT(`travail`.`numEntreprise`) as Nombre_Employe FROM `travail`, `entreprise` WHERE `entreprise`.`numEntreprise`=?  &&  `entreprise`.`numEntreprise`= `travail`.`numEntreprise`");
            state.setString(1,id);
          //  state1.setString(1,design);
           
            ResultSet rs = state.executeQuery();
            while(rs.next()){
                JSONObject object=new JSONObject();
                object.put("nombre", rs.getString(1));
              //  object.put("design", rs.getString(2));
                //   object.put("Nombre_Employe", rs.getInt(8));
                resultat.put(object);               
            }                                                
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultat;
    }

    public JSONArray getListeSalaireGlobaux() throws JSONException {
       JSONArray resultat = new JSONArray();
        try {
            Connection con = ConnectDB.connect();
            PreparedStatement state = con.prepareStatement("SELECT `employe`.`numEmploye`, `nomEmploye`, (`tauxHoraire` * `nbHeure`) AS salaire FROM `employe`, `travail`,`entreprise` WHERE `employe`.`numEmploye`= `travail`.`numEmploye` && `entreprise`.`numEntreprise`=`travail`.`numEntreprise` ORDER BY `employe`.`numEmploye` ASC");
            ResultSet rs = state.executeQuery();
            while (rs.next()){
            	JSONObject object=new JSONObject();
            	object.put("numEmploye", rs.getString(1));
            	object.put("nomEmploye", rs.getString(2));
                object.put("salaire", rs.getDouble(3));
            	resultat.put(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultat;
    }

    public JSONArray getSalairetotal() throws JSONException {
    JSONArray resultat = new JSONArray();
        try {
            Connection con = ConnectDB.connect();
            PreparedStatement state = con.prepareStatement("SELECT SUM(`tauxHoraire` * `nbHeure`) AS Montant_total FROM `employe`, `travail`,`entreprise` WHERE `employe`.`numEmploye`= `travail`.`numEmploye` && `entreprise`.`numEntreprise`=`travail`.`numEntreprise`");
            ResultSet rs = state.executeQuery();
            while (rs.next()){
            	JSONObject object=new JSONObject();
            	object.put("Montant_total", rs.getString(1));
            	resultat.put(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultat;
    }

    public JSONArray getEmpByEnt() {
      JSONArray resultat = new JSONArray();
        try {
            Connection con = ConnectDB.connect();
            PreparedStatement state = con.prepareStatement("SELECT entreprise.design, COUNT(numEmploye) as nombre FROM travail, entreprise WHERE travail.numEntreprise=entreprise.numEntreprise GROUP BY entreprise.design");
            ResultSet rs = state.executeQuery();
            while (rs.next()){
            	JSONObject object=new JSONObject();
            	object.put("entreprise", rs.getString(1));
                object.put("nombre_employe", rs.getString(2));
            	resultat.put(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultat;
    }

    public JSONArray getSalaireByEmp() {
        JSONArray resultat = new JSONArray();
        try {
            Connection con = ConnectDB.connect();
            PreparedStatement state = con.prepareStatement("SELECT employe.nomEmploye, (employe.tauxHoraire * travail.nbHeure) AS salaire FROM travail, employe WHERE travail.numEmploye=employe.numEmploye GROUP BY employe.nomEmploye");
            ResultSet rs = state.executeQuery();
            while (rs.next()){
            	JSONObject object=new JSONObject();
            	object.put("nomEmploye", rs.getString(1));
                object.put("salaire", rs.getString(2));
            	resultat.put(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultat;
    }

// getEmpByEnt1 en pourcentage, à 0.01 près pour camembert
    public JSONArray getEmpByEnt1() {
      JSONArray resultat = new JSONArray();
        try {
            Connection con = ConnectDB.connect();
            PreparedStatement state = con.prepareStatement("SELECT entreprise.design, CONCAT(ROUND(((COUNT(travail.numEmploye)*100)/(SELECT COUNT(travail.numEmploye) FROM travail)), 2), ' ', '%') AS pourcentage FROM travail, entreprise WHERE travail.numEntreprise=entreprise.numEntreprise GROUP BY entreprise.design");
            ResultSet rs = state.executeQuery();
            while (rs.next()){
            	JSONObject object=new JSONObject();
            	object.put("entreprise", rs.getString(1));
                object.put("pourcentage_employe", rs.getString(2));
            	resultat.put(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultat;  
    }
// getSalaireByEmp2 en pourcentage, à 0.01 près pour camembert
    public JSONArray getSalaireByEmp2() {
       JSONArray resultat = new JSONArray();
        try {
            Connection con = ConnectDB.connect();
            PreparedStatement state = con.prepareStatement("SELECT employe.nomEmploye, CONCAT(ROUND(((employe.tauxHoraire * travail.nbHeure*100)/(SELECT SUM(employe.tauxHoraire * travail.nbHeure) FROM employe, travail WHERE employe.numEmploye=travail.numEmploye)), 2),' ','%') as pourcentage_salaire FROM travail, employe WHERE travail.numEmploye=employe.numEmploye GROUP BY employe.nomEmploye");
            ResultSet rs = state.executeQuery();
            while (rs.next()){
            	JSONObject object=new JSONObject();
            	object.put("nomEmploye", rs.getString(1));
                object.put("salaire_en_%", rs.getString(2));
            	resultat.put(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultat;
    }
    
    

    
}
