import logo from './logo.svg';
import './App.css';
import ClaimStatus from './Component/ClaimStatus'
import SubmitClaim from './Component/SubmitClaim'
import ViewBill from './Component/ViewBill'
import Login from './Login';
import LastPage from './Component/LastPage';

import Claim from './Component/Claim';
import Bill from './Component/Bill';

import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import NavBar from './Component/NavBar'
import Footer from './Component/Footer'
import Home from './Component/Home';
function App() {
  return (
    <>
    
      <Router>
        
        
        <NavBar />
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/claimstatus" element={<ClaimStatus />} />
          <Route path="/submitclaim" element={<SubmitClaim/>} />
          <Route path="/viewbill" element={<ViewBill/>} />
          <Route path="/bill/:memberid/:policyid" element={<Bill/>}/>
          <Route path="/claim/:memberid/:policyid/:claimid" element={<Claim/>}/>
          <Route path="/submitted" element={<LastPage />} />

        </Routes>
        <Footer />
      </Router>
   

  </>
  );
}

export default App;
