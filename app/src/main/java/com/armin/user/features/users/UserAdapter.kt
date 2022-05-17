package com.armin.user.features.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.armin.user.R
import com.armin.user.data.UserItem
import com.armin.user.databinding.UserItemBinding
import com.bumptech.glide.Glide


class UserAdapter : ListAdapter<UserItem, UserAdapter.UserViewHolder>(UserComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding =
            UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class UserViewHolder(private val binding: UserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(User: UserItem) {
            binding.apply {
                    Glide.with(itemView)
                        .load(User.image)
                        .into(imageViewLogo)

                textViewName.text = User.firstName
                textViewType.text = User.lastName
                textViewAddress.text = User._id
            }
        }
    }

    class UserComparator : DiffUtil.ItemCallback<UserItem>() {
        override fun areItemsTheSame(oldItem: UserItem, newItem: UserItem) =
            oldItem._id == newItem._id

        override fun areContentsTheSame(oldItem: UserItem, newItem: UserItem) =
            oldItem == newItem
    }
}
