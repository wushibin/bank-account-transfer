package ddd.saga.example.transfer.domain.event;

import ddd.saga.example.common.domain.DomainEvent;
import ddd.saga.example.transfer.domain.TransferInfo;

import java.util.UUID;

public class BankAccountRollbackTransferOutEvent extends DomainEvent{
    private UUID processorId;
    private TransferInfo transferInfo;

    public BankAccountRollbackTransferOutEvent(UUID processorId, TransferInfo transferInfo) {
    }

    public UUID getProcessorId() {
        return processorId;
    }

    public TransferInfo getTransferInfo() {
        return transferInfo;
    }
}
