package pe.edu.upc.startupinvest.service.crud;

import pe.edu.upc.startupinvest.model.entities.MonetaryUnit;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public interface MonetaryUnitService extends CrudService<MonetaryUnit, Integer> {

}
