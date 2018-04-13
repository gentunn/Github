import React, { Component } from 'react';
import SkyLight from 'react-skylight';


class Editcar extends Component {
    constructor(props) {
        super(props) ;
        this.state= this.props.car;
    };




handleChange=(event) => {

this.setState ({
[event.target.name]: event.target.value
})

};

handleSubmit=(event) => {
event.preventDefault();
const car = {brand: this.state.brand, model: this.state.model,year: this.state.year, color: this.state.color, fuel:this.state.fuel, price:this.state.price };
this.props.updateCar(this.props.link , car);
this.simpleDialog.hide();
};


// no validate yet, so enter numbers in numbers fields

    render() {
        return (
            <div >
                <SkyLight hideOnOverlayClicked ref={ref => this.simpleDialog = ref} title="Edit car">
                    <form>
                        <div className={"form-group"}>
                            <input style={{marginBottom:20}} value={this.state.brand} placeholder= "Brand" className="form-control" name="brand" onChange={this.handleChange}></input>
                            <input style={{marginBottom:20}} value={this.state.model} placeholder= "Model" className="form-control" name="model" onChange={this.handleChange}></input>
                            <input style={{marginBottom:20}} value={this.state.year} placeholder= "Year" className="form-control" name="year" onChange={this.handleChange}></input>
                            <input style={{marginBottom:20}} value={this.state.color} placeholder= "Color" className="form-control" name="color" onChange={this.handleChange}></input>
                            <input style={{marginBottom:20}} value={this.state.fuel} placeholder= "Fuel" className="form-control" name="fuel" onChange={this.handleChange}></input>
                            <input style={{marginBottom:20}} value={this.state.price} placeholder= "Price" className="form-control" name="price" onChange={this.handleChange}></input>
                            <button style={{margin:20}} className="btn btn-primary" onClick={this.handleSubmit}>Save</button>
                        </div>
                    </form>
                </SkyLight>
                <button style={{margin:20}} className="btn btn-primary" onClick={() => this.simpleDialog.show()}>Edit car</button>
            </div>
        );
    }
}

export default Editcar;
