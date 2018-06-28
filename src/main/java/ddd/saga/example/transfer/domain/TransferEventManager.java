package ddd.saga.example.transfer.domain;

import ddd.saga.example.transfer.command.*;
import ddd.saga.example.transfer.domain.event.*;

public class TransferEventManager {
    public void handleTransferStartedEvent(ProcessorTransferStartedEvent processorTransferStartedEvent) {
        BankAccountTransferOutCommand bankAccountTransferOutCommand =
                new BankAccountTransferOutCommand(processorTransferStartedEvent.getProcessId(),
                        processorTransferStartedEvent.getTransferInfo());
        CommandContext.sendCommand(bankAccountTransferOutCommand);
    }

    public void handleBankAccountTransferOutCompleteEvent(BankAccountTransferOutCompleteEvent bankAccountTransferOutCompleteEvent) {
        BankAccountTransferInCommand bankAccountTransferInCommand = new BankAccountTransferInCommand(bankAccountTransferOutCompleteEvent.getProcessorId(),
                bankAccountTransferOutCompleteEvent.getTransferInfo());

        CommandContext.sendCommand(bankAccountTransferInCommand);
    }

    public void handleBankAccountInsufficientMoneyEvent(BankAccountInsufficientMoneyEvent bankAccountInsufficientMoneyEvent) {
        TransferInsufficientMoneyCommand transferInsufficientMoneyCommand = new TransferInsufficientMoneyCommand();
        CommandContext.sendCommand(transferInsufficientMoneyCommand);
    }

    public void handleTransferAbortEvent(ProcessTransferAbortEvent transferAbortEvent){
        // log that the transfer has aborted
    }

    public void handleBankAccountTransferInCompletedEvent(BankAccountTransferInCompleteEvent bankAccountTransferInCompleteEvent){

        TransferInCompletedCommand transferInCompletedCommand = new TransferInCompletedCommand(bankAccountTransferInCompleteEvent.getProcessorId(),
                bankAccountTransferInCompleteEvent.getTransferInfo());

        CommandContext.sendCommand(transferInCompletedCommand);
    }

    public void handleTransferCompletedEvent(ProcessCompletedEvent processCompletedEvent){
        // log the transfer has completed
    }

    public void handleBankAccountTransferInFailedEvent(BankAccountTransferInFailedEvent transferInFailedEvent){
        BankAccountTransferOutRollBackCommand bankAccountTransferOutRollBackCommand =
                new BankAccountTransferOutRollBackCommand(transferInFailedEvent.getProcessId(),
                        transferInFailedEvent.getTransferInfo());

        CommandContext.sendCommand(bankAccountTransferOutRollBackCommand);
    }

    public void handBankAccountTransferOutRollbackEvent(BankAccountRollbackTransferOutEvent rollbackTransferOutEvent){
        TransferOutRollbackCommand transferOutRollbackCommand = new TransferOutRollbackCommand(rollbackTransferOutEvent.getProcessorId(), rollbackTransferOutEvent.getTransferInfo());

        CommandContext.sendCommand(transferOutRollbackCommand);
    }

    public void handleTransferRollbackEvent(ProcessTransferOutRollbackEvent processTransferOutRollbackEvent){
        // log the message the the transfer out has been roll backed
    }
}
