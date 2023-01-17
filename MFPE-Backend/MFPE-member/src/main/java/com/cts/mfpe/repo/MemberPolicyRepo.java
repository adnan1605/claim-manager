package com.cts.mfpe.repo;

import com.cts.mfpe.model.MemberPolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberPolicyRepo extends JpaRepository<MemberPolicy, Integer> {

}
