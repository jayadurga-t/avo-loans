package com.avo.loans.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
public class AccountsDto {

    @Schema(
            description = "Account number of the Customer",
            example = "0000124321"
    )
    @NotNull(message = "Account number cannot be null or empty")
    @Digits(integer = 10, fraction = 0, message = "Account number must be 10 digits")
    private Long accountNumber;

    @Schema(
            description = "Account type of the Avo bank account",
            example = "Savings"
    )
    @NotEmpty(message = "Account type cannot be null or empty")
    private String accountType;

    @Schema(
            description = "Avo bank address",
            example = "123 New York"
    )
    @NotEmpty(message = "Branch address cannot be null or empty")
    private String branchAddress;

}
