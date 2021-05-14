package model;

public class User {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;
    private String confirmPassword;

    public User() {
        this.firstName = "first";
        this.lastName = "last";
        this.phone = "+79620000000";
        this.email = System.currentTimeMillis() + "@gmail.com";
        this.password = "123QWEasd!";
        this.confirmPassword = "123QWEasd!";
    }

    public String getFirstName() {
        return firstName;
    }

        public User withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User withPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public User withConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
