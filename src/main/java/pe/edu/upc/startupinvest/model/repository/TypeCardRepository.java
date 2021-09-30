package pe.edu.upc.startupinvest.model.repository;
import java.util.List;

import pe.edu.upc.startupinvest.model.entities.TypeCard;
public interface TypeCardRepository extends JpaRepository<TypeCard, Integer> {
List<TypeCard>findTypeCardByname (String name);


public List<TypeCard> list();
}
