import React from 'react';
import {
    MDBBtn,
    MDBInput,
    MDBModal, MDBModalBody,
    MDBModalContent,
    MDBModalDialog, MDBModalFooter,
    MDBModalHeader, MDBModalTitle,
} from "mdb-react-ui-kit";

const CreateCalculation = ({ style, handleCreateCalculation }) => {
  return (
    <div>
    <MDBBtn className={style} onClick={handleCreateCalculation}>Создать расчет</MDBBtn>
    </div>
  );
};

export default CreateCalculation;