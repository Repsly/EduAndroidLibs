package com.repsly.edu.libs.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by tomkan on 17.5.2016..
 */
public class OneModel implements Parcelable {

    @SerializedName("name")
    @Expose
    public String user;

    @SerializedName("html_url")
    @Expose
    public String htmlUrl;

    public OneModel(String user, String htmlUrl) {
        this.user = user;
        this.htmlUrl = htmlUrl;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.user);
        dest.writeString(this.htmlUrl);
    }

    protected OneModel(Parcel in) {
        this.user = in.readString();
        this.htmlUrl = in.readString();
    }

    public static final Creator<OneModel> CREATOR = new Creator<OneModel>() {
        @Override
        public OneModel createFromParcel(Parcel source) {
            return new OneModel(source);
        }

        @Override
        public OneModel[] newArray(int size) {
            return new OneModel[size];
        }
    };
}
