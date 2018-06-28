package ddd.saga.example.transfer.domain.event;

import ddd.saga.example.common.domain.DomainEvent;
import ddd.saga.example.transfer.domain.TransferInfo;

import java.util.UUID;

    public class ProcessTransferOutCompletedEvent extends DomainEvent{
    public ProcessTransferOutCompletedEvent(UUID processorId, TransferInfo transferInfo) {
    }

    private UUID processorId;
    private TransferInfo transferInfo;

    public UUID getProcessorId() {
        return processorId;
    }

    public TransferInfo getTransferInfo() {
        return transferInfo;
    }
}
