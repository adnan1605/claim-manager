import { useRef, useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

//import Connection from './service/Connection'
import Connection from '../service/Connection';
import { Button } from 'reactstrap';




const ViewBill = () => {
    const userRef = useRef();
    const errRef = useRef();
    const navigate=useNavigate();
    const [memberid, setMemberId] = useState(0);
    const [policyid, setPolicyId] = useState(0);
    

   
   
    const handleSubmit = async (e) => {
        // e.preventDefault();

        e.preventDefault()

    }
    return (



        <div className='container1'  style={{
            backgroundColor: 'cyan',
             
          }}>
         
            <h2>View Bills</h2>
            <form onSubmit={handleSubmit}>
                <label htmlFor="memberid">Member Id:</label>
                <input type="text" id="memberid"  onChange={(e) => setMemberId(e.target.value)} value={memberid} placeholder='Enter the member id' required />
                <label htmlFor="Policyid">Policy Id:</label>
                <input type="text" id="policyid"  onChange={(e) => setPolicyId(e.target.value)} value={policyid} placeholder='Enter the policy id' required />

                <Button  color="dark"
                 outline onClick={
                    (e)=>{
                        e.preventDefault();
                   Connection.getBills(memberid,policyid)
                  .then ((response)=>{
                    navigate (`/bill/${memberid}/${policyid}`);
                   }).catch((error)=>{console.log(error);});
                 // navigate("/claimstatus");

                 } 
                }
                >view</Button>


            </form>

        </div>
    )
}
export default ViewBill