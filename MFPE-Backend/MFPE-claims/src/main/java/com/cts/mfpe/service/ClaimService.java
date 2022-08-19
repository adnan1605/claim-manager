package com.cts.mfpe.service;

import com.cts.mfpe.model.Claim;

public interface ClaimService {

	Claim getClaimStatus(int claimId, int policyId, int memberId);

	Claim submitClaim(int policyId, int memberId, Claim claim);

}
