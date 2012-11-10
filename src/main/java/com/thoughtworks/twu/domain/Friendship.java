package com.thoughtworks.twu.domain;

import java.util.ArrayList;

// understands relationships between individuals
public class Friendship {

    private String userEmail;
    private String friendEmail;

    public Friendship() {
    }

    public Friendship(String userEmail, String friendEmail) {
        this.userEmail = userEmail;
        this.friendEmail = friendEmail;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Friendship)) return false;

        Friendship friendship = (Friendship) object;

        if (!friendEmail.equals(friendship.friendEmail)) return false;
        if (!userEmail.equals(friendship.userEmail)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userEmail.hashCode();
        result = 31 * result + friendEmail.hashCode();
        return result;
    }

}
