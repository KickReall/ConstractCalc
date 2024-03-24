import React, { useState, useEffect } from 'react';
import Header from '../components/Header';
import EditClientForm from '../components/forms/EditClientForm';
import CreateCalculation from '../components/forms/CreateCalculation';
import { ReactComponent as Miniarrowright } from '../svg/mini-arrow-right.svg';
import './ClientCard.css';
import ClientService from '../services/ClientService';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';

const statusOptions = ['Актуален', 'Не актуален', 'Заключен договор'];

const ClientCard = ({ clientId }) => {
    const [clients, setClients] = useState([]);
    const [selectedDate, setSelectedDate] = useState(new Date());
    const [selectedStatus, setSelectedStatus] = useState('');
    const [showStatusDropdown, setShowStatusDropdown] = useState(false);

    useEffect(() => {
        const getAllClients = async () => {
            const response = await ClientService.getAll();
            setClients(response.data || []);
        };
        getAllClients();
    }, []);

    const getClientNameById = (clientId) => {
        const client = clients.find((client) => client.id === clientId);
        return client ? client.firstName : 'Имя не найдено';
    };

    const handleCalculate = () => {
        // Handle calculation logic here
    };

    const handleShowDate = () => {
        const datepicker = document.getElementById('datepicker');
        datepicker.style.display = datepicker.style.display === 'none' ? 'block' : 'none';
    };

    const handleToggleStatusDropdown = () => {
        setShowStatusDropdown(!showStatusDropdown);
    };

    const handleStatusChange = (status) => {
        setSelectedStatus(status);
        setShowStatusDropdown(false);
    };

    const handleAddressChange = () => {
        // Handle address change logic here
    };

    const handleCopyInfo = () => {
        // Handle copying information logic here
    };

    const handleDeleteClient = () => {
        // Handle client deletion logic here
    };

    return (
        <>
            <Header />
            <div className="pers-nav-body">
                <a className="nav" href="/">
                    Все клиенты
                </a>
                <Miniarrowright className="arrow-right" />
                {clients.length ? (
                    <div className="nav" href="/card">
                        Клиент {getClientNameById(clientId)}
                    </div>
                ) : (
                    <p>Загрузка данных...</p>
                )}
            </div>
            <div className='page'>
                <h1 className='card-text'>Карточка клиента</h1>
                <EditClientForm clientId={clientId} style='edit-button' />
                <CreateCalculation style='create-calc' />
                <div className='client-bar'>
                    <button onClick={handleCalculate}>Расчет</button>
                    <button onClick={handleShowDate}>Выбрать дату: {selectedDate ? selectedDate.toLocaleDateString() : 'Дата не выбрана'}</button>
                    <div id="datepicker" style={{ display: 'none' }}>
                        <DatePicker selected={selectedDate} onChange={(date) => setSelectedDate(date)} />
                    </div>
                    <div className="status-dropdown">
                        <button onClick={handleToggleStatusDropdown}>Изменить статус: {selectedStatus || 'Выберите статус'}</button>
                        {showStatusDropdown &&
                            <div>
                                {statusOptions.map((option) => (
                                    <button key={option} onClick={() => handleStatusChange(option)}>{option}</button>
                                ))}
                            </div>
                        }
                    </div>

                    <button onClick={handleAddressChange}>Адрес строительства</button>
                    <button onClick={handleCopyInfo}>Скопировать информацию</button>
                    <button onClick={handleDeleteClient}>Удалить</button>
                </div>
            </div>
        </>
    );
};

export default ClientCard;



