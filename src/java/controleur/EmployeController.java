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
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.ConnectDB;
import modele.Employe;
import modele.Travail;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 *
 * @author Faranirina
 */
public class EmployeController {
    public JSONArray getEmploye() 
    {
        JSONArray resultat = new JSONArray();
        try {
            Connection con = ConnectDB.connect();
            PreparedStatement state = con.prepareStatement("SELECT * FROM employe");
            ResultSet rs = state.executeQuery();
            while (rs.next()){
            	JSONObject object=new JSONObject();
            	object.put("numEmploye", rs.getString(1));
            	object.put("nomEmploye", rs.getString(2));
                object.put("adresse", rs.getString(3));
            	object.put("tauxHoraire", rs.getDouble(4));
            	resultat.put(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultat;
    }
    public int AddEmploye(Employe emp){
        int rs=0;
        try {
            Connection con = ConnectDB.connect();
            PreparedStatement state = con.prepareStatement("INSERT INTO `employe` (`numEmploye`, `nomEmploye`, `adresse`, `tauxHoraire`) VALUES (?, ?, ?, ?);");
            state.setString(1, emp.getnumEmploye());
            state.setString(2, emp.getnom());
            state.setString(3, emp.getadresse());
            state.setDouble(4,emp.getTauxHoraire());
            rs = state.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public int UpdateEmploye(Employe emp, String id){
        int rs=0;
        try {
            Connection con = ConnectDB.connect();
            PreparedStatement state = con.prepareStatement("UPDATE `employe` SET `numEmploye` = ?,`nomEmploye` = ?, `adresse` = ?, `tauxHoraire` = ? WHERE `employe`.`numEmploye` = ?;");
            state.setString(1, emp.getnumEmploye());
            state.setString(2, emp.getnom());
            state.setString(3, emp.getadresse());
            state.setDouble(4,emp.getTauxHoraire());
            state.setString(5,id);
            rs = state.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public JSONObject getEmploye(String id) throws JSONException
    {
        JSONObject object=new JSONObject();
        try {
            Connection con = ConnectDB.connect();
            PreparedStatement state = con.prepareStatement("SELECT * FROM employe where numEmploye = ?");
            state.setString(1,id);
            ResultSet rs = state.executeQuery();
            if (rs.next()){
            	object.put("numEmploye", rs.getString(1));
            	object.put("nomEmploye", rs.getString(2));
                object.put("adresse", rs.getString(3));
            	object.put("tauxHoraire", rs.getDouble(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return object;
    }


    public JSONObject deleteEmploye(String id) {
        
        try {
            try (Connection con = ConnectDB.connect()) {
                PreparedStatement state = con.prepareStatement("DELETE `employe`, `travail` FROM `employe` INNER JOIN `travail` ON `employe`.`numEmploye`=`travail`.`numEmploye` WHERE `employe`.`numEmploye`=?;");
                state.setString(1,id);
                state.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
   
    

}
