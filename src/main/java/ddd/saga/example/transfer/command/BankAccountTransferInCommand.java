package ddd.saga.example.transfer.command;

import ddd.saga.example.common.domain.DomainCommand;
import ddd.saga.example.common.domain.DomainEvent;
import ddd.saga.example.transfer.domain.TransferInfo;

import java.util.UUID;

public class BankAccountTransferInCommand extends DomainCommand{
    private UUID processId;
    private TransferInfo transferInfo;

    public BankAccountTransferInCommand(UUID processorId, TransferInfo transferInfo) {
    }

    public TransferInfo getTransferInfo() {
        return transferInfo;
    }

    public UUID getProcessId() {
        return processId;
    }
}
