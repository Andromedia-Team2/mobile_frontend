package com.fs.monize.repo.source.local.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_transaction")
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "transaction_id")
    var transaction_id: Int?,

    @ColumnInfo(name = "transaction_name")
    var transaction_name: String? = null,

    @ColumnInfo(name = "transaction_nominal")
    var transaction_nominal: Int,

    @ColumnInfo(name = "transaction_desc")
    var transaction_desc: String? = null,

    @ColumnInfo(name = "transaction_date")
    var transaction_date: String? = null,

    @ColumnInfo(name = "transaction_icon")
    var transaction_icon: String? = null,

    @ColumnInfo(name = "transaction_category")
    var transaction_category: String? = null
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(transaction_id)
        parcel.writeString(transaction_name)
        parcel.writeInt(transaction_nominal)
        parcel.writeString(transaction_desc)
        parcel.writeString(transaction_date)
        parcel.writeString(transaction_icon)
        parcel.writeString(transaction_category)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TransactionEntity> {
        override fun createFromParcel(parcel: Parcel): TransactionEntity {
            return TransactionEntity(parcel)
        }

        override fun newArray(size: Int): Array<TransactionEntity?> {
            return arrayOfNulls(size)
        }
    }
}