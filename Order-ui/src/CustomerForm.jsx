// CustomerForm.jsx
import React, { useState } from 'react';
import { createCustomer } from './api';

const CustomerForm = () => {
  const [formData, setFormData] = useState({
    customerFname: '',
    customerLname: '',
    customerEmail: '',
    customerAddress: '',
    customerPhone: '',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevFormData) => ({
      ...prevFormData,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      // Call the API method to create a new customer
      await createCustomer(formData);
      console.log('New customer created:', formData);
      // Optionally, you can redirect to the customer list page after successful creation
      // window.location.href = '/';
    } catch (error) {
      console.error('Error creating customer:', error);
    }
  };

  return (
    <div>
      <h2>Create New Customer</h2>
      <form onSubmit={handleSubmit}>
        <label>
          First Name:
          <input type="text" name="customerFname" value={formData.customerFname} onChange={handleChange} />
        </label>
        <br />
        <label>
          Last Name:
          <input type="text" name="customerLname" value={formData.customerLname} onChange={handleChange} />
        </label>
        <br />
        <label>
          Email:
          <input type="text" name="customerEmail" value={formData.customerEmail} onChange={handleChange} />
        </label>
        <br />
        <label>
          Address:
          <input type="text" name="customerAddress" value={formData.customerAddress} onChange={handleChange} />
        </label>
        <br />
        <label>
          Phone:
          <input type="text" name="customerPhone" value={formData.customerPhone} onChange={handleChange} />
        </label>
        <br />
        <button type="submit">Create Customer</button>
      </form>
    </div>
  );
};

export default CustomerForm;
