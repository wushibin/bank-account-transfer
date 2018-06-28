package ddd.saga.example.transfer.handle;

import ddd.saga.example.transfer.domain.BankAccount;
import ddd.saga.example.transfer.domain.BankAccountRepoService;
import ddd.saga.example.transfer.command.BankAccountTransferInCommand;
import ddd.saga.example.transfer.domain.TransferInfo;

public class BankAccountTransferInCommandHandler implements CommandHandle<BankAccountTransferInCommand> {
    // Autowired
    private BankAccountRepoService bankAccountRepoService;

    //@Transaction
    public void execute(BankAccountTransferInCommand command) {

        TransferInfo transferInfo = command.getTransferInfo();
        BankAccount target = bankAccountRepoService.find(transferInfo.getTargetAccountId(), transferInfo.getTargetAccountLocation());

        target.transferIn(transferInfo, command.getProcessId());

        bankAccountRepoService.saveOrUpdate(target, transferInfo.getTargetAccountLocation());
    }
}
