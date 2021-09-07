package PlayList;

import java.util.ArrayList;

public class Artist {
	private ArrayList<Album> albums = new ArrayList<>();
	private String name;
	
	public Artist(String name) {
		this.name = name;
	}
	
	public void addAlbum(Album albumName) {
		albums.add(albumName);
		
	}
	
	@Override
	public String toString() {
		return name;
	}

	public ArrayList<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(ArrayList<Album> albums) {
		this.albums = albums;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	


}
