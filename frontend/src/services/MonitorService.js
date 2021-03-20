import axios from 'axios';

const MONITORS_REST_API_URL = "http://localhost:8080/api/allMonitors";
const CREATE_REST_API_URL   = "http://localhost:8080/api/monitor/add";
const BASE_REST_API_URL     = "http://localhost:8080/api/";
const DELETE_REST_API_URL   = "http://localhost:8080/api/delete/";

class MonitorService { 

    listAllMonitors() {
        return axios.get(MONITORS_REST_API_URL);
    } 

    createMonitor(monitor) {
        return axios.post(CREATE_REST_API_URL, monitor);
    }

    getMonitorById(monitorId) {
        return axios.get(BASE_REST_API_URL + monitorId);
    }

    updateMonitor(monitorId, monitor) {
        return axios.put(BASE_REST_API_URL + monitor, monitorId);
    }

    deleteMonitor(monitorId) {
        axios.delete(DELETE_REST_API_URL + monitorId);
    }
}
 
export default new MonitorService();  