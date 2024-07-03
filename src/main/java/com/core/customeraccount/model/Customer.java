package com.core.customeraccount.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * The customer entity model representing the related DB table
 */
@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 20, message
            = "Customer name must be between 10 and 200 characters")
    private String name;

    @Size(min = 3, max = 20, message
            = "Customer surname must be between 10 and 200 characters")
    private String surname;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private List<Account> accounts;
}

