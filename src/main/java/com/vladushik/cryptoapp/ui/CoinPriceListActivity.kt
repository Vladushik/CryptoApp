package com.vladushik.cryptoapp.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.vladushik.cryptoapp.R
import com.vladushik.cryptoapp.adapters.CoinInfoAdapter
import com.vladushik.cryptoapp.pojo.CoinPriceInfo
import kotlinx.android.synthetic.main.activity_main.*


class CoinPriceListActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = CoinInfoAdapter(this)
        adapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener {
        override fun onCoinClick(coinPriceInfo: CoinPriceInfo) {
            val intent =
                CoinDetailActivity.newIntent(this@CoinPriceListActivity, coinPriceInfo.fromSymbol)
            startActivity(intent)
        }
    }


        recyclerViewCoinPriceList.adapter = adapter
        viewModel = ViewModelProviders.of(this)[CoinViewModel::class.java]
        viewModel.priceList.observe(this, Observer {
            adapter.coinInfoList = it
        })
    }
}
