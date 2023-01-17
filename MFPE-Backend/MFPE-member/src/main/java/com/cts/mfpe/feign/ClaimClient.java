package com.cts.mfpe.feign;

import com.cts.mfpe.model.Claim;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "Claim-Microservice", url = "http://localhost:8200")
public interface ClaimClient {

    @GetMapping("/getclaimstatus/{memberId}/{policyId}/{claimId}")
    public Claim getClaimStatus(@PathVariable int policyId, @PathVariable int memberId, @PathVariable int claimId,
                                @RequestHeader(value = "Authorization", required = true) String requestTokenHeader);

    @PostMapping("/submitclaim/{memberId}/{policyId}")
    public Claim submitClaim(@PathVariable int policyId, @PathVariable int memberId, @RequestBody Claim claim);

}
