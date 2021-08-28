package com.fs.monize.repo.source.local.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_credit")
data class CreditEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "credit_id")
    var credit_id: Int,

    @ColumnInfo(name = "fund_id")
    var fund_id: Int,

    @ColumnInfo(name = "category_id")
    var category_id: Int,

    @ColumnInfo(name = "limit_id")
    var limit_id: Int,

    @ColumnInfo(name = "credit_name")
    var credit_name: String? = null,

    @ColumnInfo(name = "credit_nominal")
    var credit_nominal: Int,

    @ColumnInfo(name = "credit_date")
    var credit_date: String? = null
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(credit_id)
        parcel.writeInt(fund_id)
        parcel.writeInt(category_id)
        parcel.writeInt(limit_id)
        parcel.writeString(credit_name)
        parcel.writeInt(credit_nominal)
        parcel.writeString(credit_date)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CreditEntity> {
        override fun createFromParcel(parcel: Parcel): CreditEntity {
            return CreditEntity(parcel)
        }

        override fun newArray(size: Int): Array<CreditEntity?> {
            return arrayOfNulls(size)
        }
    }
}
