package com.neerajbisht.Module2.dto;

import com.neerajbisht.Module2.annotation.customPrimeNumberAnnotation;
import com.neerajbisht.Module2.annotation.passwordCheckerValidationAnnotation;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {

    @NotNull(message = "title should not be null.")
    @Size(min = 5, max = 50, message = "length of the title should be between 5 and 50.")
    private String title;

    @Email
    private String email;

    @NotNull(message = "isActive should not be null.")
    @AssertTrue(message = "isActive should be true.")
    private Boolean isActive;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @passwordCheckerValidationAnnotation
    @NotBlank
    private String password;


//    @Min(value= 5,message = "length of the title should be greater than 5.")
//    @Max(value= 10, message = "length of the title should be less than 10.")
//    private Integer employeeCount;

//    @NotNull(message = "Name required")
//    @NotBlank(message = "Name cannot be blank")
//    @Size(min = 3, max = 50, message = "Name length error")
//    private String name;
//
//    @NotEmpty(message = "Tags cannot be empty")
//    private List<String> tags;
//
//    @AssertFalse(message = "Must not be suspended")
//    private boolean isSuspended;
//
//    @Min(value = 10, message = "Min 10 employees")
//    private int minEmployees;
//
//    @Max(value = 1000, message = "Max 1000 employees")
//    private int maxEmployees;
//
//    @DecimalMin(value = "50000.00", message = "Min budget error")
//    private BigDecimal minBudget;
//
//    @DecimalMax(value = "999999.99", message = "Max budget error")
//    private BigDecimal maxBudget;
//
//    @Negative(message = "Must be negative")
//    private int turnoverLoss;
//
//    @NegativeOrZero(message = "Must be negative or zero")
//    private int adjustmentFactor;
//
//    @Positive(message = "Must be positive")
//    private int profitMargin;
//
//    @PositiveOrZero(message = "Must be positive or zero")
//    private int currentStock;
//
//    @Digits(integer = 5,fraction = 2, message = "Invalid digits format")
//    private BigDecimal stockValue;
//
//    @Past(message = "Must be in the past")
//    private LocalDate foundationDate;
//
//    @PastOrPresent(message = "Must be past or present")
//    private LocalDateTime lastAuditDate;
//
//    @Future(message = "Must be in the future")
//    private LocalDate nextReviewDate;
//
//    @FutureOrPresent(message = "Must be future or present")
//    private LocalDateTime projectedLaunchDate;
//
//    @Pattern(regexp = "^DEPT-[A-Z]{3}$", message = "Invalid format: DEPT-XXX")
//    private String departmentCode;
//
//    @Range(min = 1, max = 5, message = "Rating 1-5")
//    private int departmentRating;
//
//    @Length(min = 10, max = 200, message = "Length 10-200")
//    private String description;
//
//    @CreditCardNumber(message = "Invalid credit card")
//    private String paymentCardNumber;
//
//    @URL(message = "Invalid URL")
//    private String websiteUrl;
}
