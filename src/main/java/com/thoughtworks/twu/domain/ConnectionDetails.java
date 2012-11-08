package com.thoughtworks.twu.domain;
//job: understands the people that a user owes money and is owed money by
public class ConnectionDetails {
    private String userEmail;
    private String connectionEmail;

    private ConnectionDetails() {

    }

    public ConnectionDetails(String userEmail, String connectionEmail) {
        this.userEmail = userEmail;
        this.connectionEmail = connectionEmail;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getConnectionEmail() {
        return connectionEmail;
    }
}
