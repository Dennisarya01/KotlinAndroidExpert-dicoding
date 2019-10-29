package com.dicoding.footballapps.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataModel (val image: Int?, val nameClub: String?, val descClub: String?) : Parcelable