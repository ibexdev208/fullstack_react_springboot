package app.mysql.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.mysql.entity.Monitor;

@Repository
public interface MonitorDao extends JpaRepository<Monitor, Integer> {

	List<Monitor> findByBrand(String brand);
}
