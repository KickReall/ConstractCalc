import './App.css';
import React from "react";
import { Navigate, Route, Routes } from "react-router-dom";
import { MDBContainer } from "mdb-react-ui-kit";
import 'mdb-react-ui-kit/dist/css/mdb.min.css';
import "@fortawesome/fontawesome-free/css/all.min.css";
import LoginPage from "./pages/LoginPage";
import Home from "./pages/Home";
import ClientCard from './pages/ClientCard';


function RequireAuth({ children, redirectTo }) {
    const token = localStorage.getItem('token');
    const user = localStorage.getItem('user');
    return (token && user) ? children : <Navigate to={redirectTo} />;
}

function App() {

    return (
        <div>
            <MDBContainer fluid>
                <Routes>
                    <Route path="/login" element={<LoginPage />} />
                    <Route
                        path="/home"
                        element={
                            <RequireAuth redirectTo="/login">
                                <Home />
                            </RequireAuth>
                        }
                    />
                    <Route path="*" element={<Home /> }/>
                    <Route path="/card" element={<ClientCard/>}/>
                </Routes>
            </MDBContainer>
        </div>
    );
}

export default App;
