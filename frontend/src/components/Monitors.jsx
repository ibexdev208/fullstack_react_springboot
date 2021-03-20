//Imports
import React, {Component} from 'react';
import { FaTrash, FaEdit, FaPlus } from 'react-icons/fa';
// import { Link } from 'react-router-dom';
import axios from 'axios';   

//Components
import MonitorService from '../services/MonitorService';

class Monitor extends Component { 
    constructor(props) {
        super(props);
        this.state = {
            monitors: []
        };

        //Binding methods
        this.addMonitor = this.addMonitor.bind(this); 
        this.editMonitor = this.editMonitor.bind(this);
    } 

    // viewMonitor(id){
    //     this.props.history.push(`/viewMonitor/${id}`);
    // }

    editMonitor(id){
        this.props.history.push(`/addMonitor/${id}`);
    }

    componentDidMount() { 
        MonitorService.listAllMonitors().then(res => {
            this.setState({ 
                monitors: res.data
            })
            // .catch(function (ex) {
            //     console.log('Response parsing failed. Error: ', ex);
            // });
        });
    }

    //Add a monitor
    addMonitor(){
        this.props.history.push('/addMonitor/_add');
    }

    delete(id) {
        axios.delete(`http://localhost:8080/api/delete/${id}`)
        .then(() => {
            this.componentDidMount();
        });
    }

    render() {
        return ( 
            <div className="monitorsArea">
                <h1>Monitors</h1>
                <table className="table"> 
                    <thead>
                        <tr>
                            <th>Brand</th>
                            <th>Resolution</th>
                            <th>Model</th>
                            <th>Price</th>
                            <th colSpan={2}>Action</th>
                        </tr>
                    </thead> 
                    <tbody>
                        {
                            this.state.monitors.map(
                                monitor =>
                                <tr key={monitor.id}>
                                    <td>{monitor.brand}</td>
                                    <td>{monitor.resolution}</td>
                                    <td>{monitor.model}</td>
                                    <td>£{monitor.price}</td>
                                    <td>
                                        <button className="btn btn-danger" onClick={(e) => this.delete(monitor.id)} ><FaTrash /></button>
                                    </td>
                                    <td>
                                        <button className="btn btn-info" onClick={() => this.editMonitor(monitor.id)}><FaEdit /></button>
                                    </td>
                                </tr> 
                            )
                        }
                    </tbody> 
                    <tfoot>
                        <tr>
                            <td colSpan={6}>
                                <button className="btn btn-success" onClick={this.addMonitor}><FaPlus /> Monitor</button>
                            </td>
                        </tr>
                    </tfoot>
                </table>
            </div>
        );
    };
}

export default Monitor