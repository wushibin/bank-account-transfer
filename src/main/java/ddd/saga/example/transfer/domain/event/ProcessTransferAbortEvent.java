package ddd.saga.example.transfer.domain.event;

import ddd.saga.example.common.domain.DomainEvent;
import ddd.saga.example.transfer.domain.TransferInfo;

import java.util.UUID;

public class ProcessTransferAbortEvent extends DomainEvent{
    private UUID processorId;
    private TransferInfo transferInfo;

    public ProcessTransferAbortEvent(UUID processorId, TransferInfo transferInfo) {
    }

    public UUID getProcessorId() {
        return processorId;
    }

    public TransferInfo getTransferInfo() {
        return transferInfo;
    }
}
