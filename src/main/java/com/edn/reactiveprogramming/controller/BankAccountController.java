package com.edn.reactiveprogramming.controller;

import com.edn.reactiveprogramming.model.BankAccount;
import com.edn.reactiveprogramming.repository.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("api/bank-account")
public class BankAccountController {

    private final BankAccountRepository repository;


    @GetMapping("/{id}")
    public ResponseEntity<Mono<BankAccount>> getBankAccount(@PathVariable String id) {
        return ResponseEntity.ok(repository.findById(id));
    }

    @GetMapping
    public Flux<BankAccount> getAllAccounts() {
        return repository.findAll();
    }

}
