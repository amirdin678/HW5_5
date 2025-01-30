package com.example.hw5_m5.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil3.load
import com.example.hw5_m5.data.model.CharacterEntity
import com.example.hw5_m5.databinding.CharacterItemBinding
import com.example.hw5_m5.ui.fragment.character.CharactersViewModel
import com.example.hw5_m5.utils.ImageUtils
import com.example.hw5_m5.utils.OnItemClick

class HistoryAdapter(
    private val viewModel: CharactersViewModel,
    private val onClick: OnItemClick
) : ListAdapter<CharacterEntity, HistoryAdapter.ViewHolder>(DiffCallback()) {

    class ViewHolder(
        private val binding: CharacterItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CharacterEntity) {
            val bitmap = ImageUtils.base64ToBitmap(item.imageBase64 ?: "")
            binding.apply {
                name.text = item.name
                status.text = item.status
                species.text = item.species
                location.text = item.location
                firstSeen.text = item.firstEpisodeName
                imageView.load(bitmap)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener {
            onClick.onItemClick(item)
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<CharacterEntity>() {
        override fun areItemsTheSame(oldItem: CharacterEntity, newItem: CharacterEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CharacterEntity, newItem: CharacterEntity): Boolean {
            return oldItem == newItem
        }
    }
}
