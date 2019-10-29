package com.dicoding.footballapps.ui

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*

class FootballClubUI : AnkoComponent<ViewGroup>{

    companion object {
        val clubImage = 1
        val clubName = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        verticalLayout {
            orientation = LinearLayout.HORIZONTAL
            padding = dip(16)

            imageView {
                id = clubImage
            }.lparams(width = dip(50), height = dip(50))

            textView {
                id = clubName
            }.lparams(wrapContent, wrapContent) {
                gravity = Gravity.CENTER_VERTICAL
                margin = dip(10)
            }
        }
    }
}