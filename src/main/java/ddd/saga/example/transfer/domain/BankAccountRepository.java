package ddd.saga.example.transfer.domain;

import java.util.UUID;

public interface BankAccountRepository {
    BankAccount find(UUID bankAccountId);

    void saveOrUpdate(BankAccount bankAccount);
}
