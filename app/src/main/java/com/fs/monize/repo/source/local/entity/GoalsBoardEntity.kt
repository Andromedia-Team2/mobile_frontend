package com.fs.monize.repo.source.local.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.*

@Entity(tableName = "tbl_goals_board",
    primaryKeys = ["goals_id", "user_id"],
    foreignKeys = [ForeignKey(entity = UserEntity::class,
        parentColumns = ["user_id"],
        childColumns = ["user_id"])],
    indices = [Index(value = ["goals_id"]),
        Index(value = ["user_id"])])
data class GoalsBoardEntity(
    @NonNull
    @ColumnInfo(name = "goals_id")
    var goals_id: Int,

    @ColumnInfo(name = "user_id")
    var user_id: Int,

    @ColumnInfo(name = "goals_name")
    var goals_name: String? = null,

    @ColumnInfo(name = "goals_date")
    var goals_date: String? = null,

    @ColumnInfo(name = "goals_nominal")
    var goals_nominal: Int,

    @ColumnInfo(name = "goals_balance")
    var goals_balance: Int
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(goals_id)
        parcel.writeInt(user_id)
        parcel.writeString(goals_name)
        parcel.writeString(goals_date)
        parcel.writeInt(goals_nominal)
        parcel.writeInt(goals_balance)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GoalsBoardEntity> {
        override fun createFromParcel(parcel: Parcel): GoalsBoardEntity {
            return GoalsBoardEntity(parcel)
        }

        override fun newArray(size: Int): Array<GoalsBoardEntity?> {
            return arrayOfNulls(size)
        }
    }
}
