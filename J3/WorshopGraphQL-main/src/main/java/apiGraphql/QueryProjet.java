package apiGraphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entities.Module;
import graphql.servlet.SimpleGraphQLServlet;
import repository.ModuleBusiness;

import java.util.List;

public class QueryProjet implements GraphQLRootResolver {

    public static ModuleBusiness mb=new ModuleBusiness();
    public List<Module> getModules(){
        return mb.getAllModules();
    }
}
