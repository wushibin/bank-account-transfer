package ddd.saga.example.transfer.command;

import ddd.saga.example.common.domain.DomainCommand;
import ddd.saga.example.transfer.domain.AccountMoney;

import java.util.UUID;

public class BankAccountTransferCommand extends DomainCommand{
    private UUID sourceAccountId;
    private Integer sourceAccountLocation;

    private UUID targetAccountId;
    private Integer targetAccountLocation;

    private AccountMoney accountMoney;

    private String hash;

    public BankAccountTransferCommand(String hash, UUID sourceAccountId, Integer sourceAccountLocation, UUID targetAccountId, Integer targetAccountLocation, AccountMoney accountMoney) {

    }

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
