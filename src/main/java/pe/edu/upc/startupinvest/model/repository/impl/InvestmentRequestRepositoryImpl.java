package pe.edu.upc.startupinvest.model.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pe.edu.upc.startupinvest.model.entities.InvestmentRequest;
import pe.edu.upc.startupinvest.model.repository.InvestmentRequestRepository;

@Named
@ApplicationScoped
public class InvestmentRequestRepositoryImpl implements InvestmentRequestRepository {

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

	@SuppressWarnings("unchecked")
	@Override
	public List<InvestmentRequest> list() {
		List<InvestmentRequest>lista =new ArrayList<InvestmentRequest>();
		try {
			Query q=entityManager.createQuery("From InvestmentRequest investmentRequests");
			lista=(List<InvestmentRequest>) q.getResultList();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}

}
