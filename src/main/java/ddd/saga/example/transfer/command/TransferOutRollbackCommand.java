package ddd.saga.example.transfer.command;

import ddd.saga.example.common.domain.DomainCommand;
import ddd.saga.example.transfer.domain.TransferInfo;

import java.util.UUID;

public class TransferOutRollbackCommand extends DomainCommand{
    public TransferOutRollbackCommand(UUID processorId, TransferInfo transferInfo) {
    }
}
