package pe.edu.upc.startupinvest.service.crud;

import pe.edu.upc.startupinvest.model.entities.Investor;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public interface InvestorService extends CrudService<Investor, Integer> {

}
