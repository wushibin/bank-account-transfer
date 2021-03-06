package ddd.saga.example.transfer.command;

import ddd.saga.example.common.domain.DomainCommand;
import ddd.saga.example.transfer.domain.TransferInfo;

import java.util.UUID;

public class TransferInsufficientMoneyCommand extends DomainCommand{
    private TransferInfo transferInfo;
    private UUID processorId;

    public UUID getProcessorId() {
        return processorId;
    }

    public TransferInfo getTransferInfo() {
        return transferInfo;
    }
}
