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

class Adapterdatnhieunhat(var context:Context,var mangdatnhieu:ArrayList<tonghop>):RecyclerView.Adapter<Adapterdatnhieunhat.ItemHolder>() {
    inner class ItemHolder(itemview: View): RecyclerView.ViewHolder(itemview) {
        var namehoa: TextView
        var giahoa: TextView
        var hinhhoa: ImageView

        init {
            namehoa = itemview.findViewById(R.id.txtendatnhieu)
            giahoa = itemview.findViewById(R.id.giadatnhieu)
            hinhhoa = itemview.findViewById(R.id.imgdatnhieu)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        var view:View = LayoutInflater.from(context).inflate(R.layout.custom_hoadatnhieunhat,null)
        var item:ItemHolder = ItemHolder(view)
        return item
    }

    override fun getItemCount(): Int {
        return  mangdatnhieu.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var tonghopdu:tonghop = mangdatnhieu.get(position)
        holder.namehoa.setText(tonghopdu.tenhoa)
        var decimal:DecimalFormat = DecimalFormat("###,###,###")
        holder.giahoa.setText("Giá: " + decimal.format(tonghopdu.giahoa).replace(",",".") + " đ ")
        Picasso.with(context).load(tonghopdu.hinhhoa).into(holder.hinhhoa)
    }
}