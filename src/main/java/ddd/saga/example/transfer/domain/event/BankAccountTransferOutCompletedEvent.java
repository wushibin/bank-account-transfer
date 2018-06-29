package ddd.saga.example.transfer.domain.event;

import ddd.saga.example.common.domain.DomainEvent;
import ddd.saga.example.transfer.domain.TransferInfo;

import java.util.UUID;

public class BankAccountTransferOutCompletedEvent extends DomainEvent {
    private TransferInfo transferInfo;
    private UUID processorId;

    public BankAccountTransferOutCompletedEvent(TransferInfo transferInfo, UUID processorId) {

    }

    public TransferInfo getTransferInfo() {
        return transferInfo;
    }

    public UUID getProcessorId() {
        return processorId;
    }
}
