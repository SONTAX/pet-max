package entity;

public class User {
    private String name;
    private String surname;
    private Role role;
    private Account account;
    private String identificationNumber;

    public User(String name, String surname, Role role, String identificationNumber) {
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.account = new Account(identificationNumber);
        this.identificationNumber = identificationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }
}

