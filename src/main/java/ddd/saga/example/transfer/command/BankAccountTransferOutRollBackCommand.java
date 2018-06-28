package ddd.saga.example.transfer.command;

import ddd.saga.example.common.domain.DomainCommand;
import ddd.saga.example.transfer.domain.BankAccountRepository;
import ddd.saga.example.transfer.domain.TransferInfo;

import java.util.UUID;

public class BankAccountTransferOutRollBackCommand extends DomainCommand{
    private UUID processorId;
    private TransferInfo transferInfo;

    // @Autowired
    private BankAccountRepository bankAccountRepository;

    public BankAccountTransferOutRollBackCommand(UUID processId, TransferInfo transferInfo) {

    }

    public TransferInfo getTransferInfo() {
        return transferInfo;
    }

    public UUID getProcessorId() {
        return processorId;
    }
}
