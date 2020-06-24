package my.rockpilgrim.chomolungma.api

import android.util.Log
import my.rockpilgrim.chomolungma.data.Album
import my.rockpilgrim.chomolungma.data.Photo
import my.rockpilgrim.chomolungma.data.User
import org.json.JSONArray
import org.json.JSONException
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class ConnectionUserPhoto {

    companion object{
        private val TAG = ConnectionUserPhoto::class.java.simpleName
    }


    private fun getUrlBytes(urlSpec: String): ByteArray {
        val url: URL = URL(urlSpec)
        val connection: HttpURLConnection = url.openConnection() as HttpURLConnection

        try {
            val out: ByteArrayOutputStream = ByteArrayOutputStream()
            val input: InputStream = connection.inputStream
            if (connection.responseCode != HttpURLConnection.HTTP_OK) {
                throw IOException(connection.responseMessage)
            }
            var bytesRead: Int = 0
            val buffer: ByteArray = ByteArray(1024)
            bytesRead = input.read(buffer)
            Log.d(TAG, "input: $bytesRead")
            while ((bytesRead) > 0) {
                out.write(buffer, 0, bytesRead)
                bytesRead = input.read(buffer)
            }
            out.close()
            return out.toByteArray()
        }finally {
            connection.disconnect()
        }
    }

    private fun getUrlString(urlSpec: String): String {
        return String(getUrlBytes(urlSpec))
    }

    fun userItems(): List<User> {
        val users = mutableListOf<User>()
        val urlUser = "https://jsonplaceholder.typicode.com/users"
        val urlAlbum = "https://jsonplaceholder.typicode.com/albums"
        val urlPhoto = "https://jsonplaceholder.typicode.com/photos"
        parseItems(users, userItems(urlUser)!!, userItems(urlAlbum)!!, userItems(urlPhoto)!!)
        return users
    }

    private fun userItems(url: String): JSONArray? {
        val users = mutableListOf<User>()
        try {
            val jsonString = getUrlString(url)
            Log.i(TAG, "Received JSON: $jsonString")
            val jsonArr: JSONArray = JSONArray(jsonString)
            return jsonArr

        } catch (ioe: IOException) {
            Log.e(TAG, "Failed to get items", ioe)
        } catch (je: JSONException) {
            Log.e(TAG, "Failed to parse JSON", je)
        }
        return null
    }

    private fun parseItems(users: MutableList<User>, jsonArr: JSONArray) {

        for (i in 0 until jsonArr.length()) {
            val userJSON = jsonArr.getJSONObject(i)
            val user: User = User(
                userJSON.getString("id").toInt(),
                userJSON.getString("name"),
                userJSON.getString("phone"))
            users.add(user)
        }
    }
    private fun parseItems(
        users: MutableList<User>,
        jsonUserArr: JSONArray,
        jsonAlbumArr: JSONArray,
        jsonPhotoArr: JSONArray
    ) {
        for (u in 0 until jsonUserArr.length()) {
            val userJSON = jsonUserArr.getJSONObject(u)
            val user: User = User(
                userJSON.getInt("id"),
                userJSON.getString("name"),
                userJSON.getString("phone")
            )
            val albums = mutableListOf<Album>()
            for (a in 0 until jsonAlbumArr.length()) {
                val albumJSON = jsonAlbumArr.getJSONObject(a)
                if (albumJSON.getInt("userId") == user.id) {
                    val album = Album(
                        albumJSON.getInt("id")
                    )
                    val photos = mutableListOf<Photo>()
                    for (ph in 0 until jsonPhotoArr.length()) {
                        val photoJSON = jsonPhotoArr.getJSONObject(ph)
                        if (photoJSON.getInt("albumId") == album.id) {
                            val photo = Photo(
                                photoJSON.getInt("id"),
                                photoJSON.getString("title"),
                                photoJSON.getString("url"))
                            photos.add(photo)
                        }

                    }
                    album.photos = photos
                    albums.add(album)
                }
            }
            user.albums = albums
            users.add(user)
        }
    }

}