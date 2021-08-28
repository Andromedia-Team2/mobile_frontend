package com.fs.monize.repo.source.local.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_limit_board")
data class LimitBoardEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "limit_id")
    var limit_id: Int,

    @ColumnInfo(name = "limit_nominal")
    var limit_nominal: Int,

    @ColumnInfo(name = "limit_date")
    var limit_date: String? = null,

    @ColumnInfo(name = "limit_desc")
    var limit_desc: String? = null
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(limit_id)
        parcel.writeInt(limit_nominal)
        parcel.writeString(limit_date)
        parcel.writeString(limit_desc)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LimitBoardEntity> {
        override fun createFromParcel(parcel: Parcel): LimitBoardEntity {
            return LimitBoardEntity(parcel)
        }

        override fun newArray(size: Int): Array<LimitBoardEntity?> {
            return arrayOfNulls(size)
        }
    }
}
