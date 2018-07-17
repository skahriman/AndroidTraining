package com.example.sefakkahriman.servicesproject.problem_2;


import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {

    String name;
    String title;
    String type;
    int pictureID;

    public Person(String name, String title, String type, int pictureID) {
        this.name = name;
        this.title = title;
        this.type = type;
        this.pictureID = pictureID;
    }

    protected Person(Parcel in) {
        name = in.readString();
        title = in.readString();
        type = in.readString();
        pictureID = in.readInt();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(title);
        parcel.writeString(type);
        parcel.writeInt(pictureID);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPictureID() {
        return pictureID;
    }

    public void setPictureID(int pictureID) {
        this.pictureID = pictureID;
    }
}