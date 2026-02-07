package com.avo.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
@Schema(
        name = "Loans",
        description = "Schema to hold Loan information"
)
public class LoansDto {

    @Schema(
            description = "Mobile number of the Customer",
            example = "9876543210"
    )
    @NotEmpty(message = "Mobile number cannot be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Loan Number of the customer",
            example = "000000008362"
    )
    @NotEmpty(message = "Loan number cannot be null or empty")
    @Pattern(regexp = "(^$|[0-9]{12})", message = "Loan number must be 12 digits")
    private String loanNumber;

    @Schema(
            description = "Type of the loan",
            example = "Home Loan"
    )
    @NotEmpty(message = "Loan type cannot be null or empty")
    private String loanType;

    @Schema(
            description = "Total loan amount",
            example = "100000"
    )
    @Positive(message = "Total loan amount should be greater than zero")
    private int totalLoan;

    @Schema(
            description = "Total loan amount paid",
            example = "1000"
    )
    @PositiveOrZero(message = "Total loan amount paid should be equal or greater than zero")
    private int amountPaid;

    @Schema(
            description = "Total outstanding amount against a loan",
            example = "99000"
    )
    @PositiveOrZero(message = "Total outstanding amount should be equal or greater than zero")
    private int outstandingAmount;

}
