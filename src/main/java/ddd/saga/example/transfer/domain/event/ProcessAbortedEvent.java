package ddd.saga.example.transfer.domain.event;

import ddd.saga.example.common.domain.DomainEvent;
import ddd.saga.example.transfer.domain.TransferInfo;

import java.util.UUID;

public class ProcessAbortedEvent extends DomainEvent{
    public ProcessAbortedEvent(UUID processorId, TransferInfo transferInfo) {

    }
}
