package pe.edu.upc.startupinvest.service.crud;

import pe.edu.upc.startupinvest.model.entities.InvestmentRequest;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public interface InvestmentRequestService extends CrudService<InvestmentRequest, Integer> {

}
