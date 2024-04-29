package com.jsp.shppingcart_application.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jsp.shoppingCart_Application.dto.Orders;

@Repository
public class OrdersDao {
	@Autowired
	private EntityManagerFactory emf;

	public void saveOrders(Orders order) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(order);
		et.commit();
	}

	public Orders findOrdersById(int id) {
		EntityManager em = emf.createEntityManager();
		Orders order = em.find(Orders.class, id);
		return order;
	}

	public void updateOrders(Orders order) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.merge(order);
		et.commit();
	}

	public void deleteOrdersById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Orders order = em.find(Orders.class, id);
		et.begin();
		em.remove(order);
		et.commit();
	}
	
	
}
