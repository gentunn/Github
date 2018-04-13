import React, { Component } from 'react';
import ReactTable from "react-table";
import "react-table/react-table.css";
import { confirmAlert } from 'react-confirm-alert'; // Import
import 'react-confirm-alert/src/react-confirm-alert.css' // Import css
import Addcar from './Addcar.js';
import Editcar from './Editcar.js';
import {CSVLink, CSVDownload} from 'react-csv';

class Carlist extends Component {
    state = { cars: [] };

    componentDidMount() {
        this.loadCars();
    }

    // Load cars from REST API
    loadCars = () => {
        fetch('https://carstockrest.herokuapp.com/cars')
            .then((response) => response.json())
            .then((responseData) => {
                this.setState({
                    cars: responseData._embedded.cars,
                });
            })
    }

    // Delete car
    onDelClick = (idLink) => {
        confirmAlert({
            title: 'Confirm to submit',
            message: 'Are you sure to do this.',
            buttons: [
                {
                    label: 'Yes',
                    onClick: () =>
                        fetch(idLink, {method: 'DELETE'})
                            .then(res => this.loadCars())
                            .catch(err => console.error(err))
                },
                {
                    label: 'No',
                    onClick: () => alert('Click No')
                }
            ]
        })

    }


addCar = (newCar) => {
    fetch('https://carstockrest.herokuapp.com/cars', {method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify(newCar)})
        .then(res => this.loadCars())
        .catch(err => console.error(err))

}

    updateCar = (link, car) => {
        fetch(link, {method: 'PUT', headers: {'Content-Type': 'application/json'}, body: JSON.stringify(car)})
            .then(res => this.loadCars())
            .catch(err => console.error(err))

    }





    render() {
        return (
            <div className="App-body">
                <div className="row">
                    <Addcar addCar={this.addCar}/>
                    <CSVLink data={this.state.cars} >Download me</CSVLink>
                </div>
                <ReactTable data={this.state.cars}
                            columns={[
                                {
                                    columns: [
                                        {
                                            Header: "Id",
                                            accessor: "_links.self.href",
                                            show: false
                                        },
                                        {
                                            Header: "Brand",
                                            accessor: "brand"
                                        },
                                        {
                                            Header: "Model",
                                            accessor: "model",
                                        },
                                        {
                                            Header: "Year",
                                            accessor: "year",
                                        },
                                        {
                                            Header: "Color",
                                            accessor: "color",
                                        },
                                        {
                                            Header: "Fuel",
                                            accessor: "fuel",
                                        },
                                        {
                                            id: 'button',
                                            sortable: false,
                                            filterable: false,
                                            accessor: '_links.self.href',
                                            Cell: ({value}) => (<button className="btn btn-default btn-link" onClick={()=>{this.onDelClick(value)}}>Delete</button>)
                                        },
                                        {
                                            id: 'button',
                                            sortable: false,
                                            filterable: false,
                                            accessor: '_links.self.href',
                                            Cell: ({row, value}) => <Editcar updateCar={this.updateCar} link={value} car={row}/>
                                        }
                                    ]
                                }
                            ]}
                            defaultPageSize={10}
                            filterable
                            className="-striped -highlight" >
                </ReactTable>,
            </div>
        );
    }
}

export default Carlist;