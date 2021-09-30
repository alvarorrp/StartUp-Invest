package pe.edu.upc.startupinvest.service.crud;

import pe.edu.upc.startupinvest.model.entities.Startup;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public interface StartupService extends CrudService<Startup, Integer> {
	Optional<Startup> findById(Integer id) throws Exception;
	List<Startup> findAll() throws Exception; 
	List<Startup> findByName (String name) throws Exception;
	List <Startup> findByState (Boolean state) throws Exception;
	List <Startup> findByDateRecently() throws Exception;  
	List <Startup> findByDateBetween(Date date1, Date date2) throws Exception;
	List <Startup> findByPopular() throws Exception;
	public List<Startup> list();
}
