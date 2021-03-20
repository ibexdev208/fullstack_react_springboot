//Imports
import React, { Component } from 'react';
import MonitorService from '../services/MonitorService';
import { FaTimes } from 'react-icons/fa';
import { Link } from 'react-router-dom';
// import { Form } from 'react-advanced-form';
// import { Input } from 'react-advanced-form-addons';

//Components
// import MonitorService from '../services/MonitorService';

class AddMonitor extends Component {

    constructor(props) {
        super(props); 
        this.state = {
            id: this.props.match.params.id,
            brand: '',
            resolution: '',
            model: '',
            price: ''
        }

        //Bind handlers to the component
        this.changeBrandHandler = this.changeBrandHandler.bind(this);
        this.changeResolutionHandler = this.changeResolutionHandler.bind(this);
        this.changeModelHandler = this.changeModelHandler.bind(this);
        this.changePriceHandler = this.changePriceHandler.bind(this);
        this.saveMonitor = this.saveMonitor.bind(this);
    }//constructor() 

    initialState = { 
        brand: '',
        resolution: '',
        model: '',
        price: ''
     }

    componentWillMount() {
        
        if(this.state.id === '_add') {
            return
        }else{
            MonitorService.getMonitorById(this.state.id)
            .then((res) => {
                let monitor = res.data;
                this.setState({
                    brand: monitor.brand,
                    resolution: monitor.resolution,
                    model: monitor.model,
                    price: monitor.price
                });
            });
        }
    }

    saveMonitor = (e) => {
        e.preventDefault();
        let monitor = {
           brand: this.state.brand,
           resolution: this.state.resolution,
           model: this.state.model,
           price: this.state.price
        }

        if(this.state.id === '_add') {
           MonitorService.createMonitor(monitor).then(res => {
               //Reset all fields
               this.setState(() => this.initialState);
            });
        }else{
           MonitorService.updateMonitor(monitor, this.state.id).then(res => {
               this.props.history.push('/monitors')
           });
        }
   }

    changeBrandHandler = (e) => {
        this.setState({brand: e.target.value})
    }

    changeResolutionHandler = (e) => {
        this.setState({resolution: e.target.value})
    }

    changeModelHandler = (e) => {
        this.setState({model: e.target.value})
    }

    changePriceHandler = (e) => {
        this.setState({price: e.target.value})
    }

    cancel(){
        this.props.history.push('/monitors');
    }

    getTitle() {
        if(this.state.id === '_add') {
            return <h3>Add Monitor</h3>
        }else{
            return <h3>Edit Monitor</h3>
        }
    }

    render() {
        return (
            <div className="newMonitorArea">
                { this.getTitle() }
                <form id="myForm">
                    <table className="table">
                        <tbody>
                            <tr>
                                <td>Brand:</td><td><input type="text" id="brand" name="brand"
                                onChange={this.changeBrandHandler} value={this.state.brand} /></td>
                            </tr>
                            <tr>
                                <td>Resolution:</td><td><input type="text" id="resolution" name="resolution"
                                onChange={this.changeResolutionHandler} value={this.state.resolution} /></td>
                            </tr>
                            <tr>
                                <td>Model:</td><td><input type="text" id="model" name="model"
                                onChange={this.changeModelHandler} value={this.state.model} /></td>
                            </tr>
                            <tr>
                                <td>Price:</td><td><input type="text" id="price" name="price"
                                onChange={this.changePriceHandler} value={this.state.price} /></td>
                            </tr>
                        </tbody>
                    </table>
                    <button className="btn btn-success" onClick = {this.saveMonitor}>Save</button>
                    <Link to="/monitors">
                        <button className="btn btn-danger"><FaTimes /></button>
                    </Link>
                </form>
            </div>
        );
    }
}

export default AddMonitor
