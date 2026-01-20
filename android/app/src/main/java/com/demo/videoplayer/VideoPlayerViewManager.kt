package com.demo

import android.widget.FrameLayout

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewManagerDelegate
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.VideoPlayerManagerInterface
import com.facebook.react.viewmanagers.VideoPlayerManagerDelegate
import com.demo.videoplayer.ReactFragment
import java.lang.ref.WeakReference
import com.facebook.react.ReactActivity
import androidx.fragment.app.commit
import android.util.Log;


class VideoPlayerViewManager(context: ReactApplicationContext): SimpleViewManager<FrameLayout>(), VideoPlayerManagerInterface<FrameLayout> {

    private val delegate: VideoPlayerManagerDelegate<FrameLayout, VideoPlayerViewManager> =
        VideoPlayerManagerDelegate(this)

    override fun getDelegate(): ViewManagerDelegate<FrameLayout> = delegate

    private var mPlayerViewContainer: WeakReference<ReactFragment>? = null

    private var activity: WeakReference<ReactActivity>? = null


    companion object {
        const val REACT_CLASS = "VideoPlayer"
        const val VIDEO_INDEX: String = "videoIndex"
        const val SHOW_TIMER: String = "showTimerView"
        const val EXPIRATION_DATE: String = "previewExpirationDate"
        const val PLAYLIST: String = "playlist"
        const val PLAYER_FRAGMENT_TAG: String = "PlayerFragment"
    }

    override fun getName(): String = REACT_CLASS
    override fun createViewInstance(reactContext: ThemedReactContext): FrameLayout {

        // Set the container
        val view = FrameLayout(reactContext)

        // Add view from the video Project
        // with a callback to this ViewManager
        mPlayerViewContainer = WeakReference(
            ReactFragment()
        )

        // Set current activity to start new fragment
        activity = WeakReference(reactContext.currentActivity as ReactActivity)

        // add fragment
        activity?.get()?.supportFragmentManager?.commit {
            setReorderingAllowed(true)
            add(mPlayerViewContainer!!.get()!!, PLAYER_FRAGMENT_TAG)
        }

        // Execute the commit immediately or can use commitNow() instead
        activity?.get()?.supportFragmentManager?.executePendingTransactions()

        // This step is needed to in order for ReactNative to render the view
        view.addView(mPlayerViewContainer!!.get()!!.requireView())

        return view
    }

    @ReactProp(name = PLAYLIST)
    override fun setPlaylist(view: FrameLayout, playlist: String?) {
        Log.i("VideoPlayerViewManager", "set playlist")
    }

    @ReactProp(name = VIDEO_INDEX)
    override fun setVideoIndex(view: FrameLayout, index: Int) {
        Log.i("VideoPlayerViewManager", "set video index")
    }

}