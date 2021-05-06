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
import modele.Travail;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Faranirina
 */
public class TravailController {

    public int AddTravail(Travail trav) {
       int rs=0;
        try {
            Connection con = ConnectDB.connect();
            PreparedStatement state = con.prepareStatement("INSERT INTO `travail` (`idTravail`, `numEmploye`, `numEntreprise`, `date`, `nbHeure`) VALUES (?, ?, ?,STR_TO_DATE(?, '%d/%m/%Y'),?)");
            state.setString(1, trav.getidTravail());
            state.setString(2, trav.getnumEmploye());
            state.setString(3, trav.getnumEntreprise());
            state.setString(4, trav.getdate());
            state.setInt(5, trav.getnbHeure());
            rs = state.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public JSONArray getTravail() throws JSONException {
        JSONArray resultat = new JSONArray();
        try {
            Connection con = ConnectDB.connect();
            PreparedStatement state = con.prepareStatement("SELECT idTravail, numEmploye, numEntreprise, DATE_FORMAT(date, \"%d/%m/%Y\"), nbHeure FROM travail");
            ResultSet rs = state.executeQuery();
            while (rs.next()){
            	JSONObject object=new JSONObject();
            	object.put("idTravail", rs.getInt(1));
            	object.put("numEmploye", rs.getString(2));
            	object.put("numEntreprise", rs.getInt(3));
                object.put("date", rs.getString(4));
                object.put("nbHeure", rs.getInt(5));
            	resultat.put(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultat;
    }

    public JSONObject getTravail(int id) throws JSONException {
       JSONObject object=new JSONObject();
        try {
            Connection con = ConnectDB.connect();
            PreparedStatement state = con.prepareStatement("SELECT idTravail, numEmploye, numEntreprise, DATE_FORMAT(date, \"%d/%m/%Y\"), nbHeure FROM travail WHERE idTravail = ?");
            state.setInt(1,id);
            ResultSet rs = state.executeQuery();
            if (rs.next()){
            	object.put("idTravail", rs.getInt(1));
            	object.put("numEmploye", rs.getString(2));
            	object.put("numEntreprise", rs.getInt(3));
                object.put("date", rs.getString(4));
                object.put("nbHeure", rs.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return object;
    }

    public int UpdateTravail(Travail trav, int id) {
        int rs=0;
        try {
            Connection con = ConnectDB.connect();
            PreparedStatement state = con.prepareStatement("UPDATE `travail` SET `numEmploye` = ?,`numEntreprise` = ?, `date`= STR_TO_DATE(?, '%d/%m/%Y'), `nbHeure` = ? WHERE `travail`.`idTravail` = ?");
           // state.setString(1, trav.getidTravail());
            state.setString(1, trav.getnumEmploye());
            state.setString(2,trav.getnumEntreprise());
            state.setString(3,trav.getdate());
            state.setInt(4,trav.getnbHeure());
            state.setInt(5,id);
            rs = state.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public JSONObject deleteTravail(int id) {
       try {
            try (Connection con = ConnectDB.connect()) {
                PreparedStatement state = con.prepareStatement("DELETE FROM `travail` WHERE `travail`.`idTravail` = ?");
                state.setInt(1,id);
                state.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
}
