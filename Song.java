import java.util.*;
import java.sql.*;

public class Song {
	
	private String title;
	private Artist artist;
	private float duration;
	private Composer composer;
	private Genre genre;
	private Rating rating;
	private Calendar dateAdded;
	private Song next;
	private Song prev;
	
	
	public Song(){
		dateAdded = Calendar.getInstance(); // just in case
	}
	
	public Song(String t){ // oftentimes, people will just start out with the name of song
		this.title = t;
		dateAdded = Calendar.getInstance();
	}
	
	public Song(String t, Artist a, float d, Composer c, Genre g, int r) {
		this.title = t;
		this.artist = a;
		this.duration = d;
		this.composer = c;
		this.genre = g;
		this.setRating(r); // does the auto convert from int to enum
		dateAdded = Calendar.getInstance();
	}
	
	public Song(String t, Artist a, float d, Composer c, Genre g, int r, Calendar dA) { // user determines "date added"
		this.title = t;
		this.artist = a;
		this.duration = d;
		this.composer = c;
		this.genre = g;
		this.setRating(r); // does the auto convert from int to enum
		dateAdded = dA;
	}
	
	public Song(String t, String a, float d, String c, String g, int r) {
		this.title = t; // add title
		
		// search for artist; if DNE, add, if exists, use that
		
		this.duration = d;
		
		// search for composer; if DNE, add, if exists, use that
		
		// search for genre; if DNE, add, if exists, use that
		
		// adding the rating; same algo as change rating, just sans print
		// if you get rid of print, then just call this.setRating(r);
		for (Rating rat: Rating.values()){ 
			if (rat.ordinal() == r - 1){
				this.rating = rat;
			}
		}
		
		dateAdded = Calendar.getInstance(); // setting date added
		
		
	}
	
	public static void main(String[] args){
		Song one = new Song();
		System.out.println(one.setRating(3));
	}

	public void setTitle(String t){
		this.title = t;
	}

	public void setDuration(float d){
		this.duration = d;
	}
	
	public void setArtist(Artist a){
		this.artist = a;
	}
	
	public void setArtist(String a){
		// TODO 
	}

	public void setComposer(Composer c){
		this.composer = c;
	}
	
	public void setComposer(String c){
		// TODO
	}

	public void setGenre(Genre g){
		this.genre = g;
	}
	
	public void setGenre(String g){
		// TODO
	}
	
	public String setRating(int newRating){
	
		for (Rating r: Rating.values()){
			if (r.ordinal() == newRating - 1){
				this.rating = r;

				return "You have thus deemed this song a " + newRating + 
						", \"" + this.rating.toString() + "\".";
			}
		}
		
		return "Invalid rating. Please enter a value between 1-7, inclusive";
			
	}

	public Calendar getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Calendar dA) {
		this.dateAdded = dA;
	}
	
	public String toString(){
		String out = "";
		String songData[] = {this.title, this.artist.toString(), this.composer.toString(), Float.toString(this.duration), this.genre.toString(), this.rating.toString()};
		
		for (String s: songData){
			out += out + s + "\n";
		}
		return out;
	}
	
}
