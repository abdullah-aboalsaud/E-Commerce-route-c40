package com.example.e_commerce_route_c40.base


import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding


abstract class BaseAdapter<TypeItemList, VB : ViewBinding> :
    RecyclerView.Adapter<BaseAdapter<TypeItemList, VB>.ViewHolder>() {

    private var items: MutableList<TypeItemList> = mutableListOf()

    inner class ViewHolder(val binding: VB) : RecyclerView.ViewHolder(binding.root)

    abstract fun getBinding(parent: ViewGroup, viewType: Int): VB

    abstract fun bindData(binding: VB, item: TypeItemList, position: Int)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = getBinding(parent, viewType)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        bindData(holder.binding, item, position)
    }

    override fun getItemCount(): Int = items.size

    fun addDataToList(item: TypeItemList) {
        items.add(item)
        notifyItemChanged(items.lastIndex)
    }

    open fun addDataToList(list: MutableList<TypeItemList>) {
        val preItemSize = items.lastIndex
        if (items.addAll(list))
            notifyItemRangeInserted(preItemSize, list.size)
    }

    open fun removeItem(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    open fun getItem(pos: Int): TypeItemList = items[pos]
}