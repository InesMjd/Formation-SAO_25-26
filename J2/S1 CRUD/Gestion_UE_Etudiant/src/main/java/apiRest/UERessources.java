package apiRest;

import entities.UniteEnseignement;
import metiers.UniteEnseignementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/UE")
public class UERessources {

    public static UniteEnseignementBusiness ueb=new UniteEnseignementBusiness();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UniteEnseignement> getUE(){
        return ueb.getListeUE();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public boolean addUE(UniteEnseignement ue){
        return ueb.addUniteEnseignement(ue);
    }
}

