import React from 'react';
import {
    MDBBtn,
    MDBInput,
    MDBModal, MDBModalBody,
    MDBModalContent,
    MDBModalDialog, MDBModalFooter,
    MDBModalHeader, MDBModalTitle,
} from "mdb-react-ui-kit";
import ClientService from "../../services/ClientService";

const CreateClientForm = ({style, createClient}) => {
    const [basicModal, setBasicModal] = React.useState(false);
    const [lastname, setLastname] = React.useState('');
    const [firstname, setFirstname] = React.useState('');
    const [patronymic, setPatronymic] = React.useState('');
    const [telephone, setTelephone] = React.useState();
    const [email, setEmail] = React.useState('');
    const [address, setAddress] = React.useState('');

    const onSubmit = () => {
        const client = {
            firstName: firstname,
            lastName: lastname,
            secondName: patronymic,
            phone: telephone,
            mail: email,
            address: address,
            user: {
                id: JSON.parse(localStorage.getItem("user"))?.id || "1"
            }
        }
        createClient(client);
    }

    const toggleOpen = () => setBasicModal(!basicModal);
    return (
        <>
            <MDBBtn onClick={toggleOpen} className={style}>Создать клиента</MDBBtn>
            <MDBModal open={basicModal} setOpen={setBasicModal} tabIndex='-1'>
                <MDBModalDialog>
                    <MDBModalContent>
                        <MDBModalHeader>
                            <MDBModalTitle>Создание клиента</MDBModalTitle>
                            <MDBBtn className='btn-close' color='none' onClick={toggleOpen}></MDBBtn>
                        </MDBModalHeader>
                        <MDBModalBody>
                            <MDBInput className='mb-4' type='text' id='lastname' label='Фамилия' value={lastname}
                                      onChange={(e) => setLastname(e.target.value)}/>
                            <MDBInput className='mb-4' type='text' id='firstname' label='Имя' value={firstname}
                                      onChange={(e) => setFirstname(e.target.value)}/>
                            <MDBInput className='mb-4' type='text' id='patronymic' label='Отчество' value={patronymic}
                                      onChange={(e) => setPatronymic(e.target.value)}/>
                            <MDBInput className='mb-4' type='tel' id='telephone' label='Телефон'
                                      placeholder={"8xxxxxxxxxx"} maxLength={11} value={telephone}
                                      onChange={(e) => setTelephone(e.target.value)}/>
                            <MDBInput className='mb-4' type='email' id='email' label='E-mail' value={email}
                                      onChange={(e) => setEmail(e.target.value)}/>
                            <MDBInput className='mb-4' type='text' id='address' label='Адрес' value={address}
                                      onChange={(e) => setAddress(e.target.value)}/>
                        </MDBModalBody>
                        <MDBModalFooter>
                            <MDBBtn onClick={onSubmit}>Сохранить</MDBBtn>
                        </MDBModalFooter>
                    </MDBModalContent>
                </MDBModalDialog>
            </MDBModal>
        </>
    );
};

export default CreateClientForm;