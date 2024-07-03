package com.core.customeraccount.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * The customer DTO
 */
@Data
@Builder
public class CustomerDTO {

    @JsonIgnore
    private Long id;

    private String name;

    private String surname;

    private List<AccountDTO> accounts;
}