import office1 from "./office1.png";

function App() {

  const office = {
    Name: "DBS Business Center",
    Rent: 55000,
    Address: "Hyderabad"
  };

  const officeList = [
    {
      Name: "DBS Business Center",
      Rent: 55000,
      Address: "Hyderabad"
    },
    {
      Name: "Cyber Towers",
      Rent: 75000,
      Address: "Hitech City"
    },
    {
      Name: "Mindspace",
      Rent: 85000,
      Address: "Madhapur"
    }
  ];

  return (
    <div className="App">

      <h1>Office Space Rental App</h1>

      <img
        src={office1}
        alt="Office"
        width="400"
      />

      <hr />

      <h2>Featured Office</h2>

      <h3>Name: {office.Name}</h3>

      <h3
        style={{
          color: office.Rent < 60000 ? "red" : "green"
        }}
      >
        Rent: Rs.{office.Rent}
      </h3>

      <h3>Address: {office.Address}</h3>

      <hr />

      <h2>Available Office Spaces</h2>

      {
        officeList.map((item, index) => (

          <div
            key={index}
            style={{
              border: "1px solid gray",
              padding: "15px",
              margin: "15px"
            }}
          >

            <h3>Name: {item.Name}</h3>

            <h3
              style={{
                color: item.Rent < 60000 ? "red" : "green"
              }}
            >
              Rent: Rs.{item.Rent}
            </h3>

            <h3>Address: {item.Address}</h3>

          </div>

        ))
      }

    </div>
  );
}

export default App;