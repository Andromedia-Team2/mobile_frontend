package com.fs.monize.repo.source.local.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_fund")
data class FundEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "fund_id")
    var fund_id: Int?,

    @ColumnInfo(name = "fund_balance")
    var fund_balance: Int,

    @ColumnInfo(name = "credit_balance")
    var credit_balance: Int,

    @ColumnInfo(name = "debit_balance")
    var debit_balance: Int

): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(fund_id)
        parcel.writeInt(fund_balance)
        parcel.writeInt(credit_balance)
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