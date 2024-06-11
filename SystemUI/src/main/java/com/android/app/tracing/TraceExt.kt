package com.android.app.tracing


object TraceCompat {
    const val TRACE_TAG_APP: Long = 1L shl 12

    fun isTagEnabled(tag: Long): Boolean {
        return false
    }

    fun asyncTraceForTrackBegin(tag: Long, trackName: String, method: String, cookie: Int) {

    }

    fun asyncTraceForTrackEnd(tag: Long, trackName: String, cookie: Int) {

    }

    fun instant(tag: Long, eventName: String) {

    }

    fun instantForTrack(tag: Long, trackName: String, eventName: String) {

    }

    fun traceBegin(tag: Long, sliceName: String) {

    }

    fun traceEnd(tag: Long) {

    }
}
