package team6.see_throughadas;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

public class videoActivity extends AppCompatActivity {
    VideoView videov;
    MediaController mediacont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_video);

        videov = findViewById(R.id.videoView);

        mediacont = new MediaController(this);



        String videoPath = "android.resource://team6.see_throughadas/"+R.raw.dashcam_test1_360p;
        Uri uri = Uri.parse(videoPath);
        videov.setVideoURI(uri);

        videov.setOnPreparedListener(new MediaPlayer.OnPreparedListener () {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });

        mediacont.setAnchorView(videov);
        videov.setMediaController(mediacont);

        videov.start();

}
