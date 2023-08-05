// App.jsx
import React from 'react';
import { Routes, Route, Link } from 'react-router-dom';
import CustomerList from './CustomerList';
import OrderList from './OrderList';
import CustomerForm from './CustomerForm'; // Assuming you have a form to create a new customer

const App = () => {
  return (
    <div>
      <nav>
        <ul>
          <li>
            <Link to="/">Customers</Link>
          </li>
        </ul>
      </nav>
      <Routes>
        <Route path="/" element={<CustomerList />} />
        <Route path="/customers/:customerId/orders" element={<OrderList />} />
        <Route path="/create-customer" element={<CustomerForm />} />
      </Routes>
    </div>
  );
};

export default App;
