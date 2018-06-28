package ddd.saga.example.transfer.handle;

import ddd.saga.example.transfer.command.BankAccountTransferOutCommand;
import ddd.saga.example.transfer.domain.BankAccount;
import ddd.saga.example.transfer.domain.BankAccountRepository;

public class BankAccountTransferOutCommandHandler implements CommandHandle<BankAccountTransferOutCommand>{

    private BankAccountRepository bankAccountRepository;

    public void execute(BankAccountTransferOutCommand command) {
        BankAccount sourceBankAccount = bankAccountRepository.find(command.getTransferInfo().getSourceAccountId());

        sourceBankAccount.transferOut(command.getTransferInfo().getTargetAccountId(),
                command.getTransferInfo().getTransferMoney(), command.getProcessorId());

        bankAccountRepository.saveOrUpdate(sourceBankAccount);
    }
}
