package com.core.customeraccount.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * The transaction entity model representing the related DB table
 */
@Data
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transaction_number")
    @NotEmpty
    private String transactionNumber;

    @PositiveOrZero
    private BigDecimal amount;

    @NotEmpty
    private String recipient;

    @Size(max = 200, message
            = "Description name must max 200 characters")
    private String description;

    @CreationTimestamp
    @Column(name = "sending_date")
    private Instant sendingDate;

    @ManyToOne(fetch= FetchType.LAZY)
    @NotNull
    @JoinColumn(name = "account_id")
    private Account account;
}
