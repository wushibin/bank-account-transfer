package ddd.saga.example.transfer.domain;

import ddd.saga.example.transfer.command.*;
import ddd.saga.example.transfer.domain.event.*;

public class TransferEventManager {
    // observe the 'transfer' event and send the 'bank account' command
    public void handleTransferStartedEvent(ProcessorTransferStartedEvent processorTransferStartedEvent) {
        BankAccountTransferOutCommand bankAccountTransferOutCommand =
                new BankAccountTransferOutCommand(processorTransferStartedEvent.getProcessId(),
                        processorTransferStartedEvent.getTransferInfo());
        CommandContext.sendCommand(bankAccountTransferOutCommand);
    }

    // observe the 'bank account' event and send the 'transfer' command
    public void handleBankAccountTransferOutCompleteEvent(BankAccountTransferOutCompleteEvent bankAccountTransferOutCompleteEvent){

        TransferOutCompletedCommand transferOutCompletedCommand = new TransferOutCompletedCommand(bankAccountTransferOutCompleteEvent.getProcessorId(), bankAccountTransferOutCompleteEvent.getTransferInfo());

        CommandContext.sendCommand(transferOutCompletedCommand);
    }

    // observe the 'transfer' event and send the 'bank account' command
    public void handleProcessTransferOutCompleteEvent(ProcessTransferOutCompletedEvent transferOutCompletedEvent) {
        BankAccountTransferInCommand bankAccountTransferInCommand = new BankAccountTransferInCommand(transferOutCompletedEvent.getProcessorId(),
                transferOutCompletedEvent.getTransferInfo());

        CommandContext.sendCommand(bankAccountTransferInCommand);
    }

    // observe the 'bank account' event and send the 'transfer' command
    public void handleBankAccountInsufficientMoneyEvent(BankAccountInsufficientMoneyEvent bankAccountInsufficientMoneyEvent) {
        TransferInsufficientMoneyCommand transferInsufficientMoneyCommand = new TransferInsufficientMoneyCommand();
        CommandContext.sendCommand(transferInsufficientMoneyCommand);
    }

    // observe the 'transfer' event
    public void handleTransferAbortEvent(ProcessTransferAbortEvent transferAbortEvent){
        // log that the transfer has aborted
    }

    // observe the 'bank account' event and send the 'transfer' command
    public void handleBankAccountTransferInCompletedEvent(BankAccountTransferInCompleteEvent bankAccountTransferInCompleteEvent){

        TransferInCompletedCommand transferInCompletedCommand = new TransferInCompletedCommand(bankAccountTransferInCompleteEvent.getProcessorId(),
                bankAccountTransferInCompleteEvent.getTransferInfo());

        CommandContext.sendCommand(transferInCompletedCommand);
    }

    // observe the 'transfer' event
    public void handleTransferCompletedEvent(ProcessCompletedEvent processCompletedEvent){
        // log the transfer has completed
    }

    public void handleBankAccountTransferInFailedEvent(BankAccountTransferInFailedEvent transferInFailedEvent){
        BankAccountTransferOutRollBackCommand bankAccountTransferOutRollBackCommand =
                new BankAccountTransferOutRollBackCommand(transferInFailedEvent.getProcessId(),
                        transferInFailedEvent.getTransferInfo());

        CommandContext.sendCommand(bankAccountTransferOutRollBackCommand);
    }

    // observe the 'bank account' event and send the 'transfer' command
    public void handBankAccountTransferOutRollbackEvent(BankAccountRollbackTransferOutEvent rollbackTransferOutEvent){
        TransferOutRollbackCommand transferOutRollbackCommand = new TransferOutRollbackCommand(rollbackTransferOutEvent.getProcessorId(), rollbackTransferOutEvent.getTransferInfo());

        CommandContext.sendCommand(transferOutRollbackCommand);
    }

    // observe the 'transfer' event
    public void handleTransferRollbackEvent(ProcessTransferOutRollbackEvent processTransferOutRollbackEvent){
        // log the message the the transfer out has been roll backed
    }
}
