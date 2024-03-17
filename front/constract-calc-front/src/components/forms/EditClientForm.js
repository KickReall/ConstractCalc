import React from 'react';
import {
    MDBBtn, MDBInput,
    MDBModal,
    MDBModalBody,
    MDBModalContent,
    MDBModalDialog, MDBModalFooter,
    MDBModalHeader,
    MDBModalTitle
} from "mdb-react-ui-kit";

const EditClientForm = ({style}) => {
    const [basicModal, setBasicModal] = React.useState(false);
    const [lastname, setLastname] = React.useState('');
    const [firstname, setFirstname] = React.useState('');
    const [patronymic, setPatronymic] = React.useState('');
    const [telephone, setTelephone] = React.useState();
    const [email, setEmail] = React.useState('');
    const [address, setAddress] = React.useState('');
    const [isEdit, setIsEdit] = React.useState(false);

    const toggleOpen = () => setBasicModal(!basicModal);
    return (
        <>
            <MDBBtn onClick={toggleOpen} className={style}>Информация о клиенте</MDBBtn>
            <MDBModal open={basicModal} setOpen={setBasicModal} tabIndex='-1'>
                <MDBModalDialog>
                    <MDBModalContent>
                        <MDBModalHeader>
                            <MDBModalTitle>{isEdit === true ? "Редактирование" : "Информация"}</MDBModalTitle>
                            <MDBBtn className='btn-close' color='none' onClick={toggleOpen}></MDBBtn>
                        </MDBModalHeader>
                        <MDBModalBody>
                            <MDBInput className='mb-4' type='text' id='lastname' label='Фамилия' value={lastname}
                                      onChange={(e) => setLastname(e.target.value)}
                                      disabled={isEdit ? false : true}
                            />
                            <MDBInput className='mb-4' type='text' id='firstname' label='Имя' value={firstname}
                                      onChange={(e) => setFirstname(e.target.value)}
                                      disabled={isEdit ? false : true}
                            />
                            <MDBInput className='mb-4' type='text' id='patronymic' label='Отчество' value={patronymic}
                                      onChange={(e) => setPatronymic(e.target.value)}
                                      disabled={isEdit ? false : true}
                            />
                            <MDBInput className='mb-4' type='tel' id='telephone' label='Телефон'
                                      placeholder={"+7xxxxxxxxxx"} maxLength={12} value={telephone}
                                      onChange={(e) => setTelephone(e.target.value)}
                                      disabled={isEdit ? false : true}
                            />
                            <MDBInput className='mb-4' type='email' id='email' label='E-mail' value={email}
                                      onChange={(e) => setEmail(e.target.value)}
                                      disabled={isEdit ? false : true}
                            />
                            <MDBInput className='mb-4' type='text' id='address' label='Адрес' value={address}
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