package PlayList;

import java.util.ArrayList;

public class Album {
	
	private String track;
	private int year;
	private Artist artist;
	private ArrayList<Song> songs = new ArrayList<>();
	
	public Album(String track, int year, Artist artist) {
		this.track = track;
		this.year = year;
		this.artist = artist;
	}

	public void addTrack(Song song) {
		songs.add(song);
		
	}

	@Override
	public String toString() {
		return track+"("+year+")";
	}
	
	public Song getTrack(int i) {
		Song x= songs.get(i-1);
		return x;
	}

	public void setTrack(String track) {
		this.track = track;
	}
	
	public String getAlbum() {		
		return track;
	}

	public void setSongs(ArrayList<Song> songs) {
		this.songs = songs;
	}
	
	

	
	
	
}
