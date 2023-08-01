import React, { useState } from 'react';
import axios from 'axios';

const CreateOrder = ({ customerId }) => {
  const [status, setStatus] = useState('');

  const handleCreateOrder = () => {
    const newOrder = {
      status: status,
    };

    axios.post(`http://localhost:8080/api/consumer/customers/{customerId}/orders/create`, newOrder)
      .then(response => {
        console.log('Order created:', response.data);
        // Optionally, update the state or display a success message
      })
      .catch(error => {
        console.error('Error creating order:', error);
      });
  };

  return (
    <div>
      <h2>Create Order</h2>
      <div>
        <label>Status:</label>
        <input type="text" value={status} onChange={e => setStatus(e.target.value)} />
      </div>
      <button onClick={handleCreateOrder}>Create Order</button>
    </div>
  );
};

export default CreateOrder;
