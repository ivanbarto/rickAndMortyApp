package com.ivanbarto.viewModelPractice.base.component

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 *Created by ivanbarto on 18/03/21
 *
 * This class just specify that you have to pass a View and implement bind() method, which takes the
 * item of the RecyclerView and binds it with viewBinding to the appropriate XML layout.
 */
abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind (item: T)
}