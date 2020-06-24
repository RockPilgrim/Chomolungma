package my.rockpilgrim.chomolungma.api

import android.os.HandlerThread
import android.util.Log

class ImageDownloader<T> : HandlerThread(TAG) {

    companion object{
        private const val TAG = "ImageDownloader"
    }
    private var hasQuit = false

    override fun quit(): Boolean {
        hasQuit = true
        return super.quit()
    }

    fun queueImage(target: T, url: String) {
        Log.i(TAG, "URL = $url")
    }
}