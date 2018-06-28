package ddd.saga.example.transfer.handle;

import ddd.saga.example.transfer.command.BankAccountTransferOutRollBackCommand;
import ddd.saga.example.transfer.domain.TransferProcessor;
import ddd.saga.example.transfer.domain.TransferProcessorRepository;

public class TransferOutRollBackCommandHandler implements CommandHandle<BankAccountTransferOutRollBackCommand> {

    //@Autowired
    private TransferProcessorRepository transferProcessorRepository;

    public void execute(BankAccountTransferOutRollBackCommand command) {
        TransferProcessor transferProcessor = transferProcessorRepository.find(command.getProcessorId());

        transferProcessor.processTransferOutRollbacked(command.getTransferInfo());

        transferProcessorRepository.saveOrUpdate(transferProcessor);
    }
}
