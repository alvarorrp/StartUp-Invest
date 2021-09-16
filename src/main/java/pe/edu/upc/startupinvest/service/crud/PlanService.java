package pe.edu.upc.startupinvest.service.crud;

import pe.edu.upc.startupinvest.model.entities.Plan;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public interface PlanService extends CrudService<Plan, Integer> {

}
