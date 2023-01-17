package com.cts.mfpe.service;

import com.cts.mfpe.model.MemberPolicy;

import java.util.List;

public interface MemberService {

    List<MemberPolicy> viewBills(int policyId, int memberId);
}
