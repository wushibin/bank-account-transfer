package ddd.saga.example.transfer.domain;

import ddd.saga.example.common.domain.AggregateRoot;
import ddd.saga.example.common.domain.DomainEntity;
import ddd.saga.example.transfer.domain.event.*;

import java.util.UUID;

@AggregateRoot
public class BankAccount extends DomainEntity {
    private UUID accountId;
    private AccountOwner accountOwner;
    private AccountNumber accountNumber;
    private AccountMoney accountMoney;

    public BankAccount(UUID accountId, AccountOwner owner, AccountNumber number, AccountMoney money){

    }

    public void transferIn(TransferInfo transferInfo, UUID processorId){
        boolean errorHappenWhenTransferIn = false;

        if (errorHappenWhenTransferIn){
            EventPublisher.publish(new BankAccountTransferInFailedEvent(transferInfo, processorId));
            return;
        }

        // this.accountMoney = this.accountMoney + transferInfo.transferMoney
        BankAccountTransferInCompleteEvent bankAccountTransferInCompleteEvent = new BankAccountTransferInCompleteEvent(transferInfo, processorId);
        EventPublisher.publish(bankAccountTransferInCompleteEvent);
    }


    public void rollbackTransferOut(UUID processorId, TransferInfo transferInfo){
        // rollback the transfer out
        // this.accountMoney = this.accountMoney + transferInfo.transferMoney

        BankAccountRollbackTransferOutEvent bankAccountRollbackTransferOutEvent = new BankAccountRollbackTransferOutEvent(processorId, transferInfo);
        EventPublisher.publish(bankAccountRollbackTransferOutEvent);
    }

    public void transferOut(UUID targetAccountId, AccountMoney transferMoney, UUID processorId) {
        if (!isBankAccountEnough(transferMoney)){
            TransferInfo transferInfo = new TransferInfo(accountId, targetAccountId, transferMoney);
            EventPublisher.publish(new BankAccountInsufficientMoneyEvent(transferInfo, processorId));
            return;
        }

        // this.accountMoney = this.accountMoney - transferMoney;
        TransferInfo transferInfo = new TransferInfo(accountId, targetAccountId, transferMoney);
        EventPublisher.publish(new BankAccountTransferOutCompleteEvent(transferInfo, processorId));
    }

    public boolean isBankAccountEnough(AccountMoney money){
        return true;
    }
}
