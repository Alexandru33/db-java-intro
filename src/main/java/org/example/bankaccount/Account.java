package org.example.bankaccount;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
public class Account {
    private int accountNo = -1;
    private double amount = 0;
    private int nationalId;




    public void deposit(int amount) throws DepositAmountException {

        if ( amount < 0 )
        {
            throw new DepositAmountException("Negative parameter in deposit()");
        }

        if ( this.amount + amount > Double.MAX_VALUE )
        {
            throw new ArithmeticException("Double overflow after adding");
        }

        this.amount += amount;


    }

    public void withdraw(int amount) {

        if ( amount < 0 )
        {
            throw new DepositAmountException("Negative parameter in withdraw()");
        }
        if ( amount > this.amount)
        {
            throw new NotEnoughMoneyException();
        }
        // Exceptie de underflow

        this.amount -= amount;


    }

    public void linkToNationalId(int nationalId) {
        if (!isNationalIdValid(nationalId)) {
            throw new InvalidNationalIdException("Invalid national id");
        }
        this.nationalId = nationalId;
    }

    private boolean isNationalIdValid(int nationalId) {
        return nationalId > 0;
    }
}
