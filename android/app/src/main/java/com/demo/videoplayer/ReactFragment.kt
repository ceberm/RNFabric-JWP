package com.demo.videoplayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import com.demo.R
import com.demo.compose.ui.jw.Video
import com.demo.compose.ui.theme.JWComposeTheme
import com.jwplayer.pub.api.license.LicenseUtil


/**
 * A simple [Fragment] subclass.
 * Use the [ReactFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ReactFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        LicenseUtil().setLicenseKey(context, "")
        super.onCreate(savedInstanceState)
    }

    @OptIn(ExperimentalAnimationApi::class, ExperimentalComposeUiApi::class)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_react, container, false)
        val composeView = view.findViewById<ComposeView>(R.id.compose_view)
        composeView.apply {
            // Dispose of the Composition when the view's LifecycleOwner
            // is destroyed
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                JWComposeTheme {
                    Video(
                        lifecycleOwner = viewLifecycleOwner,
                        modifier = Modifier
                            .fillMaxSize()
                            .systemBarsPadding()
                    )
                }

                /*AndroidView(
                    modifier = Modifier
                        .fillMaxSize()
                        .systemBarsPadding(),
                    factory = {
                        JWPlayerView(context).apply {
                            getPlayerAsync(context, viewLifecycleOwner) { jwPlayer ->
                                // call view model to initialize player setups
                            }
                        }
                    },
                    update = { playerView ->
                        /**
                         * Any operation for JWPlayerView after inflated in the view.
                         like start another video
                         */
                        // videoState.playerConfig?.let { playerView.player.setup(it) }
                    }
                )*/
            }
        }
        return view
    }

}