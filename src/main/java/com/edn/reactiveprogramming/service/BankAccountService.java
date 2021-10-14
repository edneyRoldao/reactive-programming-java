package com.edn.reactiveprogramming.service;

import com.edn.reactiveprogramming.model.BankAccount;
import com.edn.reactiveprogramming.response.BankAccountResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BankAccountService {

    Flux<BankAccount> getAllAccounts();
    Mono<BankAccountResponse> getBankAccountById(String id, String a);

}
