import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';
import UserList from './UserList';
import CarList from './CarList';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <UserList /> { }
    <CarList /> { }
  </React.StrictMode>
);

reportWebVitals();
