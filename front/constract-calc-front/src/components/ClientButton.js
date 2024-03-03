import React from 'react';
import './ClientButton.css';

const ClientButton = ({ clientName, onClick }) => {
  return (
    <button className="client-button" onClick={onClick}>
      Иванов Иван Иванович {clientName}
    </button>
  );
};

export default ClientButton;
