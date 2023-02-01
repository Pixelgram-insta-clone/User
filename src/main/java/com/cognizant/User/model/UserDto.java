package com.cognizant.User.model;

import java.util.Objects;

public class UserDto {
    private int id;
    private String username;
    private String profileImg;

    public UserDto() {
    }

    public UserDto(int id, String username, String profileImg) {
        this.id = id;
        this.username = username;
        this.profileImg = profileImg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return id == userDto.id && Objects.equals(username, userDto.username) && Objects.equals(profileImg, userDto.profileImg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, profileImg);
    }
}
