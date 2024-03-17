import React from 'react';
import Header from "../components/Header";
import CreateClientForm from "../components/forms/CreateClientForm";
import ClientButton from "../components/ClientButton";
import ClientService from "../services/ClientService";
import './Home.css';



const users = [
  { firstName: "Иванов", lastName: "Иван", middleName: "Иванович" },
  { firstName: "Петров", lastName: "Петр", middleName: "Петрович" },
  // Добавьте других пользователей здесь
];

const Home = () => {
    const [clients, setClients] = React.useState([]);

    React.useEffect(() => {
        const getAllClients = async () => {
            await ClientService.getAll().then((data) => {
                setClients(data.data);
            });
        }
        getAllClients();
    }, [])

    const onSaveClient = async (client) => {
        await ClientService.create(client)
            .then(data => {
                const copyClients = clients.concat([]);
                copyClients.push(data.data);
                setClients(copyClients);
            });
    }

  return (
    <div className='page'>
      <Header />

      <h1 className='client'>Клиенты</h1>
      <div>
      <CreateClientForm style='create-button'
                        createClient={onSaveClient}
      />
      </div>
      <div className="home-container">
        
        {clients?.map((user, index) => (
          <div key={index} className="client-card">
            <ClientButton clientName={user.firstName} />

          </div>
        ))}
      </div>
    </div>
  );
};

export default Home;