package com.nitesh.personalexpensewallet.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nitesh.personalexpensewallet.entity.Wallet;
import java.util.List;
@Repository
public interface WalletRepository extends JpaRepository<Wallet,Long> {
    List<Wallet> findAllByOrderByPriority();
}
