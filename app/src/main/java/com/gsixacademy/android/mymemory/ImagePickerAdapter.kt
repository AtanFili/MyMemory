package com.gsixacademy.android.mymemory

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.gsixacademy.android.mymemory.models.BoardSize
import kotlin.math.min

class ImagePickerAdapter(
    private val context:Context,
    private val imageUris: List<Uri>,
    private val boardSize: BoardSize,
    private val imageClickListener:ImageClickListener

) : RecyclerView.Adapter<ImagePickerAdapter.ViewHolder>() {
        interface ImageClickListener{
fun onPlaceHolderClicked()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.card_image,parent,false)
        val cardWidht=parent.width/boardSize.getWidht()
        val cardHeight=parent.height/boardSize.getHeight()
        val cardSideLenght=min(cardWidht,cardHeight)
        val layoutParams=view.findViewById<ImageView>(R.id.ivCustomImage).layoutParams
        layoutParams.width=cardSideLenght
        layoutParams.height=cardSideLenght
        return ViewHolder(view)

    }

    override fun getItemCount()=boardSize.getNumPairs()


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position<imageUris.size){
            holder.bind(imageUris[position])

        }else{
            holder.bind()
        }

    }
    inner class  ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        private val ivCustomImage=itemView.findViewById<ImageView>(R.id.ivCustomImage)
        fun bind(uri: Uri) {
            ivCustomImage.setImageURI(uri)
            ivCustomImage.setOnClickListener(null)

        }

        fun bind() {
            ivCustomImage.setOnClickListener{


                imageClickListener.onPlaceHolderClicked()
            }


        }
    }

}
