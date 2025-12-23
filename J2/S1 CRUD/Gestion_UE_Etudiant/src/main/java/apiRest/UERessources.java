package apiRest;

import entities.UniteEnseignement;
import metiers.UniteEnseignementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/UE")
public class UERessources {

    public static UniteEnseignementBusiness ueb=new UniteEnseignementBusiness();

   /* @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UniteEnseignement> getUE(){
        return ueb.getListeUE();
    }*/

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addUE(UniteEnseignement ue){
        if(ueb.addUniteEnseignement(ue))
            return Response.status(Response.Status.CREATED)
                //Response.status(201)
                .build();
        return Response.status(Response.Status.NOT_FOUND)
                .build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUEBySem(@QueryParam("sem") Integer semestre) {
        if (semestre == null)
            return Response.ok(ueb.getListeUE())
                    .build();
        else {
            List<UniteEnseignement> liste = ueb.getUEBySemestre(semestre);
            if (!liste.isEmpty())
                return Response.ok()
                        .entity(liste)
                        .build();
            return Response.status(Response.Status.NO_CONTENT)
                    .build();
        }
    }
}

