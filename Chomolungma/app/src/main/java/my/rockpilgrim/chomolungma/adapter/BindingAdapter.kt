package my.rockpilgrim.chomolungma.adapter

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso


@BindingAdapter("imageFromUrl")
fun setImage(view: ImageView, imageURL: String?) {
    if (!imageURL.isNullOrEmpty()) {
        Log.i("BindingAdapter", "Url: $imageURL")
        Picasso.get().load(imageURL).into(view)
    }
}