import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import ReactTable from 'react-table'
import 'react-table/react-table.css'

class App extends Component {
    constructor (props) {
        super(props);
        this.state = {listItem: [], text:''};
    }



    addTodo = () => {
        fetch('https://api.github.com/search/repositories?q='+this.state.text)
            .then((response) => response.json())
            .then((responseData) => {
                console.log(responseData);
                this.setState({
                    listItem: responseData.items
                });
            });
    }

    inputChanged = (event) => {
        this.setState({text: event.target.value});
        console.log(this.state.text);
    }




    render() {
        console.log(this.state.listItem);
        const columns = [{
            Header: 'Name',
            accessor: 'full_name' // String-based value accessors!
        }, {
            Header: 'Url',
            accessor: 'owner.url',
            //filterable: false

        }]







        //*const itemRows= this.state.listItem.map(
        //(app) =>
        //<tr key={app.full_name}>
        // <td>{app.full_name}</td>
        // <td><a href={app.owner.url}>{app.owner.url}</a></td>
        //</tr>

        //);


        return (
            <div>

                <form onSubmit={this.addTodo}>
                    <input type="text" onChange={this.inputChanged} value={this.state.text}/>
                    <input type="submit" value="Add"/>
                </form>//
                <h2>App lists</h2>
                <div>
                    <ReactTable
                        data={this.state.listItem}
                        columns={columns}
                        filterable={true}
                    />
                </div>
            </div>



        );

    }
}

export default App;

