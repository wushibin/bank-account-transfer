package ddd.saga.example.transfer.handle;

import ddd.saga.example.transfer.command.BankAccountTransferOutCommand;
import ddd.saga.example.transfer.domain.BankAccount;
import ddd.saga.example.transfer.domain.BankAccountRepoService;
import ddd.saga.example.transfer.domain.BankAccountRepository;
import ddd.saga.example.transfer.domain.TransferInfo;

public class BankAccountTransferOutCommandHandler implements CommandHandle<BankAccountTransferOutCommand>{

    // Autowired
    BankAccountRepoService bankAccountRepoService;

    public void execute(BankAccountTransferOutCommand command) {
        TransferInfo transferInfo = command.getTransferInfo();
        BankAccount sourceBankAccount = bankAccountRepoService.find(transferInfo.getSourceAccountId(), transferInfo.getSourceAccountLocation());

        sourceBankAccount.transferOut(command.getProcessorId(), transferInfo);

        bankAccountRepoService.saveOrUpdate(sourceBankAccount, transferInfo.getSourceAccountLocation());
    }
}
