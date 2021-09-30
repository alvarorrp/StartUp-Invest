package pe.edu.upc.startupinvest.model.repository;

import java.util.List;

import pe.edu.upc.startupinvest.model.entities.TypeCard;

public interface TypeCardRepository extends JpaRepository<TypeCard, Integer> {
	List<TypeCard> findTypeCardByName(String name) throws Exception;
}
