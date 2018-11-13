package com.example.seanm.mystory;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

public class questionCard implements Parcelable, Comparable<questionCard>{



    private String name;
    private String message;

    public questionCard(String name, String message) {
        this.name = name;
        this.message = message;
    }

    protected questionCard(Parcel in) {
        name = in.readString();
        message = in.readString();
    }

    public static final Creator<questionCard> CREATOR = new Creator<questionCard>() {
        @Override
        public questionCard createFromParcel(Parcel in) {
            return new questionCard(in);
        }

        @Override
        public questionCard[] newArray(int size) {
            return new questionCard[size];
        }
    };


    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(message);
    }

    @Override
    public int compareTo(@NonNull questionCard o) {
        return - this.getName().compareTo(o.getName());
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        questionCard other = (questionCard) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!message.equals(other.message))
            return false;
        return true;
    }

}