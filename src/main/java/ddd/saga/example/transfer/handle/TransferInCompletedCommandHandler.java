package ddd.saga.example.transfer.handle;

import ddd.saga.example.transfer.command.TransferInCompletedCommand;
import ddd.saga.example.transfer.domain.TransferProcessor;
import ddd.saga.example.transfer.domain.TransferProcessorRepository;

public class TransferInCompletedCommandHandler implements CommandHandle<TransferInCompletedCommand>{

    //@Autowired
    private TransferProcessorRepository transferProcessorRepository;

    //@Transaction
    public void execute(TransferInCompletedCommand command) {
        TransferProcessor transferProcessor = transferProcessorRepository.find(command.getProcessorId());

        transferProcessor.processTransferInCompleted(command.getTransferInfo());

        transferProcessorRepository.saveOrUpdate(transferProcessor);
    }
}
