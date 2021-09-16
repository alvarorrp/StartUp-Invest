package pe.edu.upc.startupinvest.service.crud;

import pe.edu.upc.startupinvest.model.entities.TypeCard;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public interface TypeCardService extends CrudService<TypeCard, Integer> {

}
