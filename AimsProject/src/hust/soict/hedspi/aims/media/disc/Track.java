package hust.soict.hedspi.aims.media.disc;

import hust.soict.hedspi.aims.exceptions.PlayerException;

public class Track implements Playable, Comparable<Object> {
    private String title;
    private int length;

    public Track() {

    }

    public Track(String title) {
        this.title = title;
    }

    public Track(int length) {
        this.length = length;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public String getMessage() {
        return "\nPlaying Track: " + this.getTitle() + "\nTrack length: " + this.getLength();
    }

    public void play() throws PlayerException {
        if (this.length <= 0) {
            throw new PlayerException("ERROR: CD length is non-positive");
        }
    }

    public boolean isEqualAll(Track aTrack) {
        if (this.title.equals(aTrack.getTitle())) {
            return this.length == aTrack.length;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Track) {
            return length == ((Track) obj).getLength() && title.equals(((Track) obj).title);
        } else
            return false;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
