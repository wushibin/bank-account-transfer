package ddd.saga.example.transfer.command;

import ddd.saga.example.transfer.domain.TransferInfo;

import java.util.UUID;

public class TransferOutCompletedCommand {
    public TransferOutCompletedCommand(UUID processorId, TransferInfo transferInfo) {
    }
}
