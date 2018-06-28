package ddd.saga.example.transfer.command;

import ddd.saga.example.common.domain.DomainCommand;
import ddd.saga.example.common.domain.DomainEvent;
import ddd.saga.example.transfer.domain.TransferInfo;

import java.util.UUID;

public class BankAccountTransferOutCommand extends DomainCommand {
    private TransferInfo transferInfo;
    private UUID processorId;

    public BankAccountTransferOutCommand(UUID processId, TransferInfo transferInfo) {
        this.processorId = processId;
        this.transferInfo = transferInfo;
    }

    public UUID getProcessorId() {
        return processorId;
    }

    public TransferInfo getTransferInfo() {
        return transferInfo;
    }
}
