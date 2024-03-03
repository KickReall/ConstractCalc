import React from 'react';
import Header from "../components/Header";
import CreateClientForm from "../components/forms/CreateClientForm";
import ClientButton from "../components/ClientButton";
import './Home.css';

const users = ["User A", "User B", "User C", "User D", "User F", "User G"];

const Home = () => {
  return (
    <div className='page'>
      <Header />
      
      <h1 className='client'>Клиенты</h1>
      <div>
      <CreateClientForm style='create-button' />
      </div>
      <div className="home-container">
        
        {users.map((user, index) => (
          <div key={index} className="client-card">
            <ClientButton clientName={user} />
          </div>
        ))}
      </div>
    </div>
  );
};

export default Home;