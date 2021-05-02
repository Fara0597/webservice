/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FaraResource;

import controleur.EmployeController;
import controleur.EntrepriseController;
import controleur.ListeController;
import controleur.TravailController;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modele.Employe;
import modele.Entreprise;
import modele.Travail;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * REST Web Service
 *
 * @author Faranirina
 */
@Path("/application")
public class Application {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Application
     */
    public Application() {
    }

    /**
     * Retrieves representation of an instance of FaraResource.Application
     * @return an instance of java.lang.String
     */
    
    /*................................EMPLOYE...........................................*/
    @Path("/employe")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmploye() {
        EmployeController e = new EmployeController();
        JSONArray res = e.getEmploye();
        //TODO return proper representation object
        return Response.status(200).entity(res.toString()).build();
    }

    /**
     * PUT method for updating or creating an instance of Application
     * @param content representation for the resource
     */
    @Path("/employe")
    @POST @Consumes(MediaType.APPLICATION_JSON)
    public Response createEmploye(Employe emp) {
        EmployeController e = new EmployeController();
        int res = e.AddEmploye(emp);
        return Response.status(200).entity(res).build();
    }
    
    /**
     * PUT method for updating or creating an instance of Application
     * @param content representation for the resource
     */
    @Path("/employe/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEmploye(@PathParam("id") String id, Employe emp) {
        EmployeController e = new EmployeController();
        int res = e.UpdateEmploye(emp, id);
        return Response.status(200).entity(res).build();
    }
    
    
    @Path("/employe/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmploye(@PathParam("id") String id) {
        EmployeController e = new EmployeController();
        JSONObject res = e.getEmploye(id);
        //TODO return proper representation object
        return Response.status(200).entity(res.toString()).build();
    }
    
    
    @Path("/employe1/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteEmploye(@PathParam("id") String id) {
        EmployeController e = new EmployeController();
        JSONObject res = e.deleteEmploye(id);
        //TODO return proper representation object
        return Response.status(200).entity(res.toString()).build();
    }
    
    /*................................ENTREPRISE...........................................*/
    @Path("/entreprise")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEntreprise() {
        EntrepriseController e = new EntrepriseController();
        JSONArray res = e.getEntreprise();
        //TODO return proper representation object
        return Response.status(200).entity(res.toString()).build();
    }
    
    
    @Path("/entreprise/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEntreprise(@PathParam("id") String id) {
        EntrepriseController e = new EntrepriseController();
        JSONObject res = e.getEntreprise(id);
        //TODO return proper representation object
        return Response.status(200).entity(res.toString()).build();
    }
    
    
    @Path("/entreprise")
    @POST @Consumes(MediaType.APPLICATION_JSON)
    public Response createEntreprise(Entreprise ent) {
        EntrepriseController e = new EntrepriseController();
        int res = e.AddEntreprise(ent);
        return Response.status(200).entity(res).build();
    }
    
    
    @Path("/entreprise/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEntreprise(@PathParam("id") String id,Entreprise ent) {
        EntrepriseController e = new EntrepriseController();
        int res = e.UpdateEntreprise(ent, id);
        return Response.status(200).entity(res).build();
    }
    
    @Path("/entreprise/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteEntreprise(@PathParam("id") String id) {
        EntrepriseController e = new EntrepriseController();
        JSONObject res = e.deleteEntreprise(id);
        //TODO return proper representation object
        return Response.status(200).entity(res.toString()).build();
    }
    
    
    /*................................TRAVAIL...........................................*/
    
