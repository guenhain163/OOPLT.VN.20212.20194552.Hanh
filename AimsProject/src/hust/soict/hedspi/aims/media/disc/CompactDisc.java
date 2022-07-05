package hust.soict.hedspi.aims.media.disc;

import hust.soict.hedspi.aims.exceptions.PlayerException;
import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();
    public String message;

    public CompactDisc() {
        super();
    }

    public CompactDisc(String artist, List<Track> tracks) {
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(int id, String title, String category, String artist, List<Track> tracks) {
        super(id, title, category);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(int id, String title, String category, float cost, String artist, List<Track> tracks) {
        super(id, title, category, cost);
        this.artist = artist;
        this.tracks = tracks;
    }
    public CompactDisc(int id,String title,String category,float cost ,String artist){
        super(id,title,category,cost);
        this.artist = artist;
    }
    public CompactDisc(int id,String title,String category,float cost ,String artist,int length){
        super(id,title,category,cost,length);
        this.artist = artist;
    }
    public CompactDisc(int id, String title, String category, float cost,String director, String artist,int length) {
        super(id, title, category, cost,director,length);
        this.artist = artist;
    }

    public CompactDisc(int id, String title, String category, String artist, float cost) {
        super(id, title, category, cost);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public int getLength() {
        int sum = 0;
        for(Track track: tracks) {
            sum += track.getLength();
        }
        super.length = sum;
        return sum;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.err.println("ERR: Track has been existed!");
        } else {
            tracks.add(track);
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.err.println("ERR: Track don't existed!");
        }
    }

    public int getNumOfTrack(){
        return tracks.size();
    }

    public int searchTrack(Track cmpTrack) {
        for (int i = 0; i < this.tracks.size(); i++) {
            if (this.tracks.get(i).isEqualAll(cmpTrack)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void play() throws PlayerException {
        this.message = "Playing CD: " + this.getTitle() + "\nCD length: " + this.getLength();
        if (this.getLength() > 0) {
            for(Track track: tracks) {
                track.play();
                message += track.getMessage();
            }
        } else {
            throw new PlayerException("ERROR: CD length is non-positive");
        }
    }

    public int compareTo(Media o) {
        if(o instanceof CompactDisc){
            if(this.getNumOfTrack() > ((CompactDisc) o).getNumOfTrack())
                return 1;
            else if (this.getNumOfTrack() < ((CompactDisc) o).getNumOfTrack())
                return -1;
            else{
                if(this.getLength() > ((CompactDisc) o).getLength())
                    return 1;
                else if (this.getLength() > ((CompactDisc) o).getLength())
                    return -1;
                else
                    return super.compareTo(o);
            }
        }
        else
            return super.compareTo(o);
    }
}
