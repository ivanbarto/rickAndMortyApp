package com.ivanbarto.viewModelPractice.ui.character

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil.DiffResult.NO_POSITION
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.ivanbarto.viewModelPractice.R
import com.ivanbarto.viewModelPractice.base.component.BaseViewHolder
import com.ivanbarto.viewModelPractice.data.model.Character
import com.ivanbarto.viewModelPractice.databinding.ItemSimpleListBinding

/**
 *Created by ivanbarto on 18/03/21
 */
class CharactersAdapter(
    private val context: Context
) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    private var characters = listOf<Character>()
    lateinit var onCharacterClick: (character: Character) -> Unit

    fun setCharacters(characters: List<Character>) {
        this.characters = characters
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = ItemSimpleListBinding.inflate(LayoutInflater.from(context), parent, false)

        val holder = CharacterViewHolder(itemBinding)

        /**
         * Why we not just put all the bind work here? Because here we don't create an instance of every
         * action we do. We use the onBindViewHolder to bind different data such as images or text. This
         * prevents the RecyclerView to do that kind of bugs like images repetitions or thinks like that
         */
        itemBinding.root.setOnClickListener {
            val position =
                holder.adapterPosition.takeIf { it != NO_POSITION } ?: return@setOnClickListener
            onCharacterClick(characters[position])
        }

        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        // this is useful to set different view to the same recycler view
        when (holder) {
            is CharacterViewHolder -> holder.bind(characters[position])
        }
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    //inner is to kill the ViewHolder when the adapter is destroyed --> this prevents memory leaks
    inner class CharacterViewHolder(private val itemBinding: ItemSimpleListBinding) :
        BaseViewHolder<Character>(itemBinding.root) {
        //with is to avoid doing itemView.something
        override fun bind(item: Character): Unit = with(itemBinding) {
            ivCharacter.load(item.image)
            tvCharacterName.text = item.name
            tvSpecie.text = item.species
        }
    }
}