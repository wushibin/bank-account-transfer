package ddd.saga.example.transfer.domain;

import ddd.saga.example.common.domain.ValueObject;

import java.math.BigDecimal;

public class AccountMoney extends ValueObject {
    private BigDecimal amount;
    private Integer unit;
}
