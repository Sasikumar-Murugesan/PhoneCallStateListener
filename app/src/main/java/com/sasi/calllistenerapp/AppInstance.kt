package com.sasi.calllistenerapp

import android.app.Activity
import android.app.Application
import android.content.IntentFilter
import android.os.Bundle
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class AppInstance : Application(), Application.ActivityLifecycleCallbacks {
    var callReceiver: CallReceiver? = null
    val CALL_INTENT_FILTER = "CALL_NOTIFICATION_SERVICE"
    var currentActivity:Activity?=null
    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {

    }

    override fun onActivityPaused(activity: Activity?) {
        currentActivity=activity
/*        try {
            callReceiver?.let {
                LocalBroadcastManager.getInstance(this)
                    .unregisterReceiver(it)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }*/
    }

    override fun onActivityResumed(activity: Activity?) {
        currentActivity=activity
      /*  callReceiver = activity?.let { CallReceiver(it) }
        callReceiver?.let {
            val filter = IntentFilter()
            filter.addAction("android.intent.action.PHONE_STATE")
            filter.addAction("android.intent.action.NEW_OUTGOING_CALL")
            LocalBroadcastManager.getInstance(this)
                .registerReceiver(it, filter)
        }*/

    }

    override fun onActivityStarted(activity: Activity?) {
    }

    override fun onActivityDestroyed(activity: Activity?) {
        currentActivity=null
       /* try {
            callReceiver?.let {
                LocalBroadcastManager.getInstance(this)
                    .unregisterReceiver(it)
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }*/
    }

    override fun onActivityStopped(activity: Activity?) {
        currentActivity=activity
    }

    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
    }

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(this)
    }

}