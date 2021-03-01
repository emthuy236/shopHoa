package Adapter

import Model.Chude
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shophoa.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.custom_chude.view.*

class Adapterchude(var context:Context,var mangloaihoa:ArrayList<Chude>):RecyclerView.Adapter<Adapterchude.ItemHolder>() {
    inner class ItemHolder(itemview:View):RecyclerView.ViewHolder(itemview){
        var namehoa:TextView
        var hinhhoa:ImageView
        init {
            namehoa = itemview.findViewById(R.id.txttenloai)
            hinhhoa = itemview.findViewById(R.id.imgchude)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
       var view:View = LayoutInflater.from(context).inflate(R.layout.custom_chude,null)
      var item:ItemHolder = ItemHolder(view)
        return item
    }

    override fun getItemCount(): Int {
        return mangloaihoa.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var chude:Chude = mangloaihoa.get(position)
        holder.namehoa.setText(chude.tenloaihoa)
        Picasso.with(context).load(chude.hinhloaihoa).into(holder.hinhhoa)
    }
}