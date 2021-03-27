package com.gsixacademy.android.mymemory.utils

import android.graphics.Bitmap

object BitmapScaler {
    fun  scaleToFitWidht(b:Bitmap,widht:Int):Bitmap{
        val factor=widht/b.width.toFloat()
        return Bitmap.createScaledBitmap(b,widht,(b.height*factor).toInt(),true)
    }
    fun scaleToFitHeight(b:Bitmap,height:Int):Bitmap{
        val factor=height/b.height.toFloat()
        return Bitmap.createScaledBitmap(b,(b.width*factor).toInt(),height,true)
    }

}
