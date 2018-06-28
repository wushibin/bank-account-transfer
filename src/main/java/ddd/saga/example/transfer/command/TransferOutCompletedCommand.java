package ddd.saga.example.transfer.command;

import ddd.saga.example.common.domain.DomainCommand;
import ddd.saga.example.transfer.domain.TransferInfo;

import java.util.UUID;

public class TransferOutCompletedCommand extends DomainCommand{
    public TransferOutCompletedCommand(UUID processorId, TransferInfo transferInfo) {
    }

    private TransferInfo transferInfo;
    private UUID processorId;

    public UUID getProcessorId() {
        return processorId;
    }

    public TransferInfo getTransferInfo() {
        return transferInfo;
    }
}
