package junitlab.bank;

import junitlab.bank.impl.FirstNationalBank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankTestFixture {
    private Bank bank;
    String account1;
    String account2;
    @BeforeEach
    public void setup() throws Exception{
        bank = new FirstNationalBank();
        account1 = bank.openAccount();
        bank.deposit(account1, 1500L);
        account2 = bank.openAccount();
        bank.deposit(account2, 12000L);
    }

    @Test
    public void testTransfer() throws Exception{
        bank.transfer(account2,account1,3456L);
        Assertions.assertEquals(4956L,bank.getBalance(account1));
        Assertions.assertEquals(8544, bank.getBalance(account2));
    }

    @Test
    public void testTransferWithoutEnoughFunds() throws Exception{
        Assertions.assertThrows(NotEnoughFundsException.class, ()->
                bank.transfer(account1,account2,3456L));
    }
}
