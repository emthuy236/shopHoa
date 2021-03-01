package com.example.shophoa

import Adapter.Adapterchude
import Model.Chude
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
import org.json.JSONArray
import org.json.JSONObject

class FragmentB:Fragment() {
    var relist:ArrayList<Chude> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View = inflater.inflate(R.layout.fragmentb,container,false)

        var recycle:RecyclerView = view.findViewById(R.id.recyclechude)
        recycle.setHasFixedSize(true)
        recycle.layoutManager = GridLayoutManager(activity,3)
        Getdata()

        return view
//        recyclechude.setHasFixedSize(true)
//        recyclechude.layoutManager = GridLayoutManager(activity,3)
    }

    private fun Getdata() {
        var url ="http://192.168.56.1/service/getcacloaihoa.php"
        var queue: RequestQueue = Volley.newRequestQueue(activity)
        var string = StringRequest(Request.Method.GET,url, Response.Listener { response ->
            var jsonarrayloaihoa: JSONArray = JSONArray(response)
            if (response != null) {
                for (i in 0..(jsonarrayloaihoa.length() - 1)) {
                    var jsonobjecthoa: JSONObject = jsonarrayloaihoa.getJSONObject(i)
                    var id: Int = jsonobjecthoa.getInt("id")
                    var ten: String = jsonobjecthoa.getString("tenloaihoa")
                    var hinh: String = jsonobjecthoa.getString("hinhloaihoa")
                    relist.add(Chude(id, ten, hinh))
                }
            }
            recyclechude.adapter = Adapterchude(activity!!,relist)
        }, Response.ErrorListener {  })
        queue.add(string)
    }
}