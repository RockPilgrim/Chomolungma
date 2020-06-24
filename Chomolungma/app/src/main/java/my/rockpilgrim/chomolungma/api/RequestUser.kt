package my.rockpilgrim.chomolungma.api

import android.os.AsyncTask
import android.util.Log
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.Charset

class RequestUser: AsyncTask<String, String, String>() {

    companion object{
        private val TAG = RequestUser::class.java.simpleName
    }

    override fun doInBackground(vararg params: String?): String? {
        var result: String?=null
        var connection: HttpURLConnection? = null
        try {
            var url: URL = URL("https://jsonplaceholder.typicode.com/users")
            connection = url.openConnection() as HttpURLConnection
            connection.connect()
            result = InputStreamReader(connection.inputStream, Charset.defaultCharset()).toString()
            Log.d(TAG, "doInBackground() result = $result")

        } catch (e: IOException) {
            Log.e(TAG, "Error", e)
        }finally {
            connection?.disconnect()
        }
        return result
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)

    }
}