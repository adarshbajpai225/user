package com.example.User_Details.entity;

public class UserwithProfile {
	
	private User1 user;
    private UserProfile1 userProfile;

    public UserwithProfile(User1 user, UserProfile1 userProfile) {
        this.user = user;
        this.userProfile = userProfile;
    }

    public User1 getUser() {
        return user;
    }

    public void setUser1(User1 user) {
        this.user = user;
    }

    public UserProfile1 getUserProfile() {
        return userProfile;
    }

    public void setUserProfile1(UserProfile1 userProfile) {
        this.userProfile = userProfile;
    }

}
