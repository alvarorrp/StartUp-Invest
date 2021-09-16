package pe.edu.upc.startupinvest.service.crud;

import pe.edu.upc.startupinvest.model.entities.TypeInvestment;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public interface TypeInvestmentService extends CrudService<TypeInvestment, Integer> {

}
