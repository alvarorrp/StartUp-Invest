package pe.edu.upc.startupinvest.service.crud;

import pe.edu.upc.startupinvest.model.entities.PlanHistory;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public interface PlanHistoryService extends CrudService<PlanHistory, Integer> {

}
