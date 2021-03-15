package com.vladushik.cryptoapp.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.vladushik.cryptoapp.pojo.Datum

data class CoinInfoListOfData (
        @SerializedName("Data")
        @Expose
        val data: List<Datum>? = null
)