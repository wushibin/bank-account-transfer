package ddd.saga.example.transfer.handle;

import ddd.saga.example.transfer.command.TransferInsufficientMoneyCommand;
import ddd.saga.example.transfer.domain.TransferInfo;
import ddd.saga.example.transfer.domain.TransferProcessor;
import ddd.saga.example.transfer.domain.TransferProcessorRepository;

public class TransferInsufficientMoneyCommandHandler implements CommandHandle<TransferInsufficientMoneyCommand>{

    //@Autowired
    private TransferProcessorRepository transferProcessorRepository;

    //@Transaction
    public void execute(TransferInsufficientMoneyCommand command) {
        TransferProcessor transferProcessor = transferProcessorRepository.find(command.getProcessorId());

        TransferInfo transferInfo = command.getTransferInfo();
        transferProcessor.processSourceAccountInsufficientMoney(transferInfo.getSourceAccountId(), transferInfo.getTargetAccountId(),
                transferInfo.getTransferMoney(), command.getProcessorId());

        transferProcessorRepository.saveOrUpdate(transferProcessor);
    }
}
