package com.example.shophoa

import Adapter.Adapterchude
import Model.Chude
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navgibot.setOnNavigationItemSelectedListener { menuItem ->
            var fragmentt:Fragment? = null
            when(menuItem.itemId){
                R.id.nv_home -> {
                    fragmentt = FrangmentManchinh()
                }
                R.id.nv_menu -> {
                    fragmentt = FragmentExpand()
                }
                R.id.nv_udai -> {
                    fragmentt = Fragmentquatang()
                }
                R.id.nv_account ->{
                    fragmentt = FragmentAccount()
                }
            }
            supportFragmentManager.beginTransaction().replace(R.id.frangmentcontainer,fragmentt!!).commit()
                 return@setOnNavigationItemSelectedListener true
        }









    }










}
