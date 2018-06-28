package ddd.saga.example.transfer.web;

public class TransferController {

    //@PostMapping("transfer")
    void bankAccountTransfer(/*@RequestBody*/ BankAccountTransferRequest bankAccountTransferRequest){

        // DistributeLockManager.Lock(bankAccountTransferRequest.getHash());
    }
}
