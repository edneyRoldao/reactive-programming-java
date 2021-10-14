package com.edn.reactiveprogramming.service;

import com.edn.reactiveprogramming.model.BankAccount;
import com.edn.reactiveprogramming.repository.BankAccountRepository;
import com.edn.reactiveprogramming.response.BankAccountResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@AllArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {

    private BankAccountRepository repository;

    @Override
    public Flux<BankAccount> getAllAccounts() {
        return repository.findAll()
                .doFirst(() -> log.info("init BankAccountServiceImpl.getAllAccounts"));
    }

    @Override
    public Mono<BankAccountResponse> getBankAccountById(String id, String a) {
        return repository.findById(id)
                .doFirst(() -> log.info("init BankAccountServiceImpl.getBankAccountById id:{}", id))
                .switchIfEmpty(Mono.error(IllegalArgumentException::new))
                .flatMap(this::converter)
                .doOnSuccess(r -> log.info("end BankAccountServiceImpl.getBankAccountById"))
                .doOnError(error -> log.error(error.getMessage()));
    }

    Mono<BankAccountResponse> converter(BankAccount bankAccount) {
        return Mono.just(BankAccountResponse
                .builder()
                .balance(bankAccount.getBalance())
                .username(bankAccount.getUsername())
                .accountNumber(bankAccount.getAccountNumber())
                .build());
    }

}
