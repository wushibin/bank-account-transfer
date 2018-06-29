package ddd.saga.example.transfer.web;

import ddd.saga.example.transfer.domain.AccountMoney;

import java.util.UUID;

public class BankAccountTransferRequest {
    /**
     * hash(enc(sourceAccountId + targetAccountId + transferMoney))
     * Using the to valid the transfer info
     */
    private String hash;
    private UUID sourceAccountId;
    private Integer sourceAccountLocation;

    private UUID targetAccountId;
    private Integer targetAccountLocation;

    private AccountMoney accountMoney;

    public UUID getSourceAccountId() {
        return sourceAccountId;
    }

    public UUID getTargetAccountId() {
        return targetAccountId;
    }

    public Integer getSourceAccountLocation() {
        return sourceAccountLocation;
    }

    public Integer getTargetAccountLocation() {
        return targetAccountLocation;
    }

    public AccountMoney getAccountMoney() {
        return accountMoney;
    }


    public String getHash() {
        return hash;
    }
}
