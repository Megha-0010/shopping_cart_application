package com.jsp.shppingcart_application.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.shoppingCart_Application.dto.Merchant;
import com.jsp.shoppingCart_Application.dto.Product;

@Repository
public class ProductDao {

	@Autowired
	MerchantDao mdao;

	@Autowired
	private EntityManagerFactory emf;

	public void saveProduct(Product p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(p);
		et.commit();
	}

	public Product findProductById(int id) {
		EntityManager em = emf.createEntityManager();
		Product p = em.find(Product.class, id);
		return p;
	}

	public void updateProduct(Product p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.merge(p);
		et.commit();
	}

	public void deleteProductById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Product p = em.find(Product.class, id);
		et.begin();
		em.remove(p);
		et.commit();
	}

	public List<Product> findAllProducts() {
		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("select p from Product p");

		List<Product> products = query.getResultList();
		return products;
	}

	public List<Product> findProductBybrand(String brand) {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select p from Product p where p.brand=?1 ");
		query.setParameter(1, brand);

		try {
			List<Product> p = (List<Product>) query.getSingleResult();
			return p;
		} catch (NoResultException e) {
			return null;
		}
	}

	public Merchant removeProductFromMerchant(int mid, int pid) {
		Merchant m = mdao.findMerchantById(mid);
		List<Product> products = m.getProducts();
		
		List<Product> productslist = new ArrayList<Product>();
		
		for (Product p : products) {
			if (p.getId() != pid) {
				productslist.add(p);
			}
		}
		m.setProducts(productslist);
		return m;

	}

}
