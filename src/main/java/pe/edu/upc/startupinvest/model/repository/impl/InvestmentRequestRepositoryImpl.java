package pe.edu.upc.startupinvest.model.repository.impl;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.startupinvest.model.entities.InvestmentRequest;
import pe.edu.upc.startupinvest.model.repository.InvestmentRequestRepository;


public class InvestmentRequestRepositoryImpl implements InvestmentRequestRepository{

	@PersistenceContext(unitName = "startupinvestPU")
	private EntityManager entityManager;
	
	
	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}

	
	@Override
	public Optional<InvestmentRequest> findById(Integer id) throws Exception {
		return findById(id, InvestmentRequest.class);
	}

	@Override
	public List<InvestmentRequest> findAll() throws Exception {
		String jpql = "SELECT investmentRequests FROM InvestmentRequests investmentRequests";	
		return findAll(InvestmentRequest.class, jpql);
	}
	
}
