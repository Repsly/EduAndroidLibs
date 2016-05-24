package com.repsly.edu.libs.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tomkan on 17.5.2016..
 */
public class OneModelTwo implements Parcelable{
    String da;
    boolean ha;

    public String getDa() {
        return da;
    }

    public void setDa(String da) {
        this.da = da;
    }

    public boolean isHa() {
        return ha;
    }

    public void setHa(boolean ha) {
        this.ha = ha;
    }

    public OneModelTwo(String da, boolean ha) {
        this.da = da;
        this.ha = ha;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.da);
        dest.writeByte(this.ha ? (byte) 1 : (byte) 0);
    }

    protected OneModelTwo(Parcel in) {
        this.da = in.readString();
        this.ha = in.readByte() != 0;
    }

    public static final Creator<OneModelTwo> CREATOR = new Creator<OneModelTwo>() {
        @Override
        public OneModelTwo createFromParcel(Parcel source) {
            return new OneModelTwo(source);
        }

        @Override
        public OneModelTwo[] newArray(int size) {
            return new OneModelTwo[size];
        }
    };
}
