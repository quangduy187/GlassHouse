package com.example.administrator.glasshouse.Adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.administrator.glasshouse.Utils.Config
import com.example.administrator.glasshouse.MainActivity
import com.example.administrator.glasshouse.Model.GateData
import com.example.administrator.glasshouse.R
import de.hdodenhof.circleimageview.CircleImageView

class FarmChangeAdapter(val areaList:ArrayList<GateData>, val context:Context) : RecyclerView.Adapter<FarmChangeAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_row_area,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return areaList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtFarm.text = areaList[position].name
        holder.imgFarm.setOnClickListener {
//            val bundle = Bundle()
//            bundle.putInt("ID",position)
            Log.d("AAA",position.toString())
            val intent = Intent(context,MainActivity::class.java)

            // Lưu ID Farm được chọn trong Shared
            val mSharedPreferences = context.getSharedPreferences(Config.SharedCode, Context.MODE_PRIVATE)
            val editor = mSharedPreferences.edit()
            editor.putString(Config.GateId,areaList[position].id)
            editor.putString(Config.FarmName,areaList[position].name)
            editor.apply()
            context.startActivity(intent)
        }
    }

    inner class ViewHolder(item : View):RecyclerView.ViewHolder(item){
        val txtFarm : TextView = item.findViewById<View>(R.id.txtFarm) as TextView
        val imgFarm : CircleImageView = item.findViewById<View>(R.id.imgFarm) as CircleImageView
    }
}