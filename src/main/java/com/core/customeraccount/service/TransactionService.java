package com.core.customeraccount.service;

import com.core.customeraccount.dto.TransactionDTO;
import com.core.customeraccount.model.Account;

import java.math.BigDecimal;

/**
 * Transactions services
 *
 */
public interface TransactionService {

    /**
     * Service to send a transaction
     *
     * @param account     The customer account
     * @param amount      The transaction amount
     * @param description The transaction description
     * @return The transaction sent
     */
    TransactionDTO sendTransaction(Account account, BigDecimal amount, String description);

}
