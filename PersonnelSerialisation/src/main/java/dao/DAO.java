package main.java.dao;

/**
 * Interface DAO pour les operations CRUD ( create, read, update, delete)
 * @author claire
 *
 * @param <T>
 */
public abstract class DAO<T> {
	
	/**
	 * create 
	 * @param obj
	 * @return
	 */
	public abstract T create(T obj);

	
	/**
	 * find
	 * @param id
	 * @return
	 */	 
	public abstract T find(String id);

	/**
	 * update
	 * @param obj
	 * @return
	 */
	public abstract T update(T obj);

	/**
	 * delete
	 * @param obj
	 */
	public abstract void delete(T obj); 
	
}

