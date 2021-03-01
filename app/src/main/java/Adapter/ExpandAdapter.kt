package Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.TextView
import android.widget.Toast
import com.example.shophoa.R

class ExpandAdapter(var context:Context,
                    var expandlistview: ExpandableListView,
                    var header: MutableList<String>,
                    var body: MutableList<MutableList<String>>): BaseExpandableListAdapter() {
    override fun getGroup(groupPosition: Int): String {
        return header[groupPosition]
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        var convertview = convertView
        if (convertView == null){
            var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertview = inflater.inflate(R.layout.layout_group,null)
        }
        var title = convertview?.findViewById<TextView>(R.id.tv_title)
        title?.text = getGroup(groupPosition)
        title?.setOnClickListener {
            if (expandlistview.isGroupExpanded(groupPosition)){
                expandlistview.collapseGroup(groupPosition)
            }else{
                expandlistview.expandGroup(groupPosition)
            }
            Toast.makeText(context,getGroup(groupPosition), Toast.LENGTH_SHORT).show()
        }
        return convertview

    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return body[groupPosition].size
    }

    override fun getChild(groupPosition: Int, childPosition: Int): String {
        return body[groupPosition][childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        var convertview = convertView
        if (convertView == null){
            var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertview = inflater.inflate(R.layout.layout_child,null)
        }
        var title = convertview?.findViewById<TextView>(R.id.tv_title1)
        title?.text = getChild(groupPosition,childPosition)
        return convertview
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return  childPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return header.size
    }
}
