package com.example.shophoa

import Adapter.Adapterquatang
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
import com.android.volley.Response.Listener
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.layout_quatang.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class Fragmentquatang:Fragment() {
    var idqt:Int = 0
    var page:Int =  6
    var arrayqua:ArrayList<tonghop> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View = inflater.inflate(R.layout.layout_quatang,container,false)
        var recyle1:RecyclerView = view.findViewById(R.id.recyclequatang)
        recyle1.setHasFixedSize(true)
        recyle1.layoutManager = GridLayoutManager(activity,2)
        Getdata(page)

        return view
    }

    private fun Getdata(Page:Int): HashMap<String, String> {
        var url = "http://192.168.56.1/service/getquatang.php?page="
        var duongdan:String = url + Page.toString()
        var queue1: RequestQueue = Volley.newRequestQueue(activity)
       var string2 = StringRequest(Request.Method.GET,duongdan,Response.Listener { response ->
           var jsonarraysp: JSONArray = JSONArray(response)
           if (response != null){
               for (i in 0..(jsonarraysp.length()-1)){
                   var jsonobject1: JSONObject = jsonarraysp.getJSONObject(i)
                   var id:Int = jsonobject1.getInt("id")
                   var tenqua: String = jsonobject1.getString("tenhoa")
                   var giaqua: Int = jsonobject1.getInt("giahoa")
                   var hinhqua: String = jsonobject1.getString("hinhhoa")
                   var idqua: Int = jsonobject1.getInt("idhoa")
                   arrayqua.add(tonghop(id,tenqua,giaqua,hinhqua,idqua))

               }
           }
           recyclequatang.adapter = Adapterquatang(activity!!,arrayqua)
       },Response.ErrorListener {  })
        queue1.add(string2)
          var hashmap= HashMap <String,String>()
            hashmap.put("idhoa",idqt.toString())
            return hashmap

    }
}