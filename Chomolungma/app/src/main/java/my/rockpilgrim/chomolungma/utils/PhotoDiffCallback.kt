package my.rockpilgrim.chomolungma.utils

import androidx.recyclerview.widget.DiffUtil
import my.rockpilgrim.chomolungma.data.Photo
import my.rockpilgrim.chomolungma.data.User

class PhotoDiffCallback: DiffUtil.ItemCallback<Photo>() {
    override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem.title == newItem.title || oldItem.url == newItem.url
    }
}