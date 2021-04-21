package backend;

public class Register
{
    static String enterUsername;
    static String enterPassword;
    static String reEnterPassword;
    static String enterEmail;

    public Register(String enterUsername, String enterPassword, String reEnterPassword, String enterEmail) {
        this.enterUsername = enterUsername;
        this.enterPassword = enterPassword;
        this.reEnterPassword = reEnterPassword;
        this.enterEmail = enterEmail;
    }

    public Register() {
    }
}