    @Path("/travail")
    @POST @Consumes(MediaType.APPLICATION_JSON)
    public Response createTravail(Travail trav) {
        TravailController e = new TravailController();
        int res = e.AddTravail(trav);
        return Response.status(200).entity(res).build();
    }
    
    
    @Path("/travail")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTravail() {
        TravailController e = new TravailController();
        JSONArray res = e.getTravail();
        //TODO return proper representation object
        return Response.status(200).entity(res.toString()).build();
    }
    
    
    @Path("/travail/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTravail(@PathParam("id") int id) {
        TravailController e = new TravailController();
        JSONObject res = e.getTravail(id);
        //TODO return proper representation object
        return Response.status(200).entity(res.toString()).build();
    }
    
    
    @Path("/travail/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateTravail(@PathParam("id") int id,Travail trav) {
        TravailController e = new TravailController();
        int res = e.UpdateTravail(trav, id);
        return Response.status(200).entity(res).build();
    }
    
    
    @Path("/travail/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteTravail(@PathParam("id") int id) {
        TravailController e = new TravailController();
        JSONObject res = e.deleteTravail(id);
        //TODO return proper representation object
        return Response.status(200).entity(res.toString()).build();
    }
    
    /*................................LISTE EMPLOYES D'UNE ENTREPRISE...........................................*/
    
    @Path("/liste")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListe() {
        ListeController e = new ListeController();
        JSONArray res = e.getListe();
        //TODO return proper representation object
        return Response.status(200).entity(res.toString()).build();
    }
    
   //recherche par num entreprise 
    @Path("/liste/{id}")
    @GET // by id
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListe(@PathParam("id") String id) {
        ListeController e = new ListeController();
        JSONArray res = e.getListe(id);
        //TODO return proper representation object
        return Response.status(200).entity(res.toString()).build();
    }
    
    //recherche par design entreprise(raison sociale)
    @Path("/listeByRaisonSocial/{design}")
    @GET // by raison social
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListeByRaisonSocial(@PathParam("design") String design) {
        ListeController e = new ListeController();
        JSONArray res = e.getListeByRaisonSocial(design);
        //TODO return proper representation object
        return Response.status(200).entity(res.toString()).build();
    }
    
    //nombre employe d'après recherche par design entreprise 
    @Path("/nombreD/{design}")
    @GET // by raison social
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNombreByRaisonSocial(@PathParam("design") String design) {
        ListeController e = new ListeController();
        JSONArray res = e.getNombreByRaisonSocial(design);
        //TODO return proper representation object
        return Response.status(200).entity(res.toString()).build();
    }
    
    //nombre d'employé d'après recherche par numEntreprise
    @Path("/nombreN/{id}")
    @GET // by raison social
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNombreById(@PathParam("id") String id) {
        ListeController e = new ListeController();
        JSONArray res = e.getNombreById(id);
        //TODO return proper representation object
        return Response.status(200).entity(res.toString()).build();
    }
    
    //Etat des salaires globaux (liste)
    @Path("/listeSalairesGlobaux")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListeSalaireGlobaux() {
        ListeController e = new ListeController();
        JSONArray res = e.getListeSalaireGlobaux();
        //TODO return proper representation object
        return Response.status(200).entity(res.toString()).build();
    }
    
    //total salaire
    @Path("/salaireTotal")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSalairetotal() {
        ListeController e = new ListeController();
        JSONArray res = e.getSalairetotal();
        //TODO return proper representation object
        return Response.status(200).entity(res.toString()).build();
    }
    
    // pour graphe: nombre employe par entreprise
    @Path("/graphe1")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmpByEnt() {
        ListeController e = new ListeController();
        JSONArray res = e.getEmpByEnt();
        //TODO return proper representation object
        return Response.status(200).entity(res.toString()).build();
    }
    
    //graphe: salaire par employe
    @Path("/graphe2")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSalaireByEmp() {
        ListeController e = new ListeController();
        JSONArray res = e.getSalaireByEmp();
        //TODO return proper representation object
        return Response.status(200).entity(res.toString()).build();
    }
    
    //camembert1 pour nb employe par entreprise en %
    @Path("/camembert1")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmpByEnt1() {
        ListeController e = new ListeController();
        JSONArray res = e.getEmpByEnt1();
        //TODO return proper representation object
        return Response.status(200).entity(res.toString()).build();
    }
    
    //camembert2 pour salaire par entreprise en %
    @Path("/camembert2")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSalaireByEmp2() {
        ListeController e = new ListeController();
        JSONArray res = e.getSalaireByEmp2();
        //TODO return proper representation object
        return Response.status(200).entity(res.toString()).build();
    }
    
}
