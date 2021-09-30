package pe.edu.upc.startupinvest.service.crud;

import pe.edu.upc.startupinvest.model.entities.Investor;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public interface InvestorService extends CrudService<Investor, Integer> {
	Optional<Investor> findById(Integer id) throws Exception;
	List<Investor> findAll() throws Exception;
}
 