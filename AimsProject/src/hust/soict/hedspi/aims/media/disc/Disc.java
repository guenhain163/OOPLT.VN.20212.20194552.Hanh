package hust.soict.hedspi.aims.media.disc;

import hust.soict.hedspi.aims.media.Media;

public class Disc extends Media {
    protected int length;
    protected String director;

    public Disc(int id, String title, float cost) {
        super(id, title, cost);
    }

    public Disc(int id, String title, int length, float cost) {
        super(id, title, cost);
        this.length = length;
    }

    public Disc(int id, String title, String category, int length, float cost ) {
        super(id, title, category, cost);
        this.length = length;
    }

    public Disc(int id, String title, String category, int length, String director, float cost) {
        this(id, title, category, length, cost);
        this.director = director;
    }

    public Disc() {

    }

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }
}
