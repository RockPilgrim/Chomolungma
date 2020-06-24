package my.rockpilgrim.chomolungma.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import my.rockpilgrim.chomolungma.data.User

abstract class AViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(user: User)
}