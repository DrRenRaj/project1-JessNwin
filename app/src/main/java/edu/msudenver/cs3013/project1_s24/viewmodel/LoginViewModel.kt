package edu.msudenver.cs3013.project1_s24.viewmodel

import androidx.lifecycle.ViewModel
import edu.msudenver.cs3013.project1_s24.repository.UserRepository

class LoginViewModel(private val userRepository: UserRepository) : ViewModel() {
    fun login(username: String, password: String): Boolean {
        val user = userRepository.getUser()
        return user?.username == username && user.password == password
    }

    fun signup(username: String, password: String) {
        userRepository.saveUser(username, password)
    }
}
