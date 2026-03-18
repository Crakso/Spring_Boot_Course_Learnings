package com.neerajbisht.Module2.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String email;

    private Boolean isActive;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private String password;

//    private String name;
//
//    private List<String> tags;
//
//    private boolean isSuspended;
//
//    private int minEmployees;
//
//    private int maxEmployees;
//
//    private BigDecimal minBudget;
//
//    private BigDecimal maxBudget;
//
//    private int turnoverLoss;
//
//    private int adjustmentFactor;
//
//    private int profitMargin;
//
//    private int currentStock;
//
//    private BigDecimal stockValue;
//
//    private LocalDate foundationDate;
//
//    private LocalDateTime lastAuditDate;
//
//    private LocalDate nextReviewDate;
//
//    private LocalDateTime projectedLaunchDate;
//
//    private String departmentCode;
//
//    private int departmentRating;
//
//    private String description;
//
//    private String paymentCardNumber;
//
//    private String websiteUrl;

}
