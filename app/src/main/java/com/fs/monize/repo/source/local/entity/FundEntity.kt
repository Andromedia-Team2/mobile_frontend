package com.fs.monize.repo.source.local.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_fund")
data class FundEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "fund_id")
    var fund_id: Int,

    @ColumnInfo(name = "user_id")
    var user_id: Int,

    @ColumnInfo(name = "debit_balance")
    var debit_balance: Int
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(fund_id)
        parcel.writeInt(user_id)
        parcel.writeInt(debit_balance)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FundEntity> {
        override fun createFromParcel(parcel: Parcel): FundEntity {
            return FundEntity(parcel)
        }

        override fun newArray(size: Int): Array<FundEntity?> {
            return arrayOfNulls(size)
        }
    }
}
