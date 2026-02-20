package junitlab.bank;

import junitlab.bank.impl.FirstNationalBank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;

class BankTest {
    private Bank bank;

    @BeforeEach
    void setup() {
        bank = new FirstNationalBank();
    }

    @Test
    public void testOpenAccount() throws Exception {
        String account = bank.openAccount(); // új számla létrehozása
        Assertions.assertNotNull(account);

        long balance = bank.getBalance(account); // egyenleg lekérdezése
        Assertions.assertEquals(0L, balance);
    }

    @Test
    public void testUniqueAccount(){
        String account1 = bank.openAccount();
        String account2 = bank.openAccount();
        Assertions.assertNotEquals(account1,account2); // kulonbozo szamlaszamok
    }

    @Test
    public void testInvalidAccount() {
        Assertions.assertThrows(AccountNotExistsException.class, () -> {
            bank.getBalance("INVALID");
        });
    }

    @Test
    public void testDeposit() throws Exception{
        String account = bank.openAccount();
        bank.deposit(account, 2000L);
        long balance = bank.getBalance(account);
        Assertions.assertEquals(2000L, balance);
    }
}
