package com.repsly.edu.libs.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class UserSearch {
    @SerializedName("items")
    @Expose
    public List<UserSearchItem> items = new ArrayList<>();

}
