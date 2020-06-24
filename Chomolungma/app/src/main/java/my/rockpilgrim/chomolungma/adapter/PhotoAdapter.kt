package my.rockpilgrim.chomolungma.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import my.rockpilgrim.chomolungma.data.Photo
import my.rockpilgrim.chomolungma.databinding.PhotoItemBinding
import my.rockpilgrim.chomolungma.ui.AViewHolder
import my.rockpilgrim.chomolungma.utils.PhotoDiffCallback

class PhotoAdapter :
    ListAdapter<Photo, PhotoAdapter.PhotoViewHolder>(PhotoDiffCallback()) {

    companion object{
        const val USER: Int = 0
        const val PHOTO: Int = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
            return PhotoViewHolder(
                PhotoItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false))

    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PhotoViewHolder(private val binding: PhotoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: Photo) {
            binding.photo = user
        }
    }
}