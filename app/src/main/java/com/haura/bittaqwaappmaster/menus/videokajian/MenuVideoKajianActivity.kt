package com.haura.bittaqwaappmaster.menus.videokajian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.haura.bittaqwaappmaster.R
import com.haura.bittaqwaappmaster.menus.videokajian.adapter.VideoKajianListAdapter
import com.haura.bittaqwaappmaster.menus.videokajian.data.VideoKajianData
import com.haura.bittaqwaappmaster.menus.videokajian.model.VideoKajianModel
import kotlinx.android.synthetic.main.activity_menu_video_kajian.*

class MenuVideoKajianActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_video_kajian)

        setSupportActionBar(toolbar_menu_video_kajian)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val list: ArrayList<VideoKajianModel> = arrayListOf()
        rv_video_kajian.setHasFixedSize(true)
        list.addAll(VideoKajianData.listData)
        rv_video_kajian.layoutManager = LinearLayoutManager(this)
        val listVideoAdapter = VideoKajianListAdapter(list)
        rv_video_kajian.adapter = listVideoAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}