package spartdark.com.mx.playmusic;

import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class TrackDetailActivity extends ActionBarActivity implements View.OnClickListener {
    private int trackPosition;
    private Track track;
    private ImageButton actionPlay, actionBackward, actionForward;
    private boolean isPlaying = false;
    private String song;

    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_detail);

        Intent intent = getIntent();
        trackPosition = intent.getIntExtra("TRACK", 0);

        fillDataSong (trackPosition);

        actionPlay = (ImageButton) findViewById(R.id.actionPlay);
        actionBackward = (ImageButton) findViewById(R.id.actionBackward);
        actionForward = (ImageButton) findViewById(R.id.actionForward);

        actionPlay.setOnClickListener(this);
        actionBackward.setOnClickListener(this);
        actionForward.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        MediaMetadataRetriever metadatos = new MediaMetadataRetriever();
        switch (v.getId()){
            case R.id.actionPlay:
                if (isPlaying){
                    mediaPlayer.stop();
                    actionPlay.setImageResource(R.mipmap.play);
                    isPlaying = false;

                } else {
                    mediaPlayer = MediaPlayer.create(TrackDetailActivity.this,  getResources().getIdentifier("raw/"+song,
                            "raw", getPackageName()));
                    mediaPlayer.start();
                    actionPlay.setImageResource(R.mipmap.stop_play);
                    isPlaying = true;

                }
                break;
            case R.id.actionBackward:

                mediaPlayer.stop();

                trackPosition -= 1;
                Log.v("position","trackPosition: " + Integer.toString(trackPosition));

                if (trackPosition >= 0) {
                    fillDataSong(trackPosition);
                    mediaPlayer = MediaPlayer.create(TrackDetailActivity.this,  getResources().getIdentifier("raw/"+song,
                            "raw", getPackageName()));
                    if (isPlaying) {
                        mediaPlayer.start();
                        actionPlay.setImageResource(R.mipmap.stop_play);
                    }

                } else {
                    trackPosition = 0;
                    actionPlay.setImageResource(R.mipmap.play);
                    isPlaying = false;
                }

                break;

            case R.id.actionForward:

                mediaPlayer.stop();

                trackPosition += 1;
                Log.v("position","trackPosition: " + Integer.toString(trackPosition));

                int listTracksSize = Track.getTracks(getApplicationContext()).size();

                if (trackPosition < listTracksSize) {
                    fillDataSong(trackPosition);
                    mediaPlayer = MediaPlayer.create(TrackDetailActivity.this,  getResources().getIdentifier("raw/"+song,
                            "raw", getPackageName()));
                    if (isPlaying){
                        mediaPlayer.start();
                        actionPlay.setImageResource(R.mipmap.stop_play);
                    }
                } else {
                    trackPosition = 0;
                    fillDataSong(trackPosition);
                    actionPlay.setImageResource(R.mipmap.play);
                    isPlaying = false;
                }


                break;


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_track_music_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        mediaPlayer.stop();
        super.onDestroy();

    }

    /*
     * Fill all metadata that is going to be show on the Detail Layout
     */
    public void fillDataSong (int trackPosition){
        track = Track.getTracks(getApplicationContext()).get(trackPosition);
        song = track.getUrlTrack();
        ImageView imgDetailCover = (ImageView) findViewById(R.id.imgDetailCover);

        TextView tvDetailName = (TextView) findViewById(R.id.tvDetailName);
        TextView tvDetailArtist = (TextView) findViewById(R.id.tvDetailArtist);
        TextView tvDetailCover = (TextView) findViewById(R.id.tvDetailCover);
        TextView tvDetailTime = (TextView) findViewById(R.id.tvDetailTime);

        imgDetailCover.setImageDrawable(track.getCover());
        tvDetailName.setText(track.getName());
        tvDetailArtist.setText(track.getArtist());
        tvDetailCover.setText(track.getCoverName());
        tvDetailTime.setText(track.getTime());
    }
}
