package com.fs.monize.ui.activity.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fs.monize.databinding.ItemSavingBinding
import com.fs.monize.databinding.ItemTransactionBinding
import com.fs.monize.repo.source.local.entity.SavingEntity
import com.fs.monize.repo.source.local.entity.TransactionEntity

class SavingAdapter(private val listData: List<SavingEntity>): RecyclerView.Adapter<SavingAdapter.myViewHolder>()  {
    class myViewHolder(private val binding: ItemSavingBinding): RecyclerView.ViewHolder(binding.root)  {
        fun bind(items: SavingEntity, context: Context) {
            with(binding) {
                val target = items.saving_nominal - items.saving_balance
                savingName.text = items.saving_name
                savingDesc.text = target.toString() + "Untuk Mencapai tujuan"
                savingPb.progress = 50
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val binding = ItemSavingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return myViewHolder(binding)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.bind(listData[position], holder.itemView.context)
    }

    override fun getItemCount(): Int = listData.size
}