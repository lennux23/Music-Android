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
    private String urlTrack;



    public Track(Drawable cover, String name, String artist, String coverName, String time, String urlTrack) {
        this.cover = cover;
        this.name = name;
        this.artist = artist;
        this.coverName = coverName;
        this.time = time;
        this.urlTrack = urlTrack;
    }



    public static ArrayList<Track> getTracks (Context context) {

        ArrayList<Track> arrayContact= new ArrayList<Track>();

        arrayContact.add(new Track(context.getResources().getDrawable(R.mipmap.proanio),"Argentum","Enjambre","Proaño","3:15", "enjambre_argentum"));
        arrayContact.add(new Track(context.getResources().getDrawable(R.mipmap.proanio),"Sábado Perpetuo","Enjambre","Proaño","5:14","enjambre_sabado_perpetuo"));
        arrayContact.add(new Track(context.getResources().getDrawable(R.mipmap.monitor_volovan),"Monitor","Volovan","Monitor","3:10","volovan_monitor" ));
        arrayContact.add(new Track(context.getResources().getDrawable(R.mipmap.safe_and_sound_capitalcities),"Safe & Sound","Capital Cities","In a tidal wave of mystery","4:03","capital_cities_safe_and_cound"));
        arrayContact.add(new Track(context.getResources().getDrawable(R.mipmap.safe_and_sound_capitalcities),"I sold my bed","Capital Cities","In a tidal wave of mystery","3:67","capital_cities_i_sold_my_bed_but_not_my_stereo" ));
        arrayContact.add(new Track(context.getResources().getDrawable(R.mipmap.siddhartha_siddhartha),"Control","Siddhartha","Siddhartha","2:56","siddhartha_control"));
        arrayContact.add(new Track(context.getResources().getDrawable(R.mipmap.soy_como_quiero_ser_luis_miguel),"Ahora te puedes marchar","Luis Miguel","Soy como quiero ser","3:10", "luis_miguel_ahora_te_puedes_marchar"));



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

    public String getUrlTrack() {
        return urlTrack;
    }

    public void setUrlTrack(String urlTrack) {
        this.urlTrack = urlTrack;
    }
}
