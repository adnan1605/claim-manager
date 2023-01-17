package com.cts.mfpe.controller;

import com.cts.mfpe.model.Claim;
import com.cts.mfpe.service.ClaimServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class ClaimController {

    @Autowired
    ClaimServiceImpl service;


    @GetMapping("/getclaimstatus/{memberId}/{policyId}/{claimId}")
    public Claim getClaimStatus(@PathVariable int policyId, @PathVariable int memberId, @PathVariable int claimId
    ) throws Exception {
        return service.getClaimStatus(claimId, policyId, memberId);
    }

    @PostMapping("/submitclaim/{memberId}/{policyId}")
    public Claim submitClaim(@PathVariable int policyId, @PathVariable int memberId, @RequestBody Claim claim) throws Exception {
        return service.submitClaim(policyId, memberId, claim);
    }

    /*
     * @PostMapping("/submitclaim/") public Claim submitClaim(@RequestBody Claim
     * claim) throws Exception{ int memberId=claim.getMemberId(); int policyId= int
     * memberid =claim.getMemberId(); int policyid= return
     * service.submitClaim(policyId, memberId, claim); }
     *
     *
     * }
     */
}
