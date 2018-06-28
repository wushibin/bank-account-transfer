package ddd.saga.example.transfer.domain;


import java.util.UUID;

public interface TransferProcessorRepository {
    TransferProcessor find(UUID transferId);

    void saveOrUpdate(TransferProcessor transferProcessor);
}
