package ddd.saga.example.transfer.domain;

import java.util.UUID;

public class TransferInfo {
    private UUID sourceAccountId;
    private Integer sourceAccountLocation;
    private UUID targetAccountId;
    private Integer targetAccountLocation;
    private AccountMoney transferMoney;

    public TransferInfo(UUID sourceAccountId, Integer sourceAccountLocation,
                        UUID targetAccountId, Integer targetAccountLocation,
                        AccountMoney transferMoney) {

    }

    public UUID getSourceAccountId() {
        return sourceAccountId;
    }

    public Integer getSourceAccountLocation() {
        return sourceAccountLocation;
    }

    public UUID getTargetAccountId() {
        return targetAccountId;
    }

    public Integer getTargetAccountLocation() {
        return targetAccountLocation;
    }

    public AccountMoney getTransferMoney() {
        return transferMoney;
    }
}
