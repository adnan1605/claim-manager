import { useRef, useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import Connection from '../service/Connection';


const Bill =()=>{
    const {memberid,policyid}=useParams();
    console.log(memberid);
    console.log(policyid);
    const navigate=useNavigate();
     //by my self
     const [loading,setLoading]=useState(true);
     const [bill,setBill]=useState([]);
     useEffect(()=>{
         const fetchData=async()=>{
             setLoading(true);
             try{
                 const response=await Connection.getBills(memberid,policyid);
                 console.log(response);
                 setBill(response.data);
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
                        <th>memberid</th>
                        <th>Name</th>
                        <th>subsDate</th>
                        <th>premiumDuedate</th>
                        <th> capAmount</th>
                        <th>policyid </th>
                    </tr>
                </thead>
                <tbody>
                {
                    bill.map((data, index)=>{
                        return(
                            <tr key={index}>
                                <td>{data.memberId}</td>
                                <td>{data.name}</td>
                                <td>{data.subsDate}</td>
                                <td> {data.premiumDueDate}</td>
                                <td>{data.capAmount}</td>
                                <td>{data.policyId}</td>
                            </tr>
                        )
                    })
                }
                </tbody>
            </table>
        );
    
    
            
     
}
 export default Bill;