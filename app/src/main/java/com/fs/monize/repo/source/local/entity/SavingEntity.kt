package com.fs.monize.repo.source.local.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_saving")
data class SavingEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "saving_id")
    var saving_id: Int?,

    @ColumnInfo(name = "saving_name")
    var saving_name: String? = null,

    @ColumnInfo(name = "saving_nominal")
    var saving_nominal: Int,

    @ColumnInfo(name = "saving_balance")
    var saving_balance: Int,

    @ColumnInfo(name = "saving_periode")
    var saving_periode: String? = null
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(saving_id)
        parcel.writeString(saving_name)
        parcel.writeInt(saving_nominal)
        parcel.writeInt(saving_balance)
        parcel.writeString(saving_periode)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SavingEntity> {
        override fun createFromParcel(parcel: Parcel): SavingEntity {
            return SavingEntity(parcel)
        }

        override fun newArray(size: Int): Array<SavingEntity?> {
            return arrayOfNulls(size)
        }
    }
}