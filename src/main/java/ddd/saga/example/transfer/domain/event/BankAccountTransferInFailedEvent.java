package ddd.saga.example.transfer.domain.event;

import ddd.saga.example.common.domain.DomainEvent;
import ddd.saga.example.transfer.domain.TransferInfo;

import java.util.UUID;

public class BankAccountTransferInFailedEvent extends DomainEvent{
    private UUID processId;
    private TransferInfo transferInfo;

    public BankAccountTransferInFailedEvent(TransferInfo transferInfo, UUID processorId) {
    }

    public TransferInfo getTransferInfo() {
        return transferInfo;
    }

    public UUID getProcessId() {
        return processId;
    }
}
