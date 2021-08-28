package com.fs.monize.repo.source.local.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_score_board")
data class ScoreBoardEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "score_id")
    var score_id: Int,

    @ColumnInfo(name = "limit_id")
    var limit_id: Int,

    @ColumnInfo(name = "score_value")
    var score_value: Int,

    @ColumnInfo(name = "score_desc")
    var score_desc: String? = null
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(score_id)
        parcel.writeInt(limit_id)
        parcel.writeInt(score_value)
        parcel.writeString(score_desc)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ScoreBoardEntity> {
        override fun createFromParcel(parcel: Parcel): ScoreBoardEntity {
            return ScoreBoardEntity(parcel)
        }

        override fun newArray(size: Int): Array<ScoreBoardEntity?> {
            return arrayOfNulls(size)
        }
    }
}
