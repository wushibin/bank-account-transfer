package ddd.saga.example.transfer.handle;

import ddd.saga.example.transfer.command.TransferOutCompletedCommand;
import ddd.saga.example.transfer.domain.TransferInfo;
import ddd.saga.example.transfer.domain.TransferProcessor;
import ddd.saga.example.transfer.domain.TransferProcessorRepository;

public class TransferOutCompletedCommandHandler implements CommandHandle<TransferOutCompletedCommand>{
    //@Autowired
    private TransferProcessorRepository transferProcessorRepository;

    public void execute(TransferOutCompletedCommand command) {
        TransferProcessor transferProcessor = transferProcessorRepository.find(command.getProcessorId());

        TransferInfo transferInfo = command.getTransferInfo();
        transferProcessor.processTransferOutCompleted(command.getProcessorId(), transferInfo);

        transferProcessorRepository.saveOrUpdate(transferProcessor);
    }
}
