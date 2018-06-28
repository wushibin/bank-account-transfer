package ddd.saga.example.transfer.command;

import ddd.saga.example.common.domain.DomainCommand;
import ddd.saga.example.transfer.domain.TransferInfo;

import java.util.UUID;

public class TransferInCompletedCommand extends DomainCommand{
    private UUID processorId;
    private TransferInfo transferInfo;

    public TransferInCompletedCommand(UUID processorId, TransferInfo transferInfo) {

    }

    public TransferInfo getTransferInfo() {
        return transferInfo;
    }

    public UUID getProcessorId() {
        return processorId;
    }
}
