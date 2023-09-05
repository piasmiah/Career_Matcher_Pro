package com.trodev.careermatcherpro.videos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
import com.google.android.exoplayer2.ui.StyledPlayerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.trodev.careermatcherpro.R;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class VideoActivity extends AppCompatActivity {

    YouTubePlayerView youTubePlayerView;

  //  ExoPlayer player;

  //  String link = "https://tempx.jagobd.com:441/c5V6mmMyX7RpbEU9Mi8xNy8yMDEOGIDU6RgzQ6NTAgdEoaeFzbF92YWxIZTO0U0ezN1IzMyfvcGVMZEJCTEFWeVN3PT0mdFsaWRtaW51aiPhnPTI/anandatv.stream/chunks.m3u8";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        /*action bar hide*/
        getSupportActionBar().hide();


/*       StyledPlayerView playerView = findViewById(R.id.playerView);

        player = new ExoPlayer.Builder(VideoActivity.this).build();

        playerView.setPlayer(player);
        MediaItem mediaItem = MediaItem.fromUri(videoId);
        player.setMediaItem(mediaItem);
        player.prepare();
        player.setPlayWhenReady(true);*/


        youTubePlayerView = findViewById(R.id.tube);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = getIntent().getStringExtra("link");
                youTubePlayer.loadVideo(videoId, 0);

            }
        });

    }

/*    protected void onStop() {

        super.onStop();
        player.setPlayWhenReady(false);
        player.release();
        player = null;

    }*/

}