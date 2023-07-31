// src/components/EditProductForm.js
import React, { useState } from 'react';

const EditProductForm = ({ product, onUpdate }) => {
  const [name, setName] = useState(product.name);
  const [price, setPrice] = useState(product.price);

  const handleNameChange = (e) => {
    setName(e.target.value);
  };

  const handlePriceChange = (e) => {
    setPrice(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    onUpdate({ ...product, name, price });
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label>Name:</label>
        <input type="text" value={name} onChange={handleNameChange} />
      </div>
      <div>
        <label>Price:</label>
        <input type="number" value={price} onChange={handlePriceChange} />
      </div>
      <button type="submit">Update</button>
    </form>
  );
};

export default EditProductForm;
