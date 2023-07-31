// src/App.jsx
import React from 'react';
import ProductList from './components/ProductList';

const App = () => {
  return (
    <div>
      <header>
        <h1>Catalog API Frontend</h1>
      </header>
      <main>
        <ProductList />
      </main>
    </div>
  );
};

export default App;
