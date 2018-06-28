package ddd.saga.example.transfer.domain;

import ddd.saga.example.common.domain.AggregateRoot;
import ddd.saga.example.common.domain.DomainEntity;
import ddd.saga.example.transfer.domain.event.*;

import java.util.UUID;

@AggregateRoot
public class TransferProcessor extends DomainEntity {
    private UUID processorId;
    private TransferStatusEnum transferStatus;

    public TransferProcessor(){

    }

    public TransferProcessor(UUID id, TransferInfo transferInfo){
        this.transferStatus = TransferStatusEnum.TransferStarted;
        this.processorId = id;
        EventPublisher.publish(new ProcessorTransferStartedEvent(this.processorId, transferInfo));
    }


    public void processSourceAccountInsufficientMoney(TransferInfo transferInfo, UUID processorId) {
        this.transferStatus = TransferStatusEnum.TransferAborted;

        ProcessTransferAbortEvent processTransferAbortEvent = new ProcessTransferAbortEvent(this.processorId, transferInfo);

        EventPublisher.publish(processTransferAbortEvent);
    }

    public void processCompleted(TransferInfo transferInfo) {
        this.transferStatus = TransferStatusEnum.TransferInCompleted;

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

    public boolean inFinished(){
        return TransferStatusEnum.TransferInCompleted.equals(transferStatus)
                || TransferStatusEnum.TransferAborted.equals(transferStatus);
    }
}
