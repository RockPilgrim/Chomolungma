package my.rockpilgrim.chomolungma.utils

import androidx.recyclerview.widget.DiffUtil
import my.rockpilgrim.chomolungma.data.User

class UserDiffCallback: DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.name == newItem.name || oldItem.phone == newItem.phone
    }
}