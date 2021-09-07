package PlayList;

public class Song {
	private String track;
	private Artist artist;
	private Album albumName;
	
	public Song(String track, Artist artist, Album albumName) {
		this.track = track;
		this.artist = artist;
		this.albumName = albumName;
	}
	
	

	@Override
	public String toString() {
		return track+" - "+ artist+"\n"+albumName;
	}



	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Album getAlbumName() {
		return albumName;
	}

	public void setAlbumName(Album albumName) {
		this.albumName = albumName;
	}
	
	

	
	
}
