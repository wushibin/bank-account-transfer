package ddd.saga.example.transfer.handle;

import ddd.saga.example.transfer.command.BankAccountTransferOutRollBackCommand;
import ddd.saga.example.transfer.command.TransferOutRollbackCommand;
import ddd.saga.example.transfer.domain.BankAccount;
import ddd.saga.example.transfer.domain.BankAccountRepoService;
import ddd.saga.example.transfer.domain.BankAccountRepository;
import ddd.saga.example.transfer.domain.TransferInfo;

public class BankAccountTransferOutRollBackCommandHandler implements CommandHandle<BankAccountTransferOutRollBackCommand> {

    // Autowired
    BankAccountRepoService bankAccountRepoService;

    public void execute(BankAccountTransferOutRollBackCommand command) {


        TransferInfo transferInfo = command.getTransferInfo();
        BankAccount sourceBankAccount = bankAccountRepoService.find(transferInfo.getSourceAccountId(), transferInfo.getSourceAccountLocation());

        sourceBankAccount.rollbackTransferOut(command.getProcessorId(), transferInfo);

        bankAccountRepoService.saveOrUpdate(sourceBankAccount, transferInfo.getSourceAccountLocation());
    }
}

