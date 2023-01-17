package com.cts.mfpe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Claim {

    @Id
    private int claimId;
    private int memberId;
    private String status;
    private String description;
    private int amountClaimed;
    private int setteled;

}
