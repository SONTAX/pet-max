package entity;

public class CreditSystem {
    private User user;

    public CreditSystem(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public boolean transferMoney(Double amount) {
        Double currentMoneyAmount = user.getAccount().getMoneyAmount();
        if (currentMoneyAmount < amount) {
            return false;
        }
        user.getAccount().setMoneyAmount(currentMoneyAmount - amount);
        return true;
    }

    public void topUpAccount(Double amount) {
        user.getAccount().setMoneyAmount(user.getAccount().getMoneyAmount() + amount);
    }

    public Double balance() {
        return user.getAccount().getMoneyAmount();
    }

    public void changeId(String newId) {
        user.setIdentificationNumber(newId);
    }
}
