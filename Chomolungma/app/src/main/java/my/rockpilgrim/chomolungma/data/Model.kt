package my.rockpilgrim.chomolungma.data

import my.rockpilgrim.chomolungma.api.ConnectAsyncTask

object Model {

    private var muUsers: MutableList<User> = mutableListOf()
    var users: List<User> = muUsers

    init {
/*        for (i: Int in 0 until 10) {
            muUsers.add(User(i, "User Name: ${i + 1}", "Lorem, ipsum $i tral lala lala"))
        }*/
        users = ConnectAsyncTask().execute().get()
    }

}