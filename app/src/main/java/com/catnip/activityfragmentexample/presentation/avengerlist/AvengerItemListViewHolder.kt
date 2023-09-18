package com.catnip.activityfragmentexample.presentation.avengerlist

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.catnip.activityfragmentexample.databinding.ItemListAvengersBinding
import com.catnip.activityfragmentexample.model.Person

class AvengerItemListViewHolder(
    private val binding: ItemListAvengersBinding,
    private val onItemClick: (Person) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Person) {
        binding.root.setOnClickListener {
            onItemClick.invoke(item)
        }
        binding.ivProfileImg.load(item.profilePictUrl)
        binding.tvName.text = item.name
    }
}