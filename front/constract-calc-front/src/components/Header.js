import React from 'react';
import { ReactComponent as CabinetIcon } from '../svg/cabinet.svg';
import './Header.css';
import EditClientForm from "../components/forms/EditClientForm";


const Header = () => {
  return (
    <header className="header">
      <h1 className='logo'>Constract Calc Logo</h1>
      
      <a className='cabinet' href='/login'><CabinetIcon  size={48}></CabinetIcon></a>
    </header>
  );
};

export default Header;


