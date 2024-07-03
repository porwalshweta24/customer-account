package com.core.customeraccount.repository;

import com.core.customeraccount.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The transaction repository used to interact with the related DB table
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
