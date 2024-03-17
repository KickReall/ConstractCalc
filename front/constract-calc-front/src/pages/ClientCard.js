import React from 'react';
import Header from "../components/Header";
import EditClientForm from "../components/forms/EditClientForm";
import CreateCalculation from "../components/forms/CreateCalculation"
import { ReactComponent as Miniarrowright } from '../svg/mini-arrow-right.svg';
import './ClientCard.css';

const ClientCard = ({ clientName }) => {

    return (
        <>
        <Header />
        
        <div className="pers-nav-body">
              <a className="nav" href="/">
                Все клиенты
              </a>

              <Miniarrowright className="arrow-right" />
              <a className="nav" href="/card">
                Клиент
              </a>
        </div>
        <div className='page'>         
            <h1 className='card-text'>Карточка клиента</h1>
            <EditClientForm style='edit-button'/>
            <CreateCalculation style='create-calc'/>
        </div>
        
        </>
    );
}

export default ClientCard;
