package pe.edu.upc.startupinvest.model.repository;
import java.util.List;

import pe.edu.upc.startupinvest.model.entities.Startup;
public interface StartupRepository extends JpaRepository<Startup, Integer> {
List<Startup> findStartupByName (String name);
List <Startup> findStartupByState (Boolean state);

}
