import { BrowserRouter as Router, Switch ,Route } from 'react-router-dom'
import Header from './Component/Header';
import Home from './Pages/Home';
import Checkout from './Pages/Checkout';
import Login from './Pages/Login';
import Register from './Pages/Register';
import Footer from './Component/Footer';
import Farmer from './Component/Farmer';
import AddCrops from './Component/AddCrops';
import CropList from './Component/CropList';
import UpdateCropList from './Component/UpdateCropList';
import Orders from './Pages/Orders';
import Profile from './Pages/Profile';


function App() {
  return (
    <Router>
        <div className="App">
          <Switch>
            {/* Login */}
            <Route path="/login">
              <Login />
              <Footer />
            </Route>
            {/* Register */}
            <Route path="/register">
              <Register />
              <Footer />
            </Route>
            {/* Checkout */}
            <Route path="/checkout">
              <Header />
              <Checkout />
            {/* Farmer */}
            </Route>
            <Route path="/farmer">
              <Farmer />
              <CropList />
            </Route>
            {/* Update Crop Data */}
            <Route exact path="/update-data/:cropID" >
              <UpdateCropList />
            </Route>
            {/* Profile */}
            <Route path="/profile">
              <Profile />
            </Route>
            {/* Orders */}
            <Route path="/orders">
              <Orders />
            </Route>
            {/* Addoing Crops */}
            <Route path="/add">
              <AddCrops />
              <Footer />
            </Route>
            {/* Home Page */}
            <Route path="/">
              <Header />
              <Home />
              <Footer />
            </Route>
          </Switch>
          
        </div>
        <div>
          {/* <Footer /> */}
        </div>
    </Router>
    
    
  );
}

export default App;
