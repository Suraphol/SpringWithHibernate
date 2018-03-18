package com.train.spring.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.train.spring.entity.Product;
@Repository
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Product> getProducts() {
		//Getting session object from sessionFactory
		Session session = sessionFactory.getCurrentSession();
		
		//creating query
		Query<Product> theQuery = session.createQuery("from products", Product.class);
		
		//Getting list of products
		List<Product> products = theQuery.getResultList();
		return products;
	}

	@Override
	public void addProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
//		currentSession.save(product);
		session.saveOrUpdate(product);
		
	}

	@Override
	public Product getProductById(int id) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("->"+id);
		Product product = session.get(Product.class, id);
		System.out.println(product);
		return product;
	}

	@Override
	public void deleteProduct(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from products where productID=:productID");
		query.setParameter("productID", id);
		query.executeUpdate();
		
	}

}
