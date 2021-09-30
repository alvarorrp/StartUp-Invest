package pe.edu.upc.startupinvest.service.crud;

import pe.edu.upc.startupinvest.model.entities.InvestmentRequest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public interface InvestmentRequestService extends CrudService<InvestmentRequest, Integer> {
	public List<InvestmentRequest> list();
	
}
