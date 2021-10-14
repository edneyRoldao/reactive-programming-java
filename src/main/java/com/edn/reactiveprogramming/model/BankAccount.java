package com.edn.reactiveprogramming.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("bankAccount")
public class BankAccount {

    @Id
    private String id;

    private String username;
    private String accountNumber;
    private Integer balance;

}
