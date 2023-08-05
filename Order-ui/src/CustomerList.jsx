// CustomerList.jsx
import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { getCustomers } from './api';

const CustomerList = () => {
  const [customers, setCustomers] = useState([]);

  useEffect(() => {
    fetchCustomers();
  }, []);

  const fetchCustomers = async () => {
    try {
      const data = await getCustomers();
      setCustomers(data);
    } catch (error) {
      console.error('Error fetching customers:', error);
    }
  };

  return (
    <div>
      <h2>Customer List</h2>
      <ul>
        {customers.map((customer) => (
          <li key={customer.customerID}>
            <Link to={`/customers/${customer.customerID}/orders`}>
              {customer.customerFname} {customer.customerLname}
            </Link>
          </li>
        ))}
      </ul>
      <Link to="/create-customer">Create New Customer</Link>
    </div>
  );
};

export default CustomerList;
