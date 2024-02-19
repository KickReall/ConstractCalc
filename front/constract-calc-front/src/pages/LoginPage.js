import React from 'react';
import { MDBBtn, MDBInput } from "mdb-react-ui-kit";

import '../App.css';

const LoginPage = () => {
    return (
        <div className="loginForm">
            <h2>Constract Calc Logo</h2>
            <div className='loginForm__input'>
                <MDBInput label='Введите логин' type='text' />
                <MDBInput label='Введите пароль' type='password' />
            </div>

            <MDBBtn>Войти</MDBBtn>
        </div>
    );
};

export default LoginPage;