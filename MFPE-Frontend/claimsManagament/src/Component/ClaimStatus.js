import { useRef, useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import Connection from '../service/Connection';
import { Button } from 'reactstrap';

//import Connection from './service/Connection'




const Login = () => {
    const userRef = useRef();
    const errRef = useRef();
    const navigate=useNavigate();
    const [memberid, setMemberId] = useState(0);
    const [policyid, setPolicyId] = useState(0);
    const [claimid, setClaimId] = useState(0);
   
    const handleSubmit = async (e) => {
        // e.preventDefault();

        e.preventDefault()

    }
    return (



        <div className='container2 ' style={{
            backgroundColor: 'cyan',
             
          }} >
         
            <h2>Claim Status</h2>
            <form onSubmit={handleSubmit}>
                <label htmlFor="Memberid">Member Id:</label>
                <input type="text" id="memberid"  onChange={(e) => setMemberId(e.target.value)} value={memberid} placeholder='Enter the member id' required />
                <label htmlFor="Policyid">Policy Id:</label>
                <input type="text" id="policyid"  onChange={(e) => setPolicyId(e.target.value)} value={policyid} placeholder='Enter the policy id' required />


                <label htmlFor="Claimid">Claim Id:</label>
                <input type="text" id="claimid" onChange={(e) => setClaimId(e.target.value)} value={claimid} placeholder='Enter the claim id' required />

                <Button  color='dark' outline 
                onClick={
                    (e)=>{
                        e.preventDefault();
                   Connection.getClaim(memberid,policyid,claimid)
                  .then ((response)=>{
                    navigate (`/claim/${memberid}/${policyid}/${claimid}`);
                   }).catch((error)=>{console.log(error);});
                 // navigate("/claimstatus");

                 } 
                }
                > Status </Button>


            </form>

        </div>
    )
}
export default Login;