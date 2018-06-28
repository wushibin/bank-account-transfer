package ddd.saga.example.transfer.handle;

import ddd.saga.example.transfer.command.BankAccountTransferCommand;
import ddd.saga.example.transfer.domain.TransferInfo;
import ddd.saga.example.transfer.domain.TransferProcessor;
import ddd.saga.example.transfer.domain.TransferProcessorRepository;

import java.util.Objects;
import java.util.UUID;

public class BankAccountTransferCommandHandler implements CommandHandle<BankAccountTransferCommand>{
    //@Autowired
    private TransferProcessorRepository transferProcessorRepository;

    //@Transaction
    public void execute(BankAccountTransferCommand command) {
        UUID processId = UUID.fromString(command.getHash());
        TransferProcessor existedProcessor = transferProcessorRepository.find(processId);

        if (Objects.nonNull(existedProcessor)){
            throw new RuntimeException("The transfer has already existed");
        }

        TransferInfo transferInfo = new TransferInfo(command.getSourceAccountId(), command.getSourceAccountLocation(),
                command.getTargetAccountId(), command.getTargetAccountLocation(), command.getAccountMoney());

        TransferProcessor transferProcessor = new TransferProcessor(processId, transferInfo);

        transferProcessorRepository.saveOrUpdate(transferProcessor);
    }
}
