package com.cts.mfpe.repo;

import com.cts.mfpe.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepo extends JpaRepository<Member, Integer> {

}
