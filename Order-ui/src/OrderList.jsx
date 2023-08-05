import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { getOrders } from './api';

const OrderList = () => {
  const [orders, setOrders] = useState([]);
  const { customerId } = useParams();

  useEffect(() => {
    // Use the 'getOrders' API method to fetch orders for the specific customer
    getOrders(customerId)
      .then((response) => {
        setOrders(response);
      })
      .catch((error) => {
        console.error('Error fetching orders:', error);
      });
  }, [customerId]);

  return (
    <div>
      <h2>Order List for Customer ID: {customerId}</h2>
      <ul>
        {orders.map((order) => (
          <li key={order.id}>
            <p>Order ID: {order.id}</p>
            <p>Status: {order.status}</p>
            <p>Created Date: {order.createdDate}</p>
            {/* Add more order details here as needed */}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default OrderList;
