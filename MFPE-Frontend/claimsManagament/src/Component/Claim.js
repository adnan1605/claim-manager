
import Connection from "../service/Connection";
import { useRef, useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

const Claim =()=>{
    const {memberid,policyid,claimid}=useParams();
    console.log(memberid);
    console.log(policyid);
    const navigate=useNavigate();
     //by my self
     const [loading,setLoading]=useState(true);
     const [claim,setClaim]=useState(undefined);
     useEffect(()=>{
         const fetchData=async()=>{
             setLoading(true);
             try{
                 const response=await Connection.getClaim(memberid,policyid,claimid);
                 console.log(response);
                 setClaim(response.data);
             }
             catch(error){
             console.log(error);
             }
             setLoading(false);
         };
         fetchData();
     },[]);

     

    
        return(
            <table className="table">
                <thead>
                    <tr>
                        <th>claimId</th>
                        <th>memberId</th>
                        <th>status</th>
                        <th>description</th>
                        <th> amountClaimed</th>
                        <th>setteled </th>
                    </tr>
                </thead>
                <tbody>
                {
                   claim &&
                      
                            <tr >
                                <td>{claim.claimId}</td>
                                <td>{claim.memberId}</td>
                                <td>{claim.status}</td>
                                <td> {claim.description}</td>
                                <td>{claim.amountClaimed}</td>
                                <td>{claim.setteled}</td>
                            </tr>
                        
                    
                }
                </tbody>
            </table>
        );
    
    
            
     
}
export default Claim