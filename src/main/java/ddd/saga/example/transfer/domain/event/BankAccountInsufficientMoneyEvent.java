package ddd.saga.example.transfer.domain.event;

import ddd.saga.example.common.domain.DomainEvent;
import ddd.saga.example.transfer.domain.TransferInfo;

import java.util.UUID;

public class BankAccountInsufficientMoneyEvent extends DomainEvent{
    private TransferInfo transferInfo;
    private UUID processorId;

    public BankAccountInsufficientMoneyEvent(TransferInfo transferInfo, UUID processorId) {

    }
}
