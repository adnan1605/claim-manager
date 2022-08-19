import axios from "axios";
const Authorization_authenticate="http://localhost:8400/authenticate"
const Authorization_authorize="http://localhost:8400/authorize"
const get="http://localhost:8100/viewbills"
const getclaim="http://localhost:8200/getclaimstatus"
const postsubmit="http://localhost:8200/submitclaim"
class Connection{
    async getToken(creds) {
        try {
            var token = await axios.post(Authorization_authenticate, creds)
                .then(response => {
                    if (response.data != null) {
                        console.log(response);
                        return response;
                    }
                    else {
                        alert("Bad Credentials")
                    }
                });
        } catch (error) {
            token = ""
        } finally {
            return token;
        }
    }
    async userValidate(token) {
        console.log("TOKEN IN POST ", token);
        var validate = await axios.post(Authorization_authorize, token, {
            headers: {
                'Authorization': `Bearer ${token}`
            },
        })
            .then(response => {
                return response
            })
        return validate;
    }
    getBills(memberid,policyid){
        return axios.get(get+"/"+memberid+"/"+policyid);
    }
    getClaim(memberid,policyid,claimid){
        return axios.get(getclaim+"/"+memberid+"/"+policyid+"/"+claimid);
    }
    postSubmit(memberid,policyid,amount){
        return axios.post()
    }
    saveClaim(memberid,policyid,claim){
        console.log(claim);
        return axios.post(postsubmit+"/"+memberid+"/"+policyid,claim);
    }
}
export default new Connection();