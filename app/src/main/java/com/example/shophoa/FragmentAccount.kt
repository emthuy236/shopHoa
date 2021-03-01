package com.example.shophoa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.fragment.app.Fragment

class FragmentAccount:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View = inflater.inflate(R.layout.layout_account,container,false)
        var img:ImageButton = view.findViewById(R.id.imgexit)

        img.setOnClickListener {

            var fragment:FrangmentManchinh = FrangmentManchinh()
            fragmentManager?.beginTransaction()!!.replace(R.id.frangmentcontainer,fragment).commit()
        }
        return view
    }
}