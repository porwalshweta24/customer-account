package com.core.customeraccount.repository;

import com.core.customeraccount.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The account repository used to interact with the related DB table
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
