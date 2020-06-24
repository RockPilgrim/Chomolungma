package my.rockpilgrim.chomolungma.data

data class User(
    val id: Int,
    val name: String,
    val phone: String
){
    var albums: List<Album> = listOf()

    fun getAllPhotos(): List<Photo> {
        val photos = mutableListOf<Photo>()
        for (i in albums.indices) {
            photos.addAll(albums[i].photos)
        }
        return photos
    }
}