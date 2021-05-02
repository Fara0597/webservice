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
import modele.Entreprise;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Faranirina
 */
public class EntrepriseController {
    
    public JSONArray getEntreprise() throws JSONException 
    {
        JSONArray resultat = new JSONArray();
        try {
            Connection con = ConnectDB.connect();
            PreparedStatement state = con.prepareStatement("SELECT * FROM entreprise");
            ResultSet rs = state.executeQuery();
            while (rs.next()){
            	JSONObject object=new JSONObject();
            	object.put("numEntreprise", rs.getString(1));
            	object.put("design", rs.getString(2));
            	resultat.put(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultat;
    }

    public JSONObject getEntreprise(String id) throws JSONException {
         JSONObject object=new JSONObject();
        try {
            Connection con = ConnectDB.connect();
            PreparedStatement state = con.prepareStatement("SELECT * FROM entreprise where numEntreprise = ?");
            state.setString(1,id);
            ResultSet rs = state.executeQuery();
            if (rs.next()){
            	object.put("numEntreprise", rs.getString(1));
            	object.put("design", rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return object;
    }

    public int AddEntreprise(Entreprise ent) {
        int rs=0;
        try {
            Connection con = ConnectDB.connect();
            PreparedStatement state = con.prepareStatement("INSERT INTO `entreprise` (`numEntreprise`, `design`) VALUES (?, ?);");
            state.setString(1, ent.getnumEntreprise());
            state.setString(2, ent.getdesign());
            rs = state.executeUpdate();
        } catch (SQLException e) {
        }
        return rs;
    }

    public int UpdateEntreprise(Entreprise ent, String id) {
        int rs=0;
        try {
            Connection con = ConnectDB.connect();
            PreparedStatement state = con.prepareStatement("UPDATE `entreprise` SET `numEntreprise` = ?,`design` = ? WHERE `entreprise`.`numEntreprise` = ?;");
            state.setString(1, ent.getnumEntreprise());
            state.setString(2, ent.getdesign());
            state.setString(3,id);
            rs = state.executeUpdate();
        } catch (SQLException e) {
        }
        return rs;
    }

    public JSONObject deleteEntreprise(String id) {
        try {
            try (Connection con = ConnectDB.connect()) {
                PreparedStatement state = con.prepareStatement("DELETE FROM `entreprise` WHERE `entreprise`.`numEntreprise` = ?");
                state.setString(1,id);
                state.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(EntrepriseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
