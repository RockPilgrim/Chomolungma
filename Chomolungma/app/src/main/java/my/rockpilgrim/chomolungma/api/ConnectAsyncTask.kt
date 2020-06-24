package my.rockpilgrim.chomolungma.api

import android.os.AsyncTask
import my.rockpilgrim.chomolungma.data.User

class ConnectAsyncTask : AsyncTask<Any, Any, List<User>>() {

    companion object{
        private val TAG = ConnectAsyncTask::class.java.simpleName
    }

    override fun doInBackground(vararg params: Any?): List<User> {
        return ConnectionUserPhoto().userItems()
    }
}