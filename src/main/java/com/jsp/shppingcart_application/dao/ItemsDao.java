package com.jsp.shppingcart_application.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.shoppingCart_Application.dto.Items;

@Repository
public class ItemsDao {
	@Autowired
	private EntityManagerFactory emf;

	public void saveItems(Items i) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(i);
		et.commit();
	}

	public Items findItemsById(int id) {
		EntityManager em = emf.createEntityManager();
		Items i = em.find(Items.class, id);
		return i;
	}

	public void updateItems(Items i) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.merge(i);
		et.commit();
	}

	public void deleteItemsById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Items i = em.find(Items.class, id);
		et.begin();
		em.remove(i);
		et.commit();
	}
	
}
