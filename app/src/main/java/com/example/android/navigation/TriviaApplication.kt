package com.example.android.navigation

import android.app.Application
import com.google.android.gms.analytics.GoogleAnalytics
import com.google.android.gms.analytics.Tracker

class TriviaApplication : Application() {

    private lateinit var googleAnalytics: GoogleAnalytics
    private var tracker: Tracker? = null

    override fun onCreate() {
        super.onCreate()

        googleAnalytics = GoogleAnalytics.getInstance(this)

    }

    fun getDefaultTracker(): Tracker? {
        if (tracker == null) {
            tracker = googleAnalytics.newTracker(R.xml.global_tracker)
        }

        return tracker
    }

}