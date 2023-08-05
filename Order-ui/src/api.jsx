// api.js
const apiBaseUrl = 'http://localhost:8085/api'; // Change this to your actual backend API URL

export const getCustomers = async () => {
  const response = await fetch(`${apiBaseUrl}/consumer/customers`);
  const data = await response.json();
  return data;
};

export const createCustomer = async (customerData) => {
  const response = await fetch(`${apiBaseUrl}/consumer/customers`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(customerData),
  });
  const data = await response.json();
  return data;
};

export const getOrders = async (customerId) => { // Add the getOrders function
  const response = await fetch(`${apiBaseUrl}/consumer/customers/${customerId}/orders`);
  const data = await response.json();
  return data;
};
