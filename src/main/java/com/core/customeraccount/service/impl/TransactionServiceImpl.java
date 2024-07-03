package com.core.customeraccount.service.impl;

import com.core.customeraccount.dto.TransactionDTO;
import com.core.customeraccount.repository.TransactionRepository;
import com.core.customeraccount.util.ObjectSerializer;
import com.core.customeraccount.model.Account;
import com.core.customeraccount.model.Transaction;
import com.core.customeraccount.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    private final TransactionRepository transactionRepository;

    private final ObjectSerializer objectSerializer;


    /**
     * {@inheritDoc}
     */
    @Override
    public TransactionDTO sendTransaction(Account account, BigDecimal amount, String description) {

        LOGGER.debug("sendTransaction - account:{} | amount:{}", account, amount);

        Transaction transaction = new Transaction();
        transaction.setTransactionNumber(UUID.randomUUID().toString());
        transaction.setAmount(amount);
        transaction.setRecipient(account.getAccountNumber());
        transaction.setAccount(account);
        transaction.setDescription(description);

        transaction = transactionRepository.save(transaction);

        return objectSerializer.toTransactionDTO(transaction);
    }
}
