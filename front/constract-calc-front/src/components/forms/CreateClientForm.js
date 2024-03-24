import React, { useState } from 'react';
import { MDBInput, MDBBtn, MDBModal, MDBModalDialog, MDBModalContent, MDBModalHeader, MDBModalTitle, MDBModalBody, MDBModalFooter } from 'mdb-react-ui-kit';
import './CreateClientForm.css'

const CreateClientForm = ({ style, createClient }) => {
    const [basicModal, setBasicModal] = useState(false);
    const [lastname, setLastname] = useState('');
    const [firstname, setFirstname] = useState('');
    const [patronymic, setPatronymic] = useState('');
    const [telephone, setTelephone] = useState('');
    const [email, setEmail] = useState('');
    const [address, setAddress] = useState('');
    const [emailError, setEmailError] = useState('');


    const onSubmit = () => {
        if (!email.includes('@')) {
            setEmailError('Пожалуйста, введите корректный адрес электронной почты.');
            return;
        } else {
            setEmailError('');
        }

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
        };

        createClient(client);

        // закрытие формы
        setBasicModal(false);
    };

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
                            <MDBInput className='mb-4' type='text' id='lastname' label='Фамилия' value={lastname} onChange={(e) => setLastname(e.target.value)} />
                            <MDBInput className='mb-4' type='text' id='firstname' label='Имя' value={firstname} onChange={(e) => setFirstname(e.target.value)} />
                            <MDBInput className='mb-4' type='text' id='patronymic' label='Отчество' value={patronymic} onChange={(e) => setPatronymic(e.target.value)} />
                            <MDBInput className='mb-4' type='tel' id='telephone' label='Телефон' placeholder={"8xxxxxxxxxx"} maxLength={11} value={telephone} onChange={(e) => setTelephone(e.target.value)} />
                            <div className='mb-4'>
                                <MDBInput type='email' id='email' label='E-mail' value={email} onChange={(e) => setEmail(e.target.value)} />
                                {emailError && <p style={{ color: 'red', fontSize: 12 }}>{emailError}</p>}
                            </div>
                            <MDBInput className='mb-4' type='text' id='address' label='Адрес' value={address} onChange={(e) => setAddress(e.target.value)} />
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
