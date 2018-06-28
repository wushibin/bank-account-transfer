package ddd.saga.example.transfer.domain.event;

import ddd.saga.example.common.domain.DomainEvent;
import ddd.saga.example.transfer.domain.TransferInfo;

import java.util.UUID;

public class ProcessorTransferStartedEvent extends DomainEvent{

    private UUID processId;
    private TransferInfo transferInfo;

    public ProcessorTransferStartedEvent(UUID processorId, TransferInfo transferInfo) {

    }

    public UUID getProcessId() {
        return processId;
    }

    public TransferInfo getTransferInfo() {
        return transferInfo;
    }
}
