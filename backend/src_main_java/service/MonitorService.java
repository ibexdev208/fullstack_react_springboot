package app.mysql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.mysql.dao.MonitorDao;
import app.mysql.entity.Monitor;
import app.mysql.exception.MonitorNotFoundException;

@Service
public class MonitorService {

	@Autowired
	private MonitorDao monitorDao;


	// Returns a list of all monitors found in the database
	public List<Monitor> getMonitors() {
		List<Monitor> monitors = monitorDao.findAll();

		if(monitors.isEmpty()) {
			throw new MonitorNotFoundException("The database seems to be empty... Add some data and try again");
		}
		return monitorDao.findAll();
	}

	// Returns a monitor based on its ID
	public Monitor getMonitor(Integer id) {
		
		return monitorDao.findById(id)
				.orElseThrow(() -> new MonitorNotFoundException("The following ID [" + id + "] is invalid"));
	}

	// Returns a monitor based on their Brand's name
	public List<Monitor> getMonitorByBrand(String brand) {
		List<Monitor> brnd = monitorDao.findByBrand(brand);
		
		if(brnd.isEmpty()) {
			throw new MonitorNotFoundException("The following brand [" + brand + "] is invalid");
		}
		
		return monitorDao.findByBrand(brand);
	}

	// Creates a new monitor
	public Monitor addMonitor(Monitor monitor) {
		return monitorDao.save(monitor);
	}

	// Creates multiple new monitors
	public List<Monitor> addMonitors(List<Monitor> monitors) {
		return monitorDao.saveAll(monitors);
	}

	// Edits a monitor
	public Monitor editMonitor(Monitor monitor, Integer id) {
		Monitor getMonitor = monitorDao.findById(id)
		.orElseThrow(() -> new MonitorNotFoundException("The following ID [" + id + "] is invalid"));

		getMonitor.setBrand(monitor.getBrand());
		getMonitor.setResolution(monitor.getResolution());
		getMonitor.setModel(monitor.getModel());
		getMonitor.setPrice(monitor.getPrice());
		
		return monitorDao.save(getMonitor);
	}

	// Deletes a monitor
	public void deleteMonitorById(Integer id) {
		Monitor getMonitor = monitorDao.findById(id).orElse(null);
		
		if(getMonitor == null) {
			throw new MonitorNotFoundException("The following ID [" + id + "] is invalid");
		}
		
		monitorDao.deleteById(id);
	}
}
