import React, { Component } from 'react';
class Getuser extends Component {
  constructor(props) {
    super(props);
    this.state = {
      loading: true,
      person: null
    };
  }
  async componentDidMount() {
    const url = "https://api.randomuser.me/";
    const response = await fetch(url);
    const data = await response.json();
    this.setState({ person: data.results[0], loading: false });
    console.log(data.results[0]);
  }
  render() {
    if (this.state.loading) {
      return <div>Loading...</div>;
    }

    if (!this.state.person) {
      return <div>No user found.</div>;
    }

    const { name, picture } = this.state.person;

    return (
      <div style={{ padding: '20px' }}>
        <h1>
          {name.title} {name.first} {name.last}
        </h1>
        <img src={picture.large} alt={`${name.first} ${name.last}`} />
      </div>
    );
  }
}

export default Getuser;