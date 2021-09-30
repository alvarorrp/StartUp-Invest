package pe.edu.upc.startupinvest.service.crud;

import pe.edu.upc.startupinvest.model.entities.TypeCard;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public interface TypeCardService extends CrudService<TypeCard, Integer> {

	Optional<TypeCard> findById(Integer id) throws Exception;
	List<TypeCard> findAll() throws Exception;
	List<TypeCard> findTypeCardByName(String name) throws Exception;
}
