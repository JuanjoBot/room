package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.room.database.DatabaseManager
import com.example.room.database.User

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mainViewModel.saveUser(User(
            "JJ001",
            "jj001",
            1.71,
            71.1,
            "jj001@gmail.com",
            "password123"
        ))

        mainViewModel.getUsers()
        mainViewModel.savedUsers.observe(this) { usersList ->
            if (!usersList.isNullOrEmpty()){
                for(user in usersList){
                    Log.d("thesearetheusers", user.user_name)
                }

            }else{
                Log.d("thesearetheusers", "null or empty")
            }
        }
    }
}