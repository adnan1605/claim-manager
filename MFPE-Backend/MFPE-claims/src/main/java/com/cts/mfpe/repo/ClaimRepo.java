package com.cts.mfpe.repo;

import com.cts.mfpe.model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepo extends JpaRepository<Claim, Integer> {

}
