package ddd.saga.example.transfer.domain;

import ddd.saga.example.common.domain.DomainCommand;
import ddd.saga.example.common.domain.DomainEvent;

import java.util.UUID;

public class ProcessCompletedEvent extends DomainEvent{
    public ProcessCompletedEvent(UUID processorId, TransferInfo transferInfo) {
    }
}
