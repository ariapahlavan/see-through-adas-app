package team6.see_throughadas;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.Externalizable;
import java.io.File;

public class videoActivity extends AppCompatActivity {
    VideoView videov;
    MediaController mediacont;
    String uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videov = findViewById(R.id.videoView);
        mediacont = new MediaController(this);

        switch (Options.videoOption) {
            case 1:
                uri = Environment.getExternalStorageDirectory().getPath() + "/annotated.mp4";
                videov.setVideoPath(uri);
                break;
            case 2:
                uri = Environment.getExternalStorageDirectory().getPath() + "/stitched.mp4";
                videov.setVideoPath(uri);
                break;
            default:
                uri = Environment.getExternalStorageDirectory().getPath() + "/original.mp4";
                videov.setVideoPath(uri);
                break;
        }

        videov.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });


        mediacont.setAnchorView(videov);
        videov.setMediaController(mediacont);

        videov.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.options) {
            Intent intent = new Intent(this, Options.class);
            this.startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }

    }

}
