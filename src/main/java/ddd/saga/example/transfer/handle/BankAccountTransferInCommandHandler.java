package ddd.saga.example.transfer.handle;

import ddd.saga.example.transfer.domain.BankAccount;
import ddd.saga.example.transfer.domain.BankAccountRepository;
import ddd.saga.example.transfer.command.BankAccountTransferInCommand;

public class BankAccountTransferInCommandHandler implements CommandHandle<BankAccountTransferInCommand> {


    // @Autowired
    private BankAccountRepository bankAccountRepository;

    //@Transaction
    public void execute(BankAccountTransferInCommand command) {

        BankAccount target = bankAccountRepository.find(command.getTransferInfo().getTargetAccountId());

        target.transferIn(command.getTransferInfo(), command.getProcessId());

        bankAccountRepository.saveOrUpdate(target);
    }
}
