package ddd.saga.example.transfer.domain;

import java.util.UUID;

public class TransferInfo {
    private UUID sourceAccountId;
    private UUID targetAccountId;
    private AccountMoney transferMoney;

    public TransferInfo(UUID accountId, UUID targetAccountId, AccountMoney transferMoney) {

    }

    public UUID getSourceAccountId() {
        return sourceAccountId;
    }

    public UUID getTargetAccountId() {
        return targetAccountId;
    }

    public AccountMoney getTransferMoney() {
        return transferMoney;
    }
}
