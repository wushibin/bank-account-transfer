package ddd.saga.example.transfer.domain.event;

import ddd.saga.example.common.domain.DomainEvent;
import ddd.saga.example.transfer.domain.TransferInfo;

import java.util.UUID;

public class ProcessTransferStartedEvent extends DomainEvent{

    private UUID processId;
    private TransferInfo transferInfo;

    public ProcessTransferStartedEvent(UUID processorId, TransferInfo transferInfo) {

    }

    public UUID getProcessId() {
        return processId;
    }

    public TransferInfo getTransferInfo() {
        return transferInfo;
    }
}
