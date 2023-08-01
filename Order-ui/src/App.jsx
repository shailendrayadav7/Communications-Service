import React from 'react';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';
import CustomerOrders from './CustomerOrders';
import CreateOrder from './assets/CreateOrder';
import UpdateOrder from './assets/UpdateOrder';

const App = () => {
  return (
    <Router>
      <div>
        <nav>
          <ul>
            <li><Link to="/customer/1">Customer 1 Orders</Link></li>
            {/* Add other customer links as needed */}
          </ul>
        </nav>
        <Switch>
          <Route path="/customer/:customerId" exact>
            {({ match }) => {
              const { customerId } = match.params;
              return <CustomerOrders customerId={customerId} />;
            }}
          </Route>
          <Route path="/customer/:customerId/create-order" exact>
            {({ match }) => {
              const { customerId } = match.params;
              return <CreateOrder customerId={customerId} />;
            }}
          </Route>
          <Route path="/customer/:customerId/update-order/:orderId" exact>
            {({ match }) => {
              const { customerId, orderId } = match.params;
              return <UpdateOrder customerId={customerId} orderId={orderId} />;
            }}
          </Route>
        </Switch>
      </div>
    </Router>
  );
};

export default App;
