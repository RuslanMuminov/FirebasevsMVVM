package com.example.firebasevsmvvm.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasevsmvvm.databinding.ComputersItemBinding
import com.example.firebasevsmvvm.model.ComputersModel

class ComputersAdapter : RecyclerView.Adapter<ComputersAdapter.VH>() {

    private val itemCallback = object : DiffUtil.ItemCallback<ComputersModel>() {
        override fun areItemsTheSame(oldItem: ComputersModel, newItem: ComputersModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ComputersModel, newItem: ComputersModel): Boolean {
            return oldItem.model == newItem.model
        }

    }
    val differ = AsyncListDiffer(this, itemCallback)

    class VH(private val binding: ComputersItemBinding):RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(computersModel: ComputersModel) {
            binding.textContent.text =
                computersModel.model.toString() + "\n" +
                computersModel.processor.toString() + "\n" +
                computersModel.display.toString() + "\n" +
                computersModel.ram.toString() + "\n" +
                computersModel.memory.toString() + "\n" +
                computersModel.videocard.toString() + "\n" +
                computersModel.battery.toString() + "\n" +
                computersModel.price.toString() + "\n" +
                computersModel.phone.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ComputersItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size
}