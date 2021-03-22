package app.mysql.dao;

/*
 * This repository interface is bind to the Monitor entity model and extends the JpaRepository 
 * interface from Spring Data JPA. The repository interface also passes to Spring Data JPA 
 * the domain type (Monitor) and ID type (Integer).
 * The repository acts as bridge between the data access layer and business logic layer.
 * The JpaRepository defines standard CRUD methods hence no need to write them as Spring Data JPA 
 * generates necessary code at runtime.
 */



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.mysql.entity.Monitor;

/* 
 * The @Repository annotation state that the underlying interface is a repository which Spring 
 * register as a bean in the context during component scan.*/
@Repository
public interface MonitorDao extends JpaRepository<Monitor, Integer> {
	
	/*
	 * User defined queries can be created within the repository which Spring Data parses 
	 * the method in order to generate a specific query.
	 * A SELECT query is created to retrieve required data, in this instance retrieving a 
	 * monitor’s details based on its brand name.
	 */
	List<Monitor> findByBrand(String brand);
}
