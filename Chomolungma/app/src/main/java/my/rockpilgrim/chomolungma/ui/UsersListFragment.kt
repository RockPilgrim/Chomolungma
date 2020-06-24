package my.rockpilgrim.chomolungma.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import my.rockpilgrim.chomolungma.adapter.UserAdapter
import my.rockpilgrim.chomolungma.data.Model
import my.rockpilgrim.chomolungma.data.User
import my.rockpilgrim.chomolungma.databinding.UsersFragmentBinding

class UsersListFragment : Fragment() {

    companion object{
        const val TAG = "UsersListFragment"
    }

    private lateinit var users: List<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        users = Model.users
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate()")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = UsersFragmentBinding.inflate(inflater, container, false)
        binding.userRecycler.adapter = UserAdapter(UserAdapter.USER).apply { submitList(users) }
        return binding.root
    }

}