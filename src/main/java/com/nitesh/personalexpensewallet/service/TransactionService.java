package com.nitesh.personalexpensewallet.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nitesh.personalexpensewallet.entity.Transaction;
import com.nitesh.personalexpensewallet.entity.Wallet;
import com.nitesh.personalexpensewallet.repository.WalletRepository;
import com.nitesh.personalexpensewallet.repository.TransactionRepository;
import com.nitesh.personalexpensewallet.exception.WalletException;
import java.util.List;
import java.util.Optional;
@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private WalletRepository walletRepository;
    public List<Transaction> getAll(Long walletId){
        Optional<Wallet> wallet = walletRepository.findById(walletId);
        if(wallet.isPresent()){
            return transactionRepository.findByWallet(wallet.get());
        }
        return null;
    }
    public Transaction getById(Long wallet_id,Long id){
        Optional<Wallet> wallet = walletRepository.findById(wallet_id);
        if(wallet.isPresent()) {
            Optional<Transaction> transaction = transactionRepository.findById(id);
            if (transaction.isPresent()) {
                return transaction.get();
            }
        }
        throw new WalletException("Transaction with "+id+" does not exists!");
    }
    public Transaction createOrUpdate(Long walletId, Transaction transaction){
        Optional<Wallet> wallet = walletRepository.findById(walletId);
        if(wallet.isPresent()){
            transaction.setWallet(wallet.get());
            transactionRepository.save(transaction);
            return transaction;
        }
        return null;
    }
    public boolean delete(Long wallet_id,Long id){
        Optional<Wallet> wallet = walletRepository.findById(wallet_id);
        if(wallet.isPresent()) {
            Optional<Transaction> transaction = transactionRepository.findById(id);
            if (transaction.isPresent()) {
                transactionRepository.delete(transaction.get());
                return true;
            }
        }
        throw new WalletException("Transaction with "+id+" does not exists!");
    }

}
