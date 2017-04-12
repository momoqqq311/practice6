package com.example.hong.practice6;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by hong on 2017-04-06.
 */

public class restaurant_info implements Serializable {
    String name = "";
    String kind = "";
    String tel = "";
    String menu1 = "";
    String menu2 = "";
    String menu3 = "";
    String homepage = "";
    String date ="";

    restaurant_info(String name, String kind, String tel, String menu1, String menu2, String menu3, String homepage,String date) {
        this.name = name;
        this.kind = kind;
        this.tel = tel;
        this.menu1 = menu1;
        this.menu2 = menu2;
        this.menu3 = menu3;
        this.homepage = homepage;
        this.date = date;
    }

    protected restaurant_info(Parcel in) {
        name = in.readString();
        kind = in.readString();
        tel = in.readString();
        menu1 = in.readString();
        menu2 = in.readString();
        menu3 = in.readString();
        homepage = in.readString();
        date = in.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(kind);
        dest.writeString(tel);
        dest.writeString(menu1);
        dest.writeString(menu2);
        dest.writeString(menu3);
        dest.writeString(homepage);
        dest.writeString(date);

    }
    public String getName() {
        return name;
    }
    public String toString(){
        String str = "";
        str = name +"/"+ kind +"/"+ tel+"/"+menu1+"/"+menu2+"/"+menu3+"/"+homepage+"/"+date;
        return str;
    }public String[] resaurant_array(){
        String str[] = {name,menu1,menu2,menu3,tel,homepage,date,kind};
        return str;
    }
}
