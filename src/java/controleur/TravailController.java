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
            PreparedStatement state = con.prepareStatement("INSERT INTO `travail` (`idTravail`,`numEmploye`, `numEntreprise`, `nbHeure`) VALUES (?, ?, ?, ?);");
            state.setString(1, trav.getidTravail());
            state.setString(2, trav.getnumEmploye());
            state.setString(3, trav.getnumEntreprise());
            state.setInt(4, trav.getnbHeure());
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
            PreparedStatement state = con.prepareStatement("SELECT * FROM travail");
            ResultSet rs = state.executeQuery();
            while (rs.next()){
            	JSONObject object=new JSONObject();
            	object.put("idTravail", rs.getInt(1));
            	object.put("numEmploye", rs.getString(2));
            	object.put("numEntreprise", rs.getInt(3));
                object.put("nbHeure", rs.getInt(4));
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
            PreparedStatement state = con.prepareStatement("SELECT * FROM travail where idTravail = ?");
            state.setInt(1,id);
            ResultSet rs = state.executeQuery();
            if (rs.next()){
            	object.put("idTravail", rs.getInt(1));
            	object.put("numEmploye", rs.getString(2));
            	object.put("numEntreprise", rs.getInt(3));
                object.put("nbHeure", rs.getInt(4));
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
            PreparedStatement state = con.prepareStatement("UPDATE `travail` SET `idTravail` = ?,`numEmploye` = ?,`numEntreprise` = ?, `nbHeure` = ? WHERE `travail`.`idTravail` = ?;");
            state.setString(1, trav.getidTravail());
            state.setString(2, trav.getnumEmploye());
            state.setString(3,trav.getnumEntreprise());
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
