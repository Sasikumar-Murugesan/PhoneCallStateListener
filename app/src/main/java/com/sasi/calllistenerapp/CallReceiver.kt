package com.sasi.calllistenerapp

import android.app.Activity
import android.content.Context
import android.util.Log

import java.util.Date

class CallReceiver : PhonecallReceiver() {
    var callEnded = true
    override fun onIncomingCallStarted(ctx: Context, number: String?, start: Date) {
        callEnded = false
        Log.v("context: ", "${ctx.applicationContext is AppInstance}")
        if (ctx.applicationContext is AppInstance) {
            ((ctx.applicationContext as AppInstance).currentActivity as MainActivity).printStatus(callEnded)

        }
    }

    override fun onOutgoingCallStarted(ctx: Context, number: String?, start: Date) {
        callEnded = false
        if (ctx.applicationContext is AppInstance) {
            ((ctx.applicationContext as AppInstance).currentActivity as MainActivity).printStatus(callEnded)

        }

    }

    override fun onIncomingCallEnded(ctx: Context, number: String?, start: Date?, end: Date) {
        callEnded = true
        if (ctx.applicationContext is AppInstance) {
            ((ctx.applicationContext as AppInstance).currentActivity as MainActivity).printStatus(callEnded)

        }

    }

    override fun onOutgoingCallEnded(ctx: Context, number: String?, start: Date?, end: Date) {
        callEnded = true
        if (ctx.applicationContext is AppInstance) {
            ((ctx.applicationContext as AppInstance).currentActivity as MainActivity).printStatus(callEnded)
        }

    }

    override fun onMissedCall(ctx: Context, number: String?, start: Date?) {
        callEnded = true
        if (ctx.applicationContext is AppInstance) {
            ((ctx.applicationContext as AppInstance).currentActivity as MainActivity).printStatus(callEnded)
        }
    }

}