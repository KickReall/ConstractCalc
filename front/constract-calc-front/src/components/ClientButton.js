import React from 'react';
import './ClientButton.css';

const ClientButton = ({ clientId, clientName, onClick }) => {
    return (
        <div>
            
                <button className="client-button" onClick={onClick}>
                    {clientName}
                </button>
            
        </div>
    );
};

export default ClientButton;

