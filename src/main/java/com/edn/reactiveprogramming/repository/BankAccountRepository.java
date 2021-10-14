package com.edn.reactiveprogramming.repository;

import com.edn.reactiveprogramming.model.BankAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends ReactiveMongoRepository<BankAccount, String> {
}
