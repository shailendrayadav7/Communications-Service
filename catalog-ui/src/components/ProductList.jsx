// src/components/ProductList.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import EditProductForm from './editProductForm';

const apiBaseUrl = 'http://localhost:8085/api/catalog'; // Backend API URL

const ProductList = () => {
  const [products, setProducts] = useState([]);
  const [selectedProduct, setSelectedProduct] = useState(null);

  useEffect(() => {
    // Fetch the list of products from the Catalog API
    console.log('apiBaseUrl:', apiBaseUrl);
    axios.get(apiBaseUrl)
    .then(response => {
      console.log('Response status:', response.status);
      console.log('response data:', response.data); // Log the data to check if it's received correctly
      setProducts(response.data);
    })
    .catch(error => console.error('Error fetching products:', error));
}, []);

  const handleEdit = (product) => {
    setSelectedProduct(product);
  };

  const handleUpdate = (updatedProduct) => {
    // Send the updated product data to the backend API
    axios.put(`/api/catalog/${updatedProduct.id}`, updatedProduct)
      .then(() => {
        // Refresh the product list after successful update
        axios.get('/api/catalog')
          .then(response => setProducts(response.data))
          .catch(error => console.error('Error fetching products:', error));
      })
      .catch(error => console.error('Error updating product:', error));

    setSelectedProduct(null);
  };

  return (
    <div>
      <h1>Product List</h1>
      <ul>
        {products.map(product => (
          <li key={product.id}>
            <strong>{product.name}</strong> - ${product.price}
            <button onClick={() => handleEdit(product)}>Edit</button>
            <button onClick={() => setSelectedProduct(product)}>View Details</button>
            {selectedProduct && selectedProduct.id === product.id && (
              <div>
                <p>Product ID: {selectedProduct.id}</p>
                <p>Product Name: {selectedProduct.name}</p>
                <p>Product Price: ${selectedProduct.price}</p>
              </div>
            )}
          </li>
        ))}
      </ul>
      {selectedProduct && (
        <EditProductForm product={selectedProduct} onUpdate={handleUpdate} />
      )}
    </div>
  );
};

export default ProductList;
