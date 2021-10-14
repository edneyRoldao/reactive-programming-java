package com.edn.reactiveprogramming.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankAccountResponse {

    private String username;
    private String accountNumber;
    private Integer balance;

}
