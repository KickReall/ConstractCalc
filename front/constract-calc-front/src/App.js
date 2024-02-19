import './App.css';
import React from "react";
import { MDBBtn, MDBContainer, MDBInput } from "mdb-react-ui-kit";
import 'mdb-react-ui-kit/dist/css/mdb.min.css';
import "@fortawesome/fontawesome-free/css/all.min.css";
import LoginPage from "./pages/LoginPage";

function App() {
  return (
    <div>
      <MDBContainer fluid>
          <LoginPage />
      </MDBContainer>
    </div>
  );
}

export default App;
