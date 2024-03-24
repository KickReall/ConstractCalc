import React, { useState, useEffect } from 'react';
import ClientService from "../../services/ClientService";
import {
    MDBBtn, MDBInput,
    MDBModal,
    MDBModalBody,
    MDBModalContent,
    MDBModalDialog, MDBModalFooter,
    MDBModalHeader,
    MDBModalTitle
} from "mdb-react-ui-kit";

const EditClientForm = ({ style, clientId }) => {
    const [basicModal, setBasicModal] = React.useState(false);
    const [client, setClient] = React.useState(null);
    const [lastname, setLastname] = React.useState('');
    const [firstname, setFirstname] = React.useState('');
    const [patronymic, setPatronymic] = React.useState('');
    const [telephone, setTelephone] = React.useState('');
    const [email, setEmail] = React.useState('');
    const [address, setAddress] = React.useState('');
    const [isEdit, setIsEdit] = React.useState(false);

    const toggleOpen = () => setBasicModal(!basicModal);

    useEffect(() => {
        const getClientDetails = async () => {
            try {
                const response = await ClientService.getById(clientId);
                setClient(response.data);
                console.log(response.data);
            } catch (error) {
                console.error('Error fetching client details:', error);
            }
        };

        getClientDetails();

    }, [clientId]);

    if (!client) {
        return <div>Loading...</div>;
    }

    return (
        <>
            <MDBBtn onClick={toggleOpen} className={style}>Информация о клиенте</MDBBtn>
            <MDBModal open={basicModal} setOpen={setBasicModal} tabIndex='-1'>
                <MDBModalDialog>
                    <MDBModalContent>
                        <MDBModalHeader>
                            <MDBModalTitle>{isEdit ? "Редактирование" : "Информация"}</MDBModalTitle>

                        </MDBModalHeader>
                        <MDBModalBody>
                            <MDBInput
                                className='mb-4'
                                type='text'
                                id='lastname'
                                label='Фамилия'
                                value={client.lastName}
                                onChange={(e) => setLastname(e.target.value)}
                                disabled={!isEdit}
                            />
                            <MDBInput
                                className='mb-4'
                                type='text'
                                id='firstname'
                                label='Имя'
                                value={client.firstName}
                                onChange={(e) => setFirstname(e.target.value)}
                                disabled={!isEdit}
                            />
                            <MDBInput
                                className='mb-4'
                                type='text'
                                id='patronymic'
                                label='Отчество'
                                value={client.secondName}
                                onChange={(e) => setPatronymic(e.target.value)}
                                disabled={!isEdit}
                            />
                            <MDBInput className='mb-4' type='tel' id='telephone' label='Телефон'
                                placeholder={"8xxxxxxxxxx"} maxLength={11} value={client.phone}
                                onChange={(e) => setTelephone(e.target.value)}
                                disabled={isEdit ? false : true}
                            />
                            <MDBInput className='mb-4' type='email' id='email' label='E-mail' value={email}
                                onChange={(e) => setEmail(e.target.value)}
                                disabled={isEdit ? false : true}
                            />
                            <MDBInput className='mb-4' type='text' id='address' label='Адрес' value={client.address}
                                onChange={(e) => setAddress(e.target.value)}
                                disabled={isEdit ? false : true}
                            />
                        </MDBModalBody>
                        <MDBModalFooter className={'d-flex justify-content-between'}>
                            <MDBBtn onClick={() => setIsEdit(true)}>Редактировать</MDBBtn>
                            <MDBBtn>Сохранить</MDBBtn>
                        </MDBModalFooter>
                    </MDBModalContent>
                </MDBModalDialog>
            </MDBModal>
        </>
    );
};

export default EditClientForm;