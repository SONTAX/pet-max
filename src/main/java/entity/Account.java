package entity;

public class Account {
    private String accountNumber;
    private Double moneyAmount;

    public Account() {
    }

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.moneyAmount = 0.0;
    }

    public Account(String accountNumber, Double moneyAmount) {
        this.accountNumber = accountNumber;
        this.moneyAmount = moneyAmount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(Double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }
}
