package project;

public class User {

    private String login;
    private String password;
    private Wallet wallet;
    private String name;
    private String surname;
    private String passportNumber;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
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

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public User(String login, String password, Wallet wallet, String name, String surname, String passportNumber) {
        this.login = login;
        this.password = password;
        this.wallet = wallet;
        this.name = name;
        this.surname = surname;
        this.passportNumber = passportNumber;
    }
}

