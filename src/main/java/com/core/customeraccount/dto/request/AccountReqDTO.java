package com.core.customeraccount.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

/**
 * The account request DTO containing the user information
 */
@Getter
@Setter
@Builder
public class AccountReqDTO {

    @JsonProperty("customer_id")
    @NotNull
    private Long customerId;

    @JsonProperty("initial_credit")
    @NotNull
    @PositiveOrZero
    private BigDecimal initialCredit;
}
