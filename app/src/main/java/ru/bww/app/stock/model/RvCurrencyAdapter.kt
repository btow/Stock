package ru.bww.app.stock.model

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.bww.app.stock.R


class RvCurrencyAdapter(val list: ArrayList<ReqwestCurrency>?) : RecyclerView.Adapter<RvCurrencyAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName?.text = list!![position].name
        holder.tvVolume?.text = list[position].volume.toString()
        holder.tvAmount?.text = String.format("%.2f", list[position].amount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvName = itemView.findViewById<TextView>(R.id.tvRvCurrencyName)
        val tvVolume = itemView.findViewById<TextView>(R.id.tvRvCurrencyVolume)
        val tvAmount = itemView.findViewById<TextView>(R.id.tvRvCurrencyAmount)
    }
}
