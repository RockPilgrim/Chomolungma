package my.rockpilgrim.chomolungma.data

data class Album(
    val id: Int
){
    var photos: List<Photo> = listOf()
}