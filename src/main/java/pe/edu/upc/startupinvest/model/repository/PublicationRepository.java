package pe.edu.upc.startupinvest.model.repository;

import java.util.List;

import pe.edu.upc.startupinvest.model.entities.Publication;


public interface PublicationRepository extends JpaRepository<Publication, Integer> {
	
	List<Publication> findPublicationByName(String name) throws Exception;
}
