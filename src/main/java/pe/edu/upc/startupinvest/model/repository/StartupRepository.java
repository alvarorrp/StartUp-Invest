package pe.edu.upc.startupinvest.model.repository;
import java.util.Date;
import java.util.List;

import pe.edu.upc.startupinvest.model.entities.Startup;
public interface StartupRepository extends JpaRepository<Startup, Integer> {
List<Startup> findByName (String name);
List <Startup> findByState (Boolean state);
List <Startup> findByDateRecently(); //Startups registradas recientemente 
List <Startup> findByDateBetween(Date date1, Date date2); //Filtrar startups entre fechas de registro
List <Startup> findByPopular(); //Buscar Startups mas populares FALTA EL TOP 


}
