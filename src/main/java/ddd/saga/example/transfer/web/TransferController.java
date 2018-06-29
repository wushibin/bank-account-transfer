package ddd.saga.example.transfer.web;

import ddd.saga.example.transfer.command.BankAccountTransferCommand;
import ddd.saga.example.transfer.command.BankAccountTransferOutCommand;
import ddd.saga.example.transfer.command.CommandContext;
import ddd.saga.example.transfer.domain.TransferInfo;

public class TransferController {

    //@PostMapping("transfer")
    void bankAccountTransfer(/*@RequestBody*/ BankAccountTransferRequest bankAccountTransferRequest){

        // DistributeLockManager.Lock(bankAccountTransferRequest.getHash());
        // to prevent the same request come at the same time

        // ValidateTransferInfo()
        // using the bankAccountTransferRequest.hash to validate the transfer info

        BankAccountTransferCommand bankAccountTransferCommand = new BankAccountTransferCommand(bankAccountTransferRequest.getHash(), bankAccountTransferRequest.getSourceAccountId(),
                bankAccountTransferRequest.getSourceAccountLocation(),
                bankAccountTransferRequest.getTargetAccountId(), bankAccountTransferRequest.getTargetAccountLocation(),
                bankAccountTransferRequest.getAccountMoney());
        CommandContext.sendCommand(bankAccountTransferCommand);
    }
}
