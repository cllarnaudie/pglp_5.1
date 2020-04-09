package main.java.dao;


import main.java.Personnel;

/**
 * Fabrique pour l instanciation des DAO
 * @author devc
 *
 */
public class DAOFactory {
	
	public static DAO <Personnel> getPersonnelDAO() {
		return new PersonnelDAO();
	}
}


