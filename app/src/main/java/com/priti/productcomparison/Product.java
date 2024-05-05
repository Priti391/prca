package com.priti.productcomparison;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {
    private String name;
    private double price;
    private String imageUrl;
    private int imageResId;

    // Constructor, getters, and setters

    protected Product(Parcel in) {
        name = in.readString();
        price = in.readDouble();
        imageUrl = in.readString();
    }

    public static final Creator<Products> CREATOR = new Creator<Products>() {
        @Override
        public Products createFromParcel(Parcel in) {
            return new Products();
        }

        @Override
        public Products[] newArray(int size) {
            return new Products[size];
        }
    };

    public Product(String s, double v, String s1) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeDouble(price);
        dest.writeString(imageUrl);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public int getName() {
        return 0;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public Object getPrice() {
        return 0;


    }

    public Object getImageUrl() {
        return null;
    }
}