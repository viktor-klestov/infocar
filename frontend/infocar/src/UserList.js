import React, { Component } from 'react';

class UserList extends Component {
  state = {
    name: '',
    sort: 'asc',
    users: [],
  };

  handleNameChange = (e) => {
    this.setState({ name: e.target.value }, this.searchUsers);
  };

  handleSortChange = (e) => {
    this.setState({ sort: e.target.value }, this.searchUsers);
  };

  searchUsers = () => {
    const { name, sort } = this.state;
    fetch(`/users?name=${name}&sort=name:${sort}`)
      .then((response) => response.json())
      .then((data) => {
        this.setState({ users: data });
      })
      .catch((error) => {
        console.error('Error:', error);
      });
  };

  componentDidMount() {
    this.searchUsers();
  }

  render() {
    const { users } = this.state;

    return (
      <div>
        <h1>User List</h1>
        <label htmlFor="name">Search by Name:</label>
        <input
          type="text"
          id="name"
          placeholder="Username"
          onChange={this.handleNameChange}
        />
        <select onChange={this.handleSortChange}>
          <option value="asc">Sort by Name (Asc)</option>
          <option value="desc">Sort by Name (Desc)</option>
        </select>
        <table>
          {users.map((user) => (
            <tr><td>{user.id}</td><td>{user.name}</td></tr>
          ))}
        </table>
      </div>
    );
  }
}

export default UserList;

