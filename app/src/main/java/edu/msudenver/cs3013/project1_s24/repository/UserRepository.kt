package edu.msudenver.cs3013.project1_s24.repository

data class User(val username: String, val password: String)

class UserRepository {
    private var user: User? = null

    fun getUser(): User? {
        return user
    }

    fun saveUser(username: String, password: String) {
        user = User(username, password)
    }
}
