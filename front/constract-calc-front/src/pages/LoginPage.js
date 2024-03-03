import React from 'react';
import { MDBBtn, MDBInput } from "mdb-react-ui-kit";

import '../App.css';

const LoginPage = () => {
    const [login, setLogin] = React.useState('');
    const [password, setPassword] = React.useState('');
    const [isValid, setIsValid] = React.useState();

    React.useEffect(() => {
        const boolPassword = validatePassword();
        if (login && password && boolPassword) {
            setIsValid(true);
        } else {
            setIsValid(false);
        }
    }, [login, password]);

    const validatePassword = () => {
        const passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{6,}$/;
        if (passwordRegex.test(password)) {
            return true;
        }
        return false;
    };

    const onSubmit = async () => {

    }

    return (
        <div className="loginForm">
            <h2>Constract Calc Logo</h2>
            <div className='loginForm__input'>
                <MDBInput
                    value={login}
                    onChange={(e) => setLogin(e.target.value)}
                    label='Введите логин'
                    type='text'
                />
                <div>
                    <MDBInput
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        label='Введите пароль'
                        style={{ borderColor: isValid ? '' : 'red' }}
                        type='password'
                    />
                    {password && !isValid && (
                        <p style={{ color: 'red', fontSize: 12 }}>
                            Пароль должен содержать минимум 6 символов, содержать латинские символы, цифры и спецсимволы
                        </p>
                    )}
                </div>

            </div>

            <MDBBtn
                disabled={!isValid ? true : false}
                onClick={onSubmit}
            >Войти</MDBBtn>
        </div>
    );
};

export default LoginPage;