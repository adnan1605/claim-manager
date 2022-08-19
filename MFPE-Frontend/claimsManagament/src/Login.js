import {useRef,useState, useEffect} from 'react';
import { useNavigate } from 'react-router-dom';
import Connection from './service/Connection';
import { Button } from 'reactstrap';
import pic from "./assets/img/undraw_product_iteration_kjok.svg";

//import Connection from './service/Connection';




const Login = () => {
    const navigate=useNavigate();
    const userRef = useRef();
    const errRef = useRef();
    const[user, setUser] = useState('');
    const[pwd,setPwd] = useState('');
    const[errMsg, setErrMsg] = useState('');
    const[success, setSuccess] = useState(false);

    useEffect(()=>{
        userRef.current.focus();
    },[])

    useEffect(()=>{
        setErrMsg('');
    },[user,pwd])

    const handleSubmit = async(e) => {
         e.preventDefault();
        console.log(user,pwd);
         setUser('');
        setPwd('');
       setSuccess(true);
        e.preventDefault()
        var uname = document.getElementById("username").value
        var pass = document.getElementById("password").value
        var request = {
          userName: uname,
          password: pass
        }
         var token = await Connection.getToken(request)
       var response = await Connection.userValidate(token.data);
         console.log("Request", request);
        console.log("token ", token.data);
         console.log("Response ", response.data);
         if (response.data.valid === true) {
           navigate("/Types")
         }
         else {
           console.log();
           alert("Please check the credentials")
         }
    }
    return(
        <>{success ? (
            <section>
                <div className='d-flex justify-content-center bg-light'>
                <h2 className='text-primary display-7'>You are logged in </h2>
                </div>
                <br/>
                <p> <a href="#">go to home page</a></p>
                
                <Button color="primary ml-5"
                 outline onClick={
                    (e)=>{
                        e.preventDefault();
                 navigate('/submitclaim');
                 } 
                }
                >SUBMITCLAIM</Button>
               <Button color="secondary ml-4"
                 outline   onClick={
                    (e)=>{
                        e.preventDefault();
                 navigate('/viewbill');
                 } 
                }
                >VIEWBILLS</Button>

               <Button color="info ml-4"
                 outline   onClick={
                    (e)=>{
                        e.preventDefault();
                 navigate('/claimstatus');
                 } 
                }
                >CLAIMSTATUS</Button>
                <div className="col-xs-3 offset-md-6">
              <img
                src={pic}
                class="header__img"
                alt="svg image"
              />
            </div>
                
        
               
            </section>
        ):(

        
        <div className='container1 ' >
           <p ref={errRef} className={errMsg ? "errmsg" : "offscreen"} aria-live="assertive">{errMsg}</p>
            <h1>Sign In</h1>
              <form onSubmit={handleSubmit}>
                <label htmlFor="username">Username:</label>
                <input type="text" id="username"  ref={userRef} autoComplete="off" onChange={(e)=> setUser(e.target.value)} value={user} required/>


                <label htmlFor="password">Password:</label>
                <input type="password" id="password" onChange={(e)=> setPwd(e.target.value)} value={pwd} required/>

                <Button color="primary"
                 outline  >
                    Sign In
                </Button>


              </form>

        </div>
        )} </>
    )
}

export default Login;