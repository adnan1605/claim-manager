package com.cts.mfpe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "claim")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int claimId;
    private int memberId;
    private String status;
    private String description;
    private int amountClaimed;
    private int setteled;

}
