package com.vladushik.cryptoapp.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.vladushik.cryptoapp.pojo.CoinInfo

data class Datum (
        @SerializedName("CoinInfo")
        @Expose
        val coinInfo: CoinInfo? = null
)