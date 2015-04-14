package spartdark.com.mx.playmusic;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

/**
 * Created by mobilestudio06 on 13/04/15.
 */
public class Track {
    private Drawable cover;
    private String name;



    private String artist;
    private String coverName;
    private String time;


    public Track(Drawable cover, String name, String artist, String coverName, String time) {
        this.cover = cover;
        this.name = name;
        this.artist = artist;
        this.coverName = coverName;
        this.time = time;
    }



    public static ArrayList<Track> getTracks (Context context) {

        ArrayList<Track> arrayContact= new ArrayList<Track>();

        arrayContact.add(new Track(context.getResources().getDrawable(R.mipmap.proanio),"Argentum","Enjambre","Proaño","3:1515"));
        arrayContact.add(new Track(context.getResources().getDrawable(R.mipmap.proanio),"Sábado Perpetuo","Enjambre","Proaño","5:14"));
        arrayContact.add(new Track(context.getResources().getDrawable(R.mipmap.monitor_volovan),"Monitor","Volovan","Monitor","3:10"));
        arrayContact.add(new Track(context.getResources().getDrawable(R.mipmap.safe_and_sound_capitalcities),"Safe & Sound","Capital Cities","In a tidal wave of mystery","4:03"));
        arrayContact.add(new Track(context.getResources().getDrawable(R.mipmap.safe_and_sound_capitalcities),"I sold my bed","Capital Cities","In a tidal wave of mystery","3:67"));



        return arrayContact;

    }

    public Drawable getCover() {
        return cover;

    }

    public void setCover(Drawable cover) {
        this.cover = cover;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCoverName() {
        return coverName;
    }

    public void setCoverName(String coverName) {
        this.coverName = coverName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
