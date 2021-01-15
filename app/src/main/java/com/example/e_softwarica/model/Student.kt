package com.example.e_softwarica.model

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class Student(
//val StudentId:Int?=null,
val StudentName:String?=null,
val StudentAge:Int?=null,
val StudentGender:String?=null,
val StudentAddress:String?=null
): Parcelable {
    constructor(parcel: Parcel) : this(
    parcel.readString(),
    parcel.readValue(Int::class.java.classLoader) as? Int,
    parcel.readString(),
    parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(StudentName)
        parcel.writeValue(StudentAge)
        parcel.writeString(StudentGender)
        parcel.writeString(StudentAddress)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Student> {
        override fun createFromParcel(parcel: Parcel): Student {
            return Student(parcel)
        }

        override fun newArray(size: Int): Array<Student?> {
            return arrayOfNulls(size)
        }
    }



}
