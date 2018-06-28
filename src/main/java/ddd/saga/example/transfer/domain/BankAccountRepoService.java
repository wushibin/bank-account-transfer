package ddd.saga.example.transfer.domain;

import java.util.UUID;

public class BankAccountRepoService {
    private BankAccountRepository bankAccountRepository;

    //@Transaction
    public BankAccount find(UUID bankAccountId, Integer location){
        // switch the data source according the location

        return bankAccountRepository.find(bankAccountId);
    }

    public void saveOrUpdate(BankAccount bankAccount, Integer location){
        // switch the data source according to the location
        bankAccountRepository.saveOrUpdate(bankAccount);
    }
}
