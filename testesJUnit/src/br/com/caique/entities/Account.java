package br.com.caique.entities;

public class Account {

    private static double DEPOSIT_FEE_PERCENTAGE = 0.02;

    private Long id;        //id da conta
    private Double balance; //saldo da conta

    public Account() {
    }

    public Account(Long id, Double balance) {
        this.id = id;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void deposit(Double amound) {        //depositar
        if(amound >0) {
            amound -= amound * DEPOSIT_FEE_PERCENTAGE;
            this.balance += amound;
        }
    }

    public void withdraw(double amount){    //saque
        if (amount > balance){
            throw new IllegalArgumentException();
        }
        balance -=amount;
    }

    public double fullWithdraw(){    //saque total
        if (this.balance <= 0){
            throw new IllegalArgumentException();
        }

        double valorSacado = this.balance;
        this.balance =0.0;

        return valorSacado;
    }
}
