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

    @Override
    public boolean equals(Object connection) {
        if (this == connection) return true;
        if (connection == null || getClass() != connection.getClass()) return false;

        ConnectionDetails that = (ConnectionDetails) connection;

        if (!connectionEmail.equals(that.connectionEmail)) return false;
        if (!userEmail.equals(that.userEmail)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userEmail.hashCode();
        result = 31 * result + connectionEmail.hashCode();
        return result;
    }
}
