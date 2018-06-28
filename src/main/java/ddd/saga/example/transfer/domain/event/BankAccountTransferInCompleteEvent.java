package ddd.saga.example.transfer.domain.event;

import ddd.saga.example.common.domain.DomainEvent;
import ddd.saga.example.transfer.domain.TransferInfo;

import java.util.UUID;

public class BankAccountTransferInCompleteEvent extends DomainEvent{
    private TransferInfo transferInfo;
    private UUID processorId;

    public BankAccountTransferInCompleteEvent(TransferInfo transferInfo, UUID processorId) {
    }

    public UUID getProcessorId() {
        return processorId;
    }

    public TransferInfo getTransferInfo() {
        return transferInfo;
    }
}
