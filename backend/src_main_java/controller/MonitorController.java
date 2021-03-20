package app.mysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.mysql.entity.Monitor;
import app.mysql.service.MonitorService;

//The CrossOrigin allows requests from specific origins
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping(path="/api")
public class MonitorController {

	@Autowired
	private MonitorService monitorService;

	// This end-point shows all monitors
	@GetMapping(path="/allMonitors")
	public List<Monitor> listAllMonitors() {
		
		return monitorService.getMonitors();
	}

	// This end-point shows a monitor based on a specific ID
	@GetMapping(path="/{id}")
	public Monitor getMonitorById(@PathVariable("id") Integer id) {
		
		return monitorService.getMonitor(id);
	}

	// This end-point shows a monitor based on a specific Brand's name
	@GetMapping(path="/monitor/{brand}")
	public List<Monitor> getByBrand(@PathVariable String brand) {
		return monitorService.getMonitorByBrand(brand);
	}

	// This end-point adds a new monitor into the database
	@PostMapping(path="/monitor/add", consumes= {"application/json"})
	public Monitor newMonitor(@RequestBody Monitor monitor) {
		return monitorService.addMonitor(monitor);
	}

	// This end-point adds several new monitors into the database
	@PostMapping(path="/monitor/addAll", consumes= {"application/json"})
	public List<Monitor> newMonitors(@RequestBody List<Monitor> monitors) {
		return monitorService.addMonitors(monitors);
	}

	//Update a monitor
	@PutMapping(path="/{id}", consumes= {"application/json"})
	public Monitor updateMonitor(@RequestBody Monitor monitor, @PathVariable ("id") Integer id) {
		return monitorService.editMonitor(monitor, id);
	}

	//Delete a monitor based on its ID
	@DeleteMapping(path="/delete/{id}")
	public void deleteMonitor(@PathVariable Integer id) {
		monitorService.deleteMonitorById(id);
	}
}
