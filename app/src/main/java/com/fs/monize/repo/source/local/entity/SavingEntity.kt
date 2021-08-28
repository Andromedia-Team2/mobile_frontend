package com.fs.monize.repo.source.local.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_saving")
data class SavingEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "saving_id")
    var saving_id: Int,

    @ColumnInfo(name = "user_id")
    var user_id: Int,

    @ColumnInfo(name = "asset_id")
    var asset_id: Int,

    @ColumnInfo(name = "date_save")
    var date_sav: String? = null,

    @ColumnInfo(name = "nominal_save")
    var nominal_sav: Int,

    @ColumnInfo(name = "desc_save")
    var desc_sav: String? = null
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
        parcel.writeInt(saving_id)
        parcel.writeInt(user_id)
        parcel.writeInt(asset_id)
        parcel.writeString(date_sav)
        parcel.writeInt(nominal_sav)
        parcel.writeString(desc_sav)
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
