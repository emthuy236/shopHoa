package com.example.shophoa

import android.os.Build
import android.os.Bundle
import android.view.*
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toolbar
import android.widget.ViewFlipper
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.frangment_manchinh.*

class FrangmentManchinh:Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View = inflater.inflate(R.layout.frangment_manchinh,container,false)
        var fragmentb:FragmentB = FragmentB()
        var fragmentdatnhieu:Fragmentdatnhieunhat = Fragmentdatnhieunhat()
        fragmentManager?.beginTransaction()!!.add(R.id.linear1,fragmentb)
            .add(R.id.linear2,fragmentdatnhieu).commit()

//        toolmain.setNavigationIcon(R.drawable.ic_menu_black_24dp)
        var viewflip:ViewFlipper = view.findViewById(R.id.viewflipmain)
        var arayflip:ArrayList<String> = ArrayList()
        arayflip.add("https://dc.flowercorner.vn/uploads/P5e96c8bb2b2b41.37148554_e2ce4a04ee04085a5115.webp")
        arayflip.add("https://dc.flowercorner.vn/uploads/P5e97abb1964543.59864565_FC50.png")
        arayflip.add("https://dc.flowercorner.vn/uploads/P5e96c9354c4ed1.47800880_dbb355a5ae134a4d1302.webp")
        arayflip.add("https://dc.flowercorner.vn/uploads/P5e97aacbf0f4a3.48146075_Freeshipping_2020_4.png")
        arayflip.add("https://dc.flowercorner.vn/uploads/P5e97abc2053cf5.06194803_HappyFriday.png")
        for (i in 0..(arayflip.size - 1)){
            var img: ImageView = ImageView(activity)
            Picasso.with(activity).load(arayflip.get(i)).into(img)
            img.scaleType = ImageView.ScaleType.CENTER_CROP
            viewflip.addView(img)
        }
        viewflip.isAutoStart = true
        viewflip.flipInterval = 5000
        var animin: Animation = AnimationUtils.loadAnimation(activity,R.anim.anim_in)
        var animout: Animation = AnimationUtils.loadAnimation(activity,R.anim.anim_out)
        viewflip.setInAnimation(animin)
        viewflip.setOutAnimation(animout)
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.menu_header,menu)

        return super.onCreateOptionsMenu(menu, inflater)
    }


}