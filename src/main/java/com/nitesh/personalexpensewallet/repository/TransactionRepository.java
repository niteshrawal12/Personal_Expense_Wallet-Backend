package com.nitesh.personalexpensewallet.repository;

import com.nitesh.personalexpensewallet.entity.Transaction;
import com.nitesh.personalexpensewallet.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    List<Transaction> findByWallet(Wallet wallet);
}


