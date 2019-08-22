package com.example.pwpb_recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pwpb_recyclerview.R;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {
    private List<Song> songList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvRank, tvSongName, tvSinger, tvYear;
        public ImageView ivAlbumCover;

        public ViewHolder(View v) {
            super(v);
            tvRank = v.findViewById(R.id.tv_rank);
            tvSongName = v.findViewById(R.id.tv_song_name);
            tvSinger = v.findViewById(R.id.tv_singer);
            tvYear = v.findViewById(R.id.tv_year);
            ivAlbumCover = v.findViewById(R.id.iv_album_cover);
        }
    }

    public SongAdapter(List<Song> songList) {
        this.songList = songList;
    }

    @NonNull
    @Override
    public SongAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song song = songList.get(position);
        holder.tvRank.setText(String.valueOf(song.getRank()));
        holder.tvSongName.setText(song.getName());
        holder.tvSinger.setText(song.getSinger());
        holder.tvYear.setText(song.getYear());
        holder.ivAlbumCover.setImageResource(song.getPic());
        holder.tvYear.setText("2016");
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }
}
