import { useState } from "react";

function ComplaintRegister() {

    const [employeeName, setEmployeeName] = useState("");
    const [complaint, setComplaint] = useState("");

    const handleSubmit = (event) => {

        event.preventDefault();

        const referenceNumber =
            Math.floor(100000 + Math.random() * 900000);

        alert(
            `Thanks ${employeeName}\n\nYour Complaint was Submitted.\nReference Number : ${referenceNumber}`
        );

        setEmployeeName("");
        setComplaint("");
    };

    return (

        <div className="container">

            <h1 style={{color : "red"}}>Register Your Complaints Here !!</h1>

            <form onSubmit={handleSubmit}>

                <div className="field">

                    <label>Employee Name :</label>

                    <input
                        type="text"
                        value={employeeName}
                        onChange={(e) => setEmployeeName(e.target.value)}
                        required
                    />

                </div>

                <div className="field">

                    <label>Complaint :</label>

                    <textarea
                        rows="5"
                        cols="30"
                        value={complaint}
                        onChange={(e) => setComplaint(e.target.value)}
                        required
                    />

                </div>

                <button type="submit">
                    Submit
                </button>

            </form>

        </div>

    );
}

export default ComplaintRegister;