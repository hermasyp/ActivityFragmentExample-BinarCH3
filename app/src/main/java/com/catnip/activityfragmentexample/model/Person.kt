package com.catnip.activityfragmentexample.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.UUID

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
@Parcelize
data class Person(
    val id : String = UUID.randomUUID().toString(),
    val name : String,
    val job: String,
    val profileDesc : String,
    val profilePictUrl : String
) : Parcelable
