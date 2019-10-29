package com.dicoding.footballapps

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.dicoding.footballapps.adapter.FootballAdapter
import com.dicoding.footballapps.model.DataModel
import com.dicoding.footballapps.ui.DetailsActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    companion object {
        const val PARCELABLE_DATA_ITEM = "DataItemModels"
    }

    var items: MutableList<DataModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadData()
        MainActivityUI(items).setContentView(this)

    }

    inner class MainActivityUI(val items: List<DataModel>) : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout(){
                lparams(width = matchParent, height = wrapContent)

                recyclerView {
                    layoutManager = LinearLayoutManager(context)
                    addItemDecoration(DividerItemDecoration(context, 1))
                    adapter = FootballAdapter(items){
                        startActivity<DetailsActivity>(PARCELABLE_DATA_ITEM to it)
                    }
                }
            }
        }
    }

    fun loadData() {
        val imgClub = resources.obtainTypedArray(R.array.club_image)
        val nameClub = resources.getStringArray(R.array.club_name)
        val descClub = resources.getStringArray(R.array.club_desc)

        items.clear()

        for (i in nameClub.indices) {
            items.add(DataModel(imgClub.getResourceId(i,0), nameClub[i], descClub[i]))
        }
        imgClub.recycle()
    }
}
