package ddd.saga.example.transfer.domain;

public enum TransferStatusEnum {
    TransferStarted,
    TransferOutCompleted,
    TransferInCompleted,
    RollbackTransferOut,
    TransferAborted
}
