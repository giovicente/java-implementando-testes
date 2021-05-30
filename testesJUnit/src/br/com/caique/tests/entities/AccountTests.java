package br.com.caique.tests.entities;

import br.com.caique.entities.Account;
import br.com.caique.tests.factory.AccountFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTests {


    // Forma de escrever os métodos: <AÇÃO> should <EFEITO> [when <CENÁRIO>]
    @Test
    public void depositShouldIncreaseBalanceWhenPositiveAmount(){
        //ação      --> ao depositar                //deposit
        //efeito    --> deveria aumentar o saldo    //Should Increase Balance
        //quando    --> quando o valor eh positivo   //When Positive Amount

        /*
         Padrão AAA
            - Arrange: instancie os objetos necessários
            - Act: execute as ações necessárias
            - Assert: declare o que deveria acontecer (resultado esperado)
         */

        //passo>> Arrange
        double amount = 200.0;
        double expectedValue = 196.0;
        Account acc = AccountFactory.createEmptyAccount();

        //passo>> Act:
        acc.deposit(amount);

        //passo>> Assert
        Assertions.assertEquals(expectedValue, acc.getBalance());
    }

    @Test
    public void depositShouldDoNothingWhenNegativeAmount(){
        double expectedValue =0.0;
        Account acc = AccountFactory.createAccount(expectedValue);
        double amount = -200.0;

        acc.deposit(amount);

        Assertions.assertEquals(expectedValue, acc.getBalance());

    }

    @Test
    public void fullWithdrawShouldClearBalanceAndReturnFullBalance(){
        double expectedValue =0.0;
        double initialBalance = 800.0;
        Account acc = AccountFactory.createAccount(initialBalance);

        double result = acc.fullWithdraw();

        Assertions.assertEquals(expectedValue, acc.getBalance());
        Assertions.assertTrue(result == initialBalance);
    }

    @Test
    public void withdrawShouldDecreaseBalanceWhenSufficientBalance(){
        Account acc = AccountFactory.createAccount(800.0);

        acc.withdraw(500.0);;

        Assertions.assertEquals(300, acc.getBalance());
    }

    @Test
    public void withdrawShouldTrowExceptionWhenInsufficientBalance(){

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Account acc = AccountFactory.createAccount(800.0);
            acc.withdraw(801.0);;
        });
    }

}
