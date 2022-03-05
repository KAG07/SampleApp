package com.example.sampleapp

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleapp.data.Model
import java.util.ArrayList


class Adapter(private val context: Context):RecyclerView.Adapter<Adapter.viewholder>() {


    private lateinit var data: ArrayList<Model>

  inner class viewholder(itemview: View):RecyclerView.ViewHolder(itemview){
      var txtview:TextView?=null

      init {
          txtview=itemview.findViewById(R.id.txt)
      }
  }

    init {
        data= ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val inflator=LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)
        return viewholder(inflator)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        var mode=data.get(position)
        holder.txtview?.text=mode.order.toString()
    }

    override fun getItemCount(): Int {
        return data.size
    }


    fun setdata(usr:ArrayList<Model>){
        val diffCallback = MyDiffCallback(data, usr)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        diffResult.dispatchUpdatesTo(this)
        data.clear()
        data.addAll(usr)
    }

    open class MyDiffCallback(
        private val oldlist: List<Model>,
        private val newlist: List<Model>
    ): DiffUtil.Callback() {

        override fun getOldListSize(): Int {
            return oldlist.size
        }

        override fun getNewListSize(): Int {
            return newlist.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            // In the real world you need to compare something unique like id
            return oldlist[oldItemPosition].code == newlist[newItemPosition].code
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            // This is called if areItemsTheSame() == true;
            return oldlist[oldItemPosition].order == newlist[newItemPosition].order
        }
    }
}