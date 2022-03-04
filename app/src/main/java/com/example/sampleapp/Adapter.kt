package com.example.sampleapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleapp.data.model


class Adapter(private val context: Context):RecyclerView.Adapter<Adapter.viewholder>() {


    private var data= emptyList <model>()

  inner class viewholder(itemview:View):RecyclerView.ViewHolder(itemview){
      var txtview:TextView?=null
      init {
          txtview=itemview.findViewById(R.id.txt)
      }
  }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val view=LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)
        return viewholder(view)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.txtview?.text=data!!.get(position).toString()
    }

    override fun getItemCount(): Int {
        return data!!.size
    }

    fun setdata(usr:List<model>){
        data=usr
        notifyDataSetChanged()
    }
}