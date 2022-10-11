package com.haura.bittaqwaappmaster.menus.videokajian.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class VideoKajianModel(
    var thumbnail: Int = 0,
    var channel: String = "",
    var speaker: String = "",
    var title: String = "",
    var urlVideo: String = "",
    var summary: String = ""
) : Parcelable