package my.rockpilgrim.chomolungma.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import my.rockpilgrim.chomolungma.adapter.PhotoAdapter
import my.rockpilgrim.chomolungma.data.Model
import my.rockpilgrim.chomolungma.data.Photo
import my.rockpilgrim.chomolungma.data.User
import my.rockpilgrim.chomolungma.databinding.PhotosFragmentBinding

class PhotosListFragment : Fragment() {

    companion object{
        const val TAG = "PhotosListFragment"
    }

    private lateinit var photos: List<Photo>

    override fun onCreate(savedInstanceState: Bundle?) {
        val id = requireArguments().getInt("position")
        photos = Model.users[id].getAllPhotos()
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate()")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = PhotosFragmentBinding.inflate(inflater, container, false)
        binding.photoRecycler.adapter = PhotoAdapter().apply { submitList(photos) }
        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root
    }

}