package com.frogobox.research

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.annotation.StringRes
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.drag.IDraggable
import com.mikepenz.fastadapter.items.AbstractItem
import com.mikepenz.fastadapter.ui.utils.FastAdapterUIUtils

// Created by (M. Faisal Amir) on 08/08/22.


open class SimpleItem : AbstractItem<SimpleItem.ViewHolder>(), IDraggable {

    var header: String? = null
    var GlobalName: String? = null
    var GlobalDescription: String? = null

    override var isDraggable = true

    /**
     * defines the type defining this item. must be unique. preferably an id
     *
     * @return the type
     */
    override val type: Int
        get() = R.id.fastadapter_sample_item_id

    /**
     * defines the layout which will be used for this item in the list
     *
     * @return the layout for this item
     */
    override val layoutRes: Int
        get() = R.layout.simple_item

    fun withHeader(header: String): SimpleItem {
        this.header = header
        return this
    }

    fun withName(Name: String): SimpleItem {
        this.GlobalName = Name
        return this
    }

    fun withName(@StringRes NameRes: Int): SimpleItem {
        this.GlobalName = NameRes.toString()
        return this
    }

    fun withDescription(description: String): SimpleItem {
        this.GlobalDescription = description
        return this
    }

    fun withDescription(@StringRes descriptionRes: Int): SimpleItem {
        this.GlobalDescription = descriptionRes.toString()
        return this
    }

    fun withIdentifier(identifier: Long): SimpleItem {
        this.identifier = identifier
        return this
    }

    fun withIsDraggable(draggable: Boolean): SimpleItem {
        this.isDraggable = draggable
        return this
    }

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    /**
     * our ViewHolder
     */
    class ViewHolder(private var view: View) : FastAdapter.ViewHolder<SimpleItem>(view) {
        var name: TextView = view.findViewById(R.id.material_drawer_name)
        var description: TextView = view.findViewById(R.id.material_drawer_description)

        override fun bindView(item: SimpleItem, payloads: List<Any>) {
            //get the context
            val ctx = itemView.context

            //set the background for the item
            view.background = FastAdapterUIUtils.getSelectableBackground(ctx, Color.RED, true)
            //set the text for the name
            name.text = item.GlobalName
            description.text = item.GlobalDescription
            //set the text for the description or hide
        }

        override fun unbindView(item: SimpleItem) {
            name.text = null
            description.text = null
        }
    }
}
