package pe.edu.upc.startupinvest.service.crud;

import pe.edu.upc.startupinvest.model.entities.Publication;


import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public interface PublicationService extends CrudService<Publication, Integer> {

	Optional<Publication> findById(Integer id) throws Exception;
	List<Publication> findAll() throws Exception;
	List<Publication> findPublicationByName(String name) throws Exception;
}
