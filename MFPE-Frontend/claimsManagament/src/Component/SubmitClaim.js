import { useRef, useState, useEffect } from 'react';
import React from 'react';
import Connection from '../service/Connection';
import { useNavigate } from 'react-router-dom';
import LastPage from './LastPage';
import { Button } from 'reactstrap';

//import Connection from './service/Connection'




const Login = () => {
    const userRef = useRef();
    const errRef = useRef();
    const [claim,setClaim]=useState({
        memberid:"",
        policyid:"",
       amountClaimed:"",
        Description:""



     } );
     const handChange =(e)=>{
        const value=e.target.value;
        setClaim({...claim,[e.target.name]:value});
     };
   // const [memberid, setMemberId] = useState('');
    //const [policyid, setPolicyId] = useState('');
    //const [ClaimedAmount, setClaimedAmount] = useState('');
  //  const [Description, setDescription] = useState('');

  const saveclaim=(e)=>{
    e.preventDefault();
    Connection.saveClaim(claim.memberid,claim.policyid,claim).then((response)=>{console.log(response)
    console.log(claim.memberid)
        navigate('/submitted')
    })
    .catch((error)=>{console.log(error)});
  };
  const navigate=useNavigate();

   
    const handleSubmit = async (e) => {
        // e.preventDefault();

        e.preventDefault()

    }
    return (
        <div className="container3" style={{
            backgroundColor: 'cyan',}}>
            
                
               <h2>Submit Claim</h2>
               

                

            
            
                <label htmlFor='memberid'>
                    Member Id:
                </label >
                <input type="text"
                name="memberid"
                value={claim.memberid}
                onChange={(e)=>handChange(e)}
                
                ></input>
            
            
                <label htmlFor="policyid">
                   Policy Id:
                </label >
                <input type="text"
                    name="policyid"
                    value={claim.policyid}
                    onChange={(e)=>handChange(e)}
    
                
                ></input>
            
            
                <label htmlFor='amountClaimed'>
                    amountClaimed
                </label >
                <input type="text"
                  name="amountClaimed"
                  value={claim.amountClaimed}
                  onChange={(e)=>handChange(e)}
                ></input>
            
            
                <label htmlFor='Description'>
                    Description
                </label >
                <input type="text"
                  name="Description"
                  value={claim.Description}
                  onChange={(e)=>handChange(e)}
                ></input>
            
            
                <Button className='button' color='dark' outline  onClick={saveclaim}> 
                  Save
                 </Button>
    
                    
                
        
            
        </div>
      )




   // return (



       // <div className='container2'>
         
         //   <h2>Submit Claim</h2>
          //  <form onSubmit={handleSubmit}>
           //     <label htmlFor="Memberid">Member Id:</label>
           //     <input type="text" id="memberid"  onChange={(e) => setMemberId(e.target.value)} value={memberid} placeholder='Enter the member id' required />
            //    <label htmlFor="Policyid">Policy Id:</label>
           //     <input type="text" id="policyid"  onChange={(e) => setPolicyId(e.target.value)} value={policyid} placeholder='Enter the policy id' required />


            //    <label htmlFor="ClaimedAmount">ClaimedAmount:</label>
             //   <input type="text" id="ClaimedAmount" onChange={(e) => setAmount(e.target.value)} value={ClaimedAmount} placeholder='Enter the ClaimedAmount' required />
            //    <label htmlFor="Description">Description:</label>
            //    <input type="text" id="Description" onChange={(e) => setAmount(e.target.value)} value={Description} placeholder='Enter the Description' required />

              //  <button onClick={saveclaim}
                
                
              //  > SUBMIT </button>


           // </form>

      //  </div>
   // )
}
export default Login;