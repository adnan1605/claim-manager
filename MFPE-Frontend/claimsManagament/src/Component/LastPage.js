import { useParams } from "react-router-dom";



const  LastPage=()=>{
    const {memberid}=useParams();
    console.log(memberid);


return(
                <div >
               <h2 className="text-primary text-center display-7">Your claim is submitted.Now,you can check your status. </h2>
               </div> 


)



}
export default LastPage