package com.fs.monize.ui.activity.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fs.monize.R
import com.fs.monize.databinding.ItemTransactionBinding
import com.fs.monize.repo.source.local.entity.TransactionEntity

class TransactionAdapter(private val listData: List<TransactionEntity>): RecyclerView.Adapter<TransactionAdapter.myViewHolder>() {
    class myViewHolder(private val binding: ItemTransactionBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(items: TransactionEntity, context: Context){
            with(binding){
                transName.text = items.transaction_name
                transDesc.text = items.transaction_desc
                transDate.text = items.transaction_date
                when (items.transaction_icon) {
                    "ikon_pin" -> {
                        Glide.with(context).load(context.resources.getDrawable(R.drawable.ikon_chart))
                            .apply(RequestOptions().override(250, 250))
                            .into(transIcon)
                    }
                    "ikon_call" -> {
                        Glide.with(context).load(context.resources.getDrawable(R.drawable.ikon_call))
                            .apply(RequestOptions().override(250, 250))
                            .into(transIcon)
                    }
                    "ikon_tools" -> {
                        Glide.with(context).load(context.resources.getDrawable(R.drawable.ikon_tools))
                            .apply(RequestOptions().override(250, 250))
                            .into(transIcon)
                    }
                    "ikon_music" -> {
                        Glide.with(context).load(context.resources.getDrawable(R.drawable.ikon_music))
                            .apply(RequestOptions().override(250, 250))
                            .into(transIcon)
                    }
                    "ikon_car" -> {
                        Glide.with(context).load(context.resources.getDrawable(R.drawable.ikon_car))
                            .apply(RequestOptions().override(250, 250))
                            .into(transIcon)
                    }
                    "ikon_movie" -> {
                        Glide.with(context).load(context.resources.getDrawable(R.drawable.ikon_movie))
                            .apply(RequestOptions().override(250, 250))
                            .into(transIcon)
                    }
                    "ikon_chart" -> {
                        Glide.with(context).load(context.resources.getDrawable(R.drawable.ikon_chart))
                            .apply(RequestOptions().override(250, 250))
                            .into(transIcon)
                    }
                    "ikon_electric" -> {
                        Glide.with(context).load(context.resources.getDrawable(R.drawable.ikon_electric))
                            .apply(RequestOptions().override(250, 250))
                            .into(transIcon)
                    }
                    "ikon_phone" -> {
                        Glide.with(context).load(context.resources.getDrawable(R.drawable.ikon_phone))
                            .apply(RequestOptions().override(250, 250))
                            .into(transIcon)
                    }
                    "ikon_computer" -> {
                        Glide.with(context).load(context.resources.getDrawable(R.drawable.ikon_computer))
                            .apply(RequestOptions().override(250, 250))
                            .into(transIcon)
                    }
                    "ikon_camera" -> {
                        Glide.with(context).load(context.resources.getDrawable(R.drawable.ikon_call))
                            .apply(RequestOptions().override(250, 250))
                            .into(transIcon)
                    }
                }
                if (items.transaction_category == "income"){
                    transIcon.isSelected = true
                    transNominal.text = "Rp. "+items.transaction_nominal.toString()+".-"
                }else{
                    transIcon.isSelected = false
                    transNominal.text = "Rp.  -"+items.transaction_nominal.toString()+".-"
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionAdapter.myViewHolder {
        val binding = ItemTransactionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return myViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransactionAdapter.myViewHolder, position: Int) {
        holder.bind(listData[position], holder.itemView.context)
    }

    override fun getItemCount(): Int = listData.size
}