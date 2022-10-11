package com.haura.bittaqwaappmaster.dashboard.data

import com.haura.bittaqwaappmaster.R
import com.haura.bittaqwaappmaster.dashboard.model.InspirationModel

object InspirationData {

    private val inspirationImage = intArrayOf(
        R.drawable.img_inspiration1,
        R.drawable.img_inspiration2,
        R.drawable.img_inspiration3,
        R.drawable.img_inspiration4,
        R.drawable.img_inspiration5,
        R.drawable.img_inspiration6,
        R.drawable.img_inspiration7,
        R.drawable.img_inspiration8,
        R.drawable.img_inspiration9,
        R.drawable.img_inspiration10,
    )

    val listData : ArrayList<InspirationModel>
        get() {
            val list = arrayListOf<InspirationModel>()

            for (position in inspirationImage.indices) {
                val inspiration = InspirationModel()
                inspiration.inspirationImageModel = inspirationImage[position]
                list.add(inspiration)
            }
            return list
        }
}