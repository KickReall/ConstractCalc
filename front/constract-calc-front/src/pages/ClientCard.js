import React from 'react';
import Header from "../components/Header";
import EditClientForm from "../components/forms/EditClientForm";
import CreateCalculation from "../components/forms/CreateCalculation";
import { ReactComponent as Miniarrowright } from '../svg/mini-arrow-right.svg';
import './ClientCard.css';
import ClientService from "../services/ClientService";

const ClientCard = ({ clientId }) => {
    const [clients, setClients] = React.useState([]);

    React.useEffect(() => {
        const getAllClients = async () => {
            await ClientService.getAll().then((data) => {
                setClients(data.data);
            });
        }
        getAllClients();
    }, []);

    const getClientNameById = (clientId) => {
        const client = clients.find(client => client.id === clientId);
        console.log(clientId);
        return client ? client.firstName : "Имя не найдено";
    }

    return (
        <>
            
            <Header />
            <div className="pers-nav-body">
                <a className="nav" href="/">
                    Все клиенты
                </a>

                <Miniarrowright className="arrow-right" />
                {clients ? (
                    <div className="nav" href="/card">
                        Клиент {getClientNameById(clientId)}
                    </div>
                ) : (
                    <p>Загрузка данных...</p>
                )}
            </div>
            <div className='page'>
                <h1 className='card-text'>Карточка клиента</h1>
                <EditClientForm clientId={clientId} style='edit-button'/>
                <CreateCalculation style='create-calc'/>
            </div>

        </>
    );
}

export default ClientCard;

