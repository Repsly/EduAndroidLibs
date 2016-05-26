package com.repsly.edu.libs.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Used for parcelable transfer between activities.
 */
public class ParcelTest implements Parcelable {
    String name;
    int age;
    boolean isGood;
    long howLong;
    OneModelTwo omt;

    public ParcelTest(String name, int age, boolean isGood, long howLong,
                      OneModelTwo omt) {
        this.name = name;
        this.age = age;
        this.isGood = isGood;
        this.howLong = howLong;
        this.omt = omt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGood() {
        return isGood;
    }

    public void setGood(boolean good) {
        isGood = good;
    }

    public long getHowLong() {
        return howLong;
    }

    public void setHowLong(long howLong) {
        this.howLong = howLong;
    }

    public OneModelTwo getOmt() {
        return omt;
    }

    public void setOmt(OneModelTwo omt) {
        this.omt = omt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.age);
        dest.writeByte(this.isGood ? (byte) 1 : (byte) 0);
        dest.writeLong(this.howLong);
        dest.writeParcelable(this.omt, flags);
    }

    public ParcelTest() {
    }

    protected ParcelTest(Parcel in) {
        this.name = in.readString();
        this.age = in.readInt();
        this.isGood = in.readByte() != 0;
        this.howLong = in.readLong();
        this.omt = in.readParcelable(OneModelTwo.class.getClassLoader());
    }

    public static final Creator<ParcelTest> CREATOR = new Creator<ParcelTest>() {
        @Override
        public ParcelTest createFromParcel(Parcel source) {
            return new ParcelTest(source);
        }

        @Override
        public ParcelTest[] newArray(int size) {
            return new ParcelTest[size];
        }
    };
}
