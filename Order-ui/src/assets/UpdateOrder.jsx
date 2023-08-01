import React, { useState } from 'react';
import axios from 'axios';

const UpdateOrder = ({ customerId, orderId }) => {
  const [status, setStatus] = useState('');

  const handleUpdateOrder = () => {
    const updatedOrder = {
      status: status,
    };

    axios.put(`http://localhost:8080/api/consumer/customers/{customerId}/orders/{orderId}`, updatedOrder)
      .then(response => {
        console.log('Order updated:', response.data);
        // Optionally, update the state or display a success message
      })
      .catch(error => {
        console.error('Error updating order:', error);
      });
  };

  return (
    <div>
      <h2>Update Order</h2>
      <div>
        <label>Status:</label>
        <input type="text" value={status} onChange={e => setStatus(e.target.value)} />
      </div>
      <button onClick={handleUpdateOrder}>Update Order</button>
    </div>
  );
};

export default UpdateOrder;
