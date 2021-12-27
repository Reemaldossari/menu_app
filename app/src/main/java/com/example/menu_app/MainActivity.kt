package com.example.menu_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.menu_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var islogin = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
//       setContentView(binding.root)
    }

    // this is fun for show menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.as_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.Contact_us -> return true
            R.id.Logout -> return true
            R.id.Setting -> return true
            R.id.login -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        var login = menu?.findItem(R.id.login)
        var logout =menu?.findItem(R.id.Logout)

        if (islogin) {
            islogin =!islogin
            login?.setVisible(true)
            logout?.setVisible(false)
        } else{
            islogin = !islogin
            login?.setVisible(false)
            logout?.setVisible(true)
        }
        return super.onPrepareOptionsMenu(menu)
    }

}