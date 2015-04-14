package spartdark.com.mx.playmusic;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class TrackDetailActivity extends ActionBarActivity {
    private int trackPosition;
    private Track track;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_detail);

        Intent intent = getIntent();
        trackPosition = intent.getIntExtra("TRACK", 0);
        track = Track.getTracks(getApplicationContext()).get(trackPosition);

        ImageView imgDetailCover = (ImageView) findViewById(R.id.imgDetailCover);

        TextView tvDetailName = (TextView) findViewById(R.id.tvDetailName);
        TextView tvDetailArtist = (TextView) findViewById(R.id.tvDetailArtist);
        TextView tvDetailCover = (TextView) findViewById(R.id.tvDetailCover);
        TextView tvDetaiTime = (TextView) findViewById(R.id.tvDetailTime);

        imgDetailCover.setImageDrawable(track.getCover());
        tvDetailName.setText(track.getName());
        tvDetailArtist.setText(track.getArtist());
        tvDetailCover.setText(track.getCoverName());
        tvDetaiTime.setText(track.getTime());



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
}
