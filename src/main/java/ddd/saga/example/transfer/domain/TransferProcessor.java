package ddd.saga.example.transfer.domain;

import ddd.saga.example.common.domain.AggregateRoot;
import ddd.saga.example.common.domain.DomainEntity;
import ddd.saga.example.transfer.domain.event.*;

import java.util.UUID;

@AggregateRoot
public class TransferProcessor extends DomainEntity {
    private UUID processorId;
    private TransferInfo transferInfo;
    private TransferStatusEnum transferStatus;

    public TransferProcessor(){

    }

    public TransferProcessor(TransferInfo transferInfo){
        this.transferStatus = TransferStatusEnum.TransferStarted;
        this.processorId = UUID.randomUUID();
        EventPublisher.publish(new ProcessorTransferStartedEvent(this.processorId, transferInfo));
    }


    public void processSourceAccountInsufficientMoney(UUID sourceAccountId, UUID targetAccountId, AccountMoney transferMoney, UUID processorId) {
        this.transferStatus = TransferStatusEnum.TransferAborted;

        TransferInfo transferInfo = new TransferInfo(sourceAccountId, targetAccountId, transferMoney);
        ProcessTransferAbortEvent processTransferAbortEvent = new ProcessTransferAbortEvent(this.processorId, transferInfo);

        EventPublisher.publish(processTransferAbortEvent);
    }

    public void processCompleted(TransferInfo transferInfo) {
        this.transferStatus = TransferStatusEnum.TransferCompleted;

        // The TransferEventHandler
        ProcessCompletedEvent processCompletedEvent = new ProcessCompletedEvent(processorId, transferInfo);
        EventPublisher.publish(processCompletedEvent);
    }

    public void processTransferOutRollbacked(TransferInfo transferInfo) {
        this.transferStatus = TransferStatusEnum.RollbackTransferOut;

        // The TransferEventHandler
        ProcessTransferOutRollbackEvent processTransferOutRollbackEvent = new ProcessTransferOutRollbackEvent(processorId, transferInfo);
        EventPublisher.publish(processTransferOutRollbackEvent);
    }
}
