import React from 'react';
import './ClientButton.css';

const ClientButton = ({ clientName, onClick }) => {
  return (
    <div>
      <a href='/card'>
        <button className="client-button" onClick={onClick}>
          {clientName}
        </button>
      </a>
    </div>
  );
};

export default ClientButton;

