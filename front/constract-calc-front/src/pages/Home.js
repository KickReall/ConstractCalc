import React from 'react';
import Header from "../components/Header";
import CreateClientForm from "../components/forms/CreateClientForm";
import ClientButton from "../components/ClientButton";
import ClientService from "../services/ClientService";
import ClientCard from "../pages/ClientCard";
import './Home.css';

const Home = () => {
    const [clients, setClients] = React.useState([]);
    const [selectedClientId, setSelectedClientId] = React.useState(null);
    const [visible, setVisible] = React.useState(false); 

    React.useEffect(() => {
        const getAllClients = async () => {
            await ClientService.getAll()
                .then((data) => {
                    setClients(data.data);
                    //console.log(data.data);
                });
        }
        getAllClients();
    }, []);

    
    /*const getById = async () => {
        await ClientService.getById(1)
            .then((data) => {
                console.log(data.data);
            });
    }*/

    const onSaveClient = async (client) => {
        await ClientService.create(client)
            .then(data => {
                const copyClients = [...clients, data.data];
                setClients(copyClients);
            });
    }

    const selectClient = (clientId) => {
        setSelectedClientId(clientId);
        setVisible(true);
        //getById();
    }

    return (
        <div className='page'>
            
            {!visible ? (
              <>
              <Header />  
                <div>
                    <h1 className='client'>Клиенты</h1>
                    <div>
                        <CreateClientForm style='create-button' createClient={onSaveClient} />
                    </div>
                    <div className="home-container">
                        {clients?.map((client, index) => (
                            <div key={index} className="client-card">
                                <ClientButton clientId={client.id} clientName={`${client.lastName} ${client.firstName} ${client.secondName}`} onClick={() => selectClient(client.id)} /> 
                            </div>
                        ))}
                    </div>
                </div>
                </>
            ) : (
                <ClientCard clientId={selectedClientId} />
            )}
        </div>
    );
};

export default Home;
