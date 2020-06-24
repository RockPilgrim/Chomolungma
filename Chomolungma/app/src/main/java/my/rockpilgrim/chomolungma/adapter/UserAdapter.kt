package my.rockpilgrim.chomolungma.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import my.rockpilgrim.chomolungma.R
import my.rockpilgrim.chomolungma.data.User
import my.rockpilgrim.chomolungma.databinding.PhotoItemBinding
import my.rockpilgrim.chomolungma.databinding.UserItemBinding
import my.rockpilgrim.chomolungma.ui.AViewHolder
import my.rockpilgrim.chomolungma.ui.UsersListFragmentDirections
import my.rockpilgrim.chomolungma.utils.UserDiffCallback

class UserAdapter(private val itemType: Int) :
    ListAdapter<User, AViewHolder>(UserDiffCallback()) {

    companion object{
        const val USER: Int = 0
        const val PHOTO: Int = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AViewHolder {
            return UserViewHolder(
                UserItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: AViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class UserViewHolder(private val binding: UserItemBinding) : AViewHolder(binding.root) {
        override fun bind(user: User) {
            binding.user=user
            binding.userContainer.setOnClickListener {
                val direction: NavDirections =
                    UsersListFragmentDirections.actionUsersListFragmentToPhotosListFragment(adapterPosition)
                it.findNavController().navigate(direction)
            }
        }
    }
}