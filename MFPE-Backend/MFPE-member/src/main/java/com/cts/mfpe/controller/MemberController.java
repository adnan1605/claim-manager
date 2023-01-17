package com.cts.mfpe.controller;

import com.cts.mfpe.feign.AuthClient;
import com.cts.mfpe.feign.ClaimClient;
import com.cts.mfpe.model.Claim;
import com.cts.mfpe.model.MemberPolicy;
import com.cts.mfpe.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3001")
public class MemberController {

    @Autowired
    MemberServiceImpl service;

    @Autowired
    AuthClient client;

    @Autowired
    ClaimClient claimClient;


    //viewbill
    //@RequestHeader(value = "Authorization", required = true) String requestTokenHeader

    @GetMapping("/viewbills/{memberId}/{policyId}")
    public List<MemberPolicy> viewBills(@PathVariable int policyId, @PathVariable int memberId
    ) throws Exception {
        /*
         * if (client.authorizeTheRequest(requestTokenHeader)) { return
         * service.viewBills(policyId, memberId); } else { throw new
         * Exception("no bills"); }
         */
        return service.viewBills(policyId, memberId);
    }

    @GetMapping("/getclaimstatus/{memberId}/{policyId}/{claimId}")
    public Claim getClaimStatus(@PathVariable int policyId, @PathVariable int memberId, @PathVariable int claimId,
                                @RequestHeader(value = "Authorization", required = true) String requestTokenHeader) {
        return claimClient.getClaimStatus(policyId, memberId, claimId, requestTokenHeader);
    }

    @PostMapping("/submitclaim/{memberId}/{policyId}")
    public Boolean submitClaim(@PathVariable int policyId, @PathVariable int memberId, @RequestBody int amount) {

        System.out.print("ohooo");
        Claim claim = new Claim();
        claim.setAmountClaimed(amount);
        claim.setMemberId(memberId);
        claimClient.submitClaim(policyId, memberId, claim);
        return true;
    }
}
