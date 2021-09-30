package pe.edu.upc.startupinvest.service.crud;

import pe.edu.upc.startupinvest.model.entities.PlanHistory;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public interface PlanHistoryService extends CrudService<PlanHistory, Integer> {
	public List<PlanHistory> list();
}
