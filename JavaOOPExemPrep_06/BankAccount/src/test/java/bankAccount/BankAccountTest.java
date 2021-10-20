package bankAccount;


import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BankAccountTest {


    @Test
    public void TestGetName() {
        BigDecimal bigDecimal = new BigDecimal(2);
        BankAccount bankAccount = new BankAccount("Ivo", bigDecimal);
        String expected = "Ivo";
        assertEquals(expected, bankAccount.getName());
    }

    @Test(expected = NullPointerException.class)
    public void TestGetNameShouldNotWork() {
        BankAccount bankAccount = null;
        bankAccount.getName();
    }

    @Test
    public void TestSetName() {
        BigDecimal bigDecimal = new BigDecimal(2);
        BankAccount bankAccount = new BankAccount("Ivaylo", bigDecimal);
    }


    @Test(expected = IllegalArgumentException.class)
    public void TestSetNameShouldNotWork() {
        BigDecimal bigDecimal = new BigDecimal(2);
        BankAccount bankAccount = new BankAccount("Iv", bigDecimal);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestSetNameShouldNotWorkWithValueMoreThan25() {
        BigDecimal bigDecimal = new BigDecimal(2);
        BankAccount bankAccount = new BankAccount("Ivdaijdajdjadjjdiajdajidjaidjaosjdoadaisjdoasjdia", bigDecimal);
    }

    @Test
    public void TestGetBalance() {
        BigDecimal bigDecimal = new BigDecimal(2);
        BankAccount bankAccount = new BankAccount("Ivo", bigDecimal);
        BigDecimal expected = new BigDecimal(2);
        assertEquals(expected, bankAccount.getBalance());
    }

    @Test
    public void TestSetBalance() {
        BigDecimal bigDecimal = new BigDecimal(2);
        BankAccount bankAccount = new BankAccount("Ivo", bigDecimal);
        BigDecimal expected = new BigDecimal(4);
        assertEquals(expected, bankAccount.getBalance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestSetBalanceShouldTrowExc() {
        BigDecimal bigDecimal = new BigDecimal(-1);
        BankAccount bankAccount = new BankAccount("Ivo", bigDecimal);
    }

    @Test
    public void TestDeposit() {
        BigDecimal bigDecimal = new BigDecimal(2);
        BankAccount bankAccount = new BankAccount("Ivo", bigDecimal);
        BigDecimal toDeposit = new BigDecimal(2);
        bankAccount.deposit(toDeposit);
        BigDecimal expected = new BigDecimal(4);
        assertEquals(expected, bankAccount.getBalance());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void TestDepositShouldTrowExc() {
        BigDecimal bigDecimal = new BigDecimal(2);
        BankAccount bankAccount = new BankAccount("Ivo", bigDecimal);
        BigDecimal toDeposit = new BigDecimal(-2);
        bankAccount.deposit(toDeposit);

    }

    @Test(expected = UnsupportedOperationException.class)
    public void TestDepositShouldTrowExcWithZeroParam() {
        BigDecimal bigDecimal = new BigDecimal(2);
        BankAccount bankAccount = new BankAccount("Ivo", bigDecimal);
        BigDecimal toDeposit = new BigDecimal(0);
        bankAccount.deposit(toDeposit);

    }

    @Test
    public void TestWithdraw() {
        BigDecimal bigDecimal = new BigDecimal(20);
        BankAccount bankAccount = new BankAccount("Ivo", bigDecimal);
        BigDecimal sumToWithDraw = new BigDecimal(10);
        bankAccount.withdraw(sumToWithDraw);
        BigDecimal expected = new BigDecimal(10);
        assertEquals(expected, bankAccount.getBalance());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void TestWithdrawShouldTrowExc() {
        BigDecimal bigDecimal = new BigDecimal(20);
        BankAccount bankAccount = new BankAccount("Ivo", bigDecimal);
        BigDecimal sumToWithDraw = new BigDecimal(30);
        bankAccount.withdraw(sumToWithDraw);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void TestWithdrawShouldTrowExcWithNegativeSum() {
        BigDecimal bigDecimal = new BigDecimal(20);
        BankAccount bankAccount = new BankAccount("Ivo", bigDecimal);
        BigDecimal sumToWithDraw = new BigDecimal(-1);
        bankAccount.withdraw(sumToWithDraw);
    }
}