package spartdark.com.mx.playmusic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**

 * Created by mobilestudio06 on 13/04/15.
 */
public class MusicAdapter extends ArrayAdapter{
    ArrayList<Track>  tracks;
    Context context;


    public MusicAdapter(Context context, int resource, ArrayList<Track> tracks) {
        super(context, resource, tracks);
        this.tracks = tracks;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.item_list_tracks,parent,false);

        ViewHolder holder = new ViewHolder();

        holder.tvName = (TextView) rowView.findViewById(R.id.tvName);
        holder.tvArtist = (TextView) rowView.findViewById(R.id.tvArtist);
        holder.tvCover = (TextView) rowView.findViewById(R.id.tvCover);
        holder.tvTime = (TextView) rowView.findViewById(R.id.tvTime);
        holder.imgCover = (ImageView) rowView.findViewById(R.id.imgCover);

        Track track = tracks.get(position);

        holder.tvName.setText(track.getName());
        holder.tvArtist.setText(track.getArtist());
        holder.tvCover.setText(track.getCoverName());
        holder.tvTime.setText(track.getTime());
        holder.imgCover.setImageDrawable(track.getCover());

        return rowView;
    }

    static class ViewHolder {
        TextView tvName;
        TextView tvArtist;
        TextView tvCover;
        TextView tvTime;
        ImageView imgCover;
    }
}
