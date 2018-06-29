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
        BankAccountTransferInCompleteEvent bankAccountTransferInCompletedEvent = new BankAccountTransferInCompleteEvent(transferInfo, processorId);
        EventPublisher.publish(bankAccountTransferInCompletedEvent);
    }


    public void rollbackTransferOut(UUID processorId, TransferInfo transferInfo){
        // rollback the transfer out
        // this.accountMoney = this.accountMoney + transferInfo.transferMoney

        BankAccountRollbackTransferOutEvent bankAccountTransferOutRollbackedEvent = new BankAccountRollbackTransferOutEvent(processorId, transferInfo);
        EventPublisher.publish(bankAccountTransferOutRollbackedEvent);
    }

    public void transferOut(UUID processorId, TransferInfo transferInfo) {
        if (!isBankAccountEnough(transferInfo.getTransferMoney())){
            EventPublisher.publish(new BankAccountInsufficientMoneyEvent(transferInfo, processorId));
            return;
        }

        // this.accountMoney = this.accountMoney - transferMoney;
        EventPublisher.publish(new BankAccountTransferOutCompletedEvent(transferInfo, processorId));
    }

    public boolean isBankAccountEnough(AccountMoney money){
        return true;
    }
}
