package pe.edu.upc.startupinvest.service.crud;

import pe.edu.upc.startupinvest.model.entities.InvestorHistory;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public interface InvestorHistoryService extends CrudService<InvestorHistory, Integer> {

}
