import React, { useEffect, useState } from 'react';
import axios from 'axios';

const CustomerOrders = ({ customerId }) => {
  const [orders, setOrders] = useState([]);

  useEffect(() => {
    axios.get(`http://localhost:8080/api/consumer/customers/${customerId}/orders`)
      .then(response => {
        setOrders(response.data);
      })
      .catch(error => {
        console.error('Error fetching orders:', error);
      });
  }, [customerId]);

  return (
    <div>
      <h2>Customer Orders</h2>
      <ul>
        {orders.map(order => (
          <li key={order.id}>
            <p>Order ID: {order.id}</p>
            <p>Status: {order.status}</p>
            <p>Created Date: {order.createdDate}</p>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default CustomerOrders;
