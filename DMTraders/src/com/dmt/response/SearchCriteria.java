package com.dmt.response;

import java.util.HashMap;

import org.hibernate.Criteria;

/**
 * Search Criteria is used to pass on the search parameters for retrival of lists.
 *
 * @author Soubhagya Ranjan Mishra
 */
public class SearchCriteria implements Cloneable{
	
	/**
	 * Denotes the start record number from where the pagination search to be
	 * started. For e.g. if the length of the page is 10 and current we are at
	 * page no 3, then start would be 31.
	 */
	private String start;
	
	/** Denotes the page length, i.e. no of records to be viewed in each page. */
	private String length;
	
	/** Denotes the column on which the sorting to be applied.   */
	private String order;
	
	/** Denotes the sorting direction. Valid values are 1) asc 2) desc. */
	private String direction;
	
	private HashMap<String, String> search = new HashMap<String, String>();
	
	private boolean multipleObects = false;
	
	private HashMap<String, Criteria > childCriteria = new HashMap<String, Criteria>();
	
	private String loginUser;
	
	private String userId;
	
	public HashMap<String, Criteria> getChildCriteria() {
		return childCriteria;
	}

	public void setChildCriteria(HashMap<String, Criteria> childCriteria) {
		this.childCriteria = childCriteria;
	}
	
	public Criteria getCriteria(String key){
		return childCriteria.get(key);
	}

	public boolean isMultipleObects() {
		return multipleObects;
	}

	public void setMultipleObects(boolean multipleObects) {
		this.multipleObects = multipleObects;
	}

	public HashMap<String, String> getSearch() {
		return search;
	}

	public void setSearch(HashMap<String, String> search) {
		this.search = search;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}


	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public  Object clone() throws CloneNotSupportedException {
		 SearchCriteria sc = new SearchCriteria();
		 sc.setDirection(this.direction);
		 sc.setLength(this.length);
		 sc.setOrder(this.order);
		 sc.setSearch(this.search);
		 sc.setStart(this.start);
		return sc;
	}

	
	public String[] getQualifiedNames(String qualifiedName){
		String key[] = new String[2];
		key[0] =  qualifiedName.substring(0, qualifiedName.indexOf("."));
		key[1] = qualifiedName.substring(qualifiedName.indexOf(".")+1 , qualifiedName.length());
		return key;
		
	}

	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}
