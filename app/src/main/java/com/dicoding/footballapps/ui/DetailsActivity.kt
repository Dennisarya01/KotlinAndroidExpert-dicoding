package com.dicoding.footballapps.ui

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.dicoding.footballapps.MainActivity
import com.dicoding.footballapps.model.DataModel
import org.jetbrains.anko.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val item = intent.getParcelableExtra<DataModel>(MainActivity.PARCELABLE_DATA_ITEM)
        DetailsActivityUI(item).setContentView(this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return if (item?.itemId == android.R.id.home) {
            finish()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }

    inner class DetailsActivityUI(val item: DataModel) : AnkoComponent<DetailsActivity> {
        val idView = 1
        val idImage = 2
        val idName = 3

        override fun createView(ui: AnkoContext<DetailsActivity>) = with(ui) {
            relativeLayout {
                lparams(wrapContent, wrapContent)

                view {
                    id = idView
                    setBackgroundColor(Color.rgb(0, 133, 119))
                }.lparams(matchParent, dip(150))

                imageView {
                    id = idImage
                    Glide.with(this)
                            .load(item.image)
                            .into(this)
                }.lparams(dip(100), dip(100)) {
                    centerHorizontally()
                    topMargin = dip(100)
                }

                textView {
                    id = idName
                    text = item.nameClub
                    textSize = 24f
                    setTypeface(null, Typeface.BOLD)
                }.lparams {
                    below(idImage)
                    centerHorizontally()
                }

                textView {
                    padding = dip(16)
                    text = item.descClub
                }.lparams {
                    below(idName)
                }
            }
        }
    }
}
