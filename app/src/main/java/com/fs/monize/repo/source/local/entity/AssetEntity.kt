package com.fs.monize.repo.source.local.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_asset")
data class AssetEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "asset_id")
    var asset_id: Int?,

    @ColumnInfo(name = "asset_name")
    var asset_name: String? = null,

    @ColumnInfo(name = "asset_desc")
    var asset_desc: String? = null,

    @ColumnInfo(name = "asset_icon")
    var asset_icon: String? = null,

    @ColumnInfo(name = "asset_balance")
    var asset_balance: Int

): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(asset_id)
        parcel.writeString(asset_name)
        parcel.writeString(asset_desc)
        parcel.writeString(asset_icon)
        parcel.writeInt(asset_balance)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AssetEntity> {
        override fun createFromParcel(parcel: Parcel): AssetEntity {
            return AssetEntity(parcel)
        }

        override fun newArray(size: Int): Array<AssetEntity?> {
            return arrayOfNulls(size)
        }
    }
}