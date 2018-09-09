package com.dmt.daoimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dmt.dao.CustomerDao;
import com.dmt.helper.DMTHelper;
import com.dmt.modal.Customer;
import com.dmt.modal.Supplier;
import com.dmt.response.CustomerDTO;
import com.dmt.response.CustomerList;
import com.dmt.response.SearchCriteria;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	DMTHelper helper;

	private Session openSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	@Override
	public CustomerDTO getCustomerList(SearchCriteria searchCriteria) {
		CustomerDTO response = new CustomerDTO();
		try {
			Criteria criteria = openSession().createCriteria(Customer.class, "customer");
			searchCriteria.setMultipleObects(true);
			/*
			 * Criteria city = criteria.createCriteria("city"); HashMap <String,
			 * Criteria> childCriteria = new HashMap<String, Criteria>();
			 * childCriteria.put("city", city);
			 * searchCriteria.setChildCriteria(childCriteria);
			 */
			setCriteria(searchCriteria, criteria);
			List<Customer> customers = criteria.list();
			List<CustomerList> customerLists = helper.generateCusotmerList(customers);
			response.setCustomerList(customerLists);
			response.setCount(getCustomerCount(searchCriteria));
			return response;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

	}

	private void setCriteria(SearchCriteria searchCriteria, Criteria criteria) {

		// Set the length of the records to be fetched.
		if (!searchCriteria.getLength().equals("-1"))
			criteria.setMaxResults(Integer.parseInt(searchCriteria.getLength()));

		// Set the start position of the records to be fetched.
		criteria.setFirstResult(Integer.parseInt(searchCriteria.getStart()));
		String orderBy = searchCriteria.getOrder();
		if (orderBy.indexOf(".") != -1 && searchCriteria.isMultipleObects()) {
			String[] key = searchCriteria.getQualifiedNames(orderBy);
			Criteria childCriteira = searchCriteria.getCriteria(key[0]);

			if ("asc".equals(searchCriteria.getDirection()))
				childCriteira.addOrder(Order.asc(key[1]));
			else if ("desc".equals(searchCriteria.getDirection()))
				childCriteira.addOrder(Order.desc(key[1]));

		} else {
			// Set the sort order based on the value that comes in, else default
			// sort asc for the first column.
			if (searchCriteria.getOrder() != null && "asc".equals(searchCriteria.getDirection()))
				criteria.addOrder(Order.asc(searchCriteria.getOrder()));
			else if (searchCriteria.getOrder() != null && "desc".equals(searchCriteria.getDirection()))
				criteria.addOrder(Order.desc(searchCriteria.getOrder()));
		}
		/*
		 * else criteria.addOrder(Order.asc("1"));
		 */

		// Set filter parameter.
		if (searchCriteria.getSearch() != null) {
			Iterator<Entry<String, String>> it = searchCriteria.getSearch().entrySet().iterator();
			while (it.hasNext()) {
				Entry<String, String> pair = it.next();
				if (pair.getValue() != null && pair.getValue() != "") {
					if (pair.getKey().indexOf(".") != -1 && searchCriteria.isMultipleObects()) {
						String[] key = searchCriteria.getQualifiedNames(pair.getKey());
						criteria.createAlias("city", "city");
						if (key[1].equalsIgnoreCase("cityName")) {
							criteria.add(Restrictions.like("city.cityName", "%" + pair.getValue() + "%").ignoreCase());
						}
					} else {
						if (pair.getKey().indexOf(".") != -1) {
							String[] key = searchCriteria.getQualifiedNames(pair.getKey());
							criteria.createAlias("city", "city");
							if (key[1].equalsIgnoreCase("cityName")) {
								criteria.add(
										Restrictions.like("city.cityName", "%" + pair.getValue() + "%").ignoreCase());
							} else {
								Criterion condition = Restrictions.like(pair.getKey(), "%" + pair.getValue() + "%")
										.ignoreCase();
								criteria.add(Restrictions.or(condition));
							}
						} else {
							Criterion condition = Restrictions.like(pair.getKey(), "%" + pair.getValue() + "%")
									.ignoreCase();
							criteria.add(Restrictions.or(condition));
						}

					}
				}
			}
		}

	}

	private Integer getCustomerCount(SearchCriteria searchCriteria) throws CloneNotSupportedException {
		Criteria criteria = openSession().createCriteria(Customer.class, "customer");
		searchCriteria.setMultipleObects(false);
		/*
		 * Criteria geography = criteria.createCriteria("geography"); HashMap
		 * <String, Criteria> childCriteria = new HashMap<String, Criteria>();
		 * childCriteria.put("geography", geography);
		 * searchCriteria.setChildCriteria(childCriteria);
		 */

		// SearchCriteria countCriteria =
		// (SearchCriteria)searchCriteria.clone();
		// To ensure that the count is fetched for all the records.
		searchCriteria.setLength("-1");
		searchCriteria.setStart("0");

		setCriteria(searchCriteria, criteria);
		// criteria.setProjection(Projections.rowCount());
		Integer count = criteria.list().size();
		// Integer count = 1;
		return count;
	}

	@Override
	public Customer getCustomer(String customerId) {
		Customer customer = new Customer();
		try{
			customer = (Customer) openSession().createCriteria(Customer.class).add(Restrictions.eq("customerId", Integer.parseInt(customerId))).uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customerList = new ArrayList<Customer>();
		try{
			customerList = openSession().createCriteria(Customer.class).list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return customerList;
	}

	@Override
	public List<Supplier> getAllSuppliers() {
		List<Supplier> suppliers = new ArrayList<Supplier>();
		try{
			suppliers = openSession().createCriteria(Supplier.class).list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return suppliers;
	}

}
