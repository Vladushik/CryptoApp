package com.vladushik.cryptoapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.vladushik.cryptoapp.R

import com.vladushik.cryptoapp.pojo.CoinPriceInfo
import kotlinx.android.synthetic.main.item_coin.view.*

class CoinInfoAdapter(private val context: Context) : RecyclerView.Adapter<CoinInfoAdapter.CoinInfoViewHolder>() {

    var coinInfoList: List<CoinPriceInfo> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onCoinClickListener: OnCoinClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder {
        val view =            LayoutInflater.from(parent.context).inflate(R.layout.item_coin, parent, false)
        return CoinInfoViewHolder(view)
    }

    override fun getItemCount() = coinInfoList.size

    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        val coin = coinInfoList.get(position)
        holder.tvSymbols.text = coin.fromSymbol + " / " + coin.toSymbol
        holder.tvPrice.text = coin.price
        holder.tvLastUpdate.text ="Last update: " +  coin.getFormattedTime()
        Picasso.get().load(coin.getFullImageUrl()).into(holder.ivLogoCoin)

        holder.itemView.setOnClickListener {
            onCoinClickListener?.onCoinClick(coin)
        }

    }

    inner class CoinInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivLogoCoin = itemView.ivLogoCoin
        val tvSymbols = itemView.tvSymbols
        val tvPrice = itemView.tvPrice
        val tvLastUpdate = itemView.tvLastUpdate
    }

    interface OnCoinClickListener {
        fun onCoinClick(coinPriceInfo: CoinPriceInfo)
    }
}