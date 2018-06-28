package ddd.saga.example.transfer.domain.event;

import ddd.saga.example.common.domain.DomainEvent;
import ddd.saga.example.transfer.domain.TransferInfo;

import java.util.UUID;

public class ProcessTransferOutRollbackEvent extends DomainEvent{
    public ProcessTransferOutRollbackEvent(UUID processorId, TransferInfo transferInfo) {
    }
}
