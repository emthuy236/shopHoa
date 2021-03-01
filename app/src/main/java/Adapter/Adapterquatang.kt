package Adapter

import Model.tonghop
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shophoa.R
import com.squareup.picasso.Picasso
import java.text.DecimalFormat

class Adapterquatang(var context: Context, var mangqua:ArrayList<tonghop>):RecyclerView.Adapter<Adapterquatang.ItemHolder>() {
    inner class ItemHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var namequa: TextView
        var giaqua: TextView
        var hinhqua: ImageView

        init {
            namequa = itemview.findViewById(R.id.txtenqua)
            giaqua = itemview.findViewById(R.id.giaqua)
            hinhqua = itemview.findViewById(R.id.imgqua)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        var view:View = LayoutInflater.from(context).inflate(R.layout.custom_quatang,null)
        var item:ItemHolder = ItemHolder(view)
        return item
    }

    override fun getItemCount(): Int {
        return mangqua.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var tongHop:tonghop = mangqua.get(position)
        holder.namequa.setText(tongHop.tenhoa)
        var decimal: DecimalFormat = DecimalFormat("###,###,###")
        holder.giaqua.setText("Giá: " + decimal.format(tongHop.giahoa).replace(",",".") + " đ ")
        Picasso.with(context).load(tongHop.hinhhoa).into(holder.hinhqua)
    }
}