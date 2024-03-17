import React from 'react';
import {
    MDBBtn,
    MDBInput,
    MDBModal, MDBModalBody,
    MDBModalContent,
    MDBModalDialog, MDBModalFooter,
    MDBModalHeader, MDBModalTitle,
} from "mdb-react-ui-kit";

const CreateCalculation = ({style}) => {
  return (
    <div>
    <MDBBtn className={style}>Создать расчет</MDBBtn>
    </div>
  );
};

export default CreateCalculation;