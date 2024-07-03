package com.core.customeraccount.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * The account DTO
 */
@Data
@Builder
public class AccountDTO {

    @JsonIgnore
    private Long id;

    @JsonProperty("account_number")
    private String accountNumber;

    private BigDecimal balance;

    private List<TransactionDTO> transactions;
}
