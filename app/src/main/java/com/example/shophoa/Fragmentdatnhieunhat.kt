package com.example.shophoa

import Adapter.Adapterchude
import Adapter.Adapterdatnhieunhat
import Model.Chude
import Model.tonghop
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.fragmentb.*
import kotlinx.android.synthetic.main.fragmentdatnhieunhat.*
import org.json.JSONArray
import org.json.JSONObject

class Fragmentdatnhieunhat: Fragment() {
    var arraydatnhieu:ArrayList<tonghop> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view1: View = inflater.inflate(R.layout.fragmentdatnhieunhat, container, false)
        var recycle1:RecyclerView = view1.findViewById(R.id.recyclecdatnhieu)
        recycle1.setHasFixedSize(true)
        recycle1.layoutManager = GridLayoutManager(activity,2)
        Getdata1()
        return view1
    }

    private fun Getdata1() {
        var url1 ="http://192.168.56.1/service/getloaihoamoinhat.php"
        var queue1: RequestQueue = Volley.newRequestQueue(activity)
        var string1 = StringRequest(Request.Method.GET,url1, Response.Listener { response ->
            var jsonarrayloaihoa: JSONArray = JSONArray(response)
            if (response != null) {
                for (i in 0..(jsonarrayloaihoa.length() - 1)) {
                    var jsonobjecthoa: JSONObject = jsonarrayloaihoa.getJSONObject(i)
                    var id: Int = jsonobjecthoa.getInt("id")
                    var ten: String = jsonobjecthoa.getString("tenhoa")
                    var gia:Int = jsonobjecthoa.getInt("giahoa")
                    var hinh: String = jsonobjecthoa.getString("hinhhoa")
                    var idhoa:Int = jsonobjecthoa.getInt("idhoa")
                    arraydatnhieu.add(tonghop(id,ten,gia,hinh,idhoa))
                }
            }
                recyclecdatnhieu.adapter = Adapterdatnhieunhat(activity!!,arraydatnhieu)
        }, Response.ErrorListener {  })
        queue1.add(string1)
    }

}
