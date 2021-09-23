package pe.edu.upc.startupinvest.service.crud;

import pe.edu.upc.startupinvest.model.entities.Startup;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public interface StartupService extends CrudService<Startup, Integer> {
	
	List<Startup> findByName (String name);
	List <Startup> findByState (Boolean state);
	List <Startup> findByDateRecently();  
	List <Startup> findByDateBetween(Date date1, Date date2);
	List <Startup> findByPopular();

}
