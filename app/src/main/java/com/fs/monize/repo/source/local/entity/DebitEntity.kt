package com.fs.monize.repo.source.local.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_debit")
data class DebitEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "debit_id")
    var debit_id: Int,

    @ColumnInfo(name = "fund_id")
    var fund_id: Int,

    @ColumnInfo(name = "category_id")
    var category_id: Int,

    @ColumnInfo(name = "debit_name")
    var debit_name: String? = null,

    @ColumnInfo(name = "debit_nominal")
    var debit_nominal: Int,

    @ColumnInfo(name = "debit_date")
    var debit_date: String? = null
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(debit_id)
        parcel.writeInt(fund_id)
        parcel.writeInt(category_id)
        parcel.writeString(debit_name)
        parcel.writeInt(debit_nominal)
        parcel.writeString(debit_date)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DebitEntity> {
        override fun createFromParcel(parcel: Parcel): DebitEntity {
            return DebitEntity(parcel)
        }

        override fun newArray(size: Int): Array<DebitEntity?> {
            return arrayOfNulls(size)
        }
    }
}
