import React, { Component } from 'react';
import ReactTable from "react-table";
import "react-table/react-table.css";
import { ToastContainer, toast } from 'react-toastify';
class CarList extends Component {
    constructor(props) {
        super(props);
        this.state = {cars: []};
    };


    componentDidMount() {
        fetch('https://carstockrest.herokuapp.com/cars')
            .then((response) => response.json())
            .then((responseData) => {
                this.setState({
                    cars : responseData._embedded.cars
                });
            });
        console.log(responseData);
    };


//* Header: "First Name", implement react-table. then add delete button
   // accessor: "firstName"
    // Cell: ({value}) => (<button onClick={() => this.deleteCar(value)}>Delete</button>
//



deleteCar = (value) => {
        fetch(value, {method: 'DELETE'}).then(this.loadCar());
        toast.success("Car deleted", {
        position: toast.POSITION_TOP_RIGHT });

};

    //render() {
    //    const rows = this.state.cars.map(value => <tr><td>{value.brand}</td><td>{value.price}</td><td>{value.color}</td><td>{value.fuel}</td><td>{value.year}</td></tr>)
      //  return (
       //     <div>
        //        <h1>This is the Car List</h1>
         //       <table>
           //         <tbody>
           //         {rows}
             //       </tbody>
             //   </table>
        //    </div>
      //  );
    //
    render() {
        const { data } = this.state.cars;
        return (
            <div>
                <ReactTable
                    data={data}
                    columns={[
                        {
                            Header: "Name",
                            columns: [
                                {
                                    Header: "Brand",
                                    accessor: "brand"
                                },
                                {
                                    Header: "Price",
                                    accessor: "price"
                                },
                                {
                                    Header: "Color",
                                    accessor: "color"
                                },
                                {
                                    Header: "Fuel",
                                    accessor: "fuel"
                                },
                                {
                                    Header: "Year",
                                    accessor: "year"
                                }
                            ]
                        }
                    ]}

                />
                <ToastContainer></ToastContainer>
            </div>
        );
    }




}
        export default CarList;
