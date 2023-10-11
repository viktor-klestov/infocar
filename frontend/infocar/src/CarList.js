import React, { Component } from 'react';

class CarList extends Component {
  state = {
    make: '',
    model: '',
    numberplate: '',
    sort: 'make:asc',
    cars: [],
  };

  handleMakeChange = (e) => {
    this.setState({ make: e.target.value }, this.searchCars);
  };
  
  handleModelChange = (e) => {
    this.setState({ model: e.target.value }, this.searchCars);
  };
  
  handleNumberplateChange = (e) => {
    this.setState({ numberplate: e.target.value }, this.searchCars);
  };

  handleSortChange = (e) => {
    this.setState({ sort: e.target.value }, this.searchCars);
  };

  searchCars = () => {
    const { make, model, numberplate, sort } = this.state;
    fetch(`/cars?make=${make}&model=${model}&numberplate=${numberplate}&sort=${sort}`)
      .then((response) => response.json())
      .then((data) => {
        this.setState({ cars: data });
      })
      .catch((error) => {
        console.error('Error:', error);
      });
  };

  componentDidMount() {
    this.searchCars();
  }

  render() {
    const { cars } = this.state;

    return (
      <div>
        <h1>Car List</h1>
        <label htmlFor="Make">Search by make:</label>
        <input
          type="text"
          id="make"
          placeholder="Make"
          onChange={this.handleMakeChange}
        />
        <label htmlFor="Model">Search by model:</label>
        <input
          type="text"
          id="model"
          placeholder="Model"
          onChange={this.handleModelChange}
        />
        <label htmlFor="Numberplate">Search by numberplate:</label>
        <input
          type="text"
          id="numberplate"
          placeholder="Numberplate"
          onChange={this.handleNumberplateChange}
        />
        <select onChange={this.handleSortChange}>
          <option value="make:asc">Sort by Make (Asc)</option>
          <option value="make:desc">Sort by Make (Desc)</option>
          <option value="model:asc">Sort by Model (Asc)</option>
          <option value="model:desc">Sort by Model (Desc)</option>
          <option value="numberplate:asc">Sort by Numberplate (Asc)</option>
          <option value="numberplate:desc">Sort by Numberplate (Desc)</option>
        </select>
        <table>
          {cars.map((car) => (
            <tr><td>{car.id}</td><td>{car.make}</td><td>{car.model}</td><td>{car.numberplate}</td></tr>
          ))}
        </table>
      </div>
    );
  }
}

export default CarList;
