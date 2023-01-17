package com.cts.mfpe.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class MemberPolicy {

    @Id
    private int memberId;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate subsDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate premiumDueDate;
    private int capAmount;
    private int policyId;
}
