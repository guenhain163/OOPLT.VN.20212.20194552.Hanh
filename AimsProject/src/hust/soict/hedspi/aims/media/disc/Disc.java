package hust.soict.hedspi.aims.media.disc;

import hust.soict.hedspi.aims.media.Media;

public class Disc extends Media {
    protected int length;
    protected String director;

    public Disc() {

    };

    public Disc(int id, String title){
        super(id,title);
    }

    public Disc(int id, String title, String category){
        super(id,title,category);
    }
    public Disc(int id, String title, String category, float cost){
        super(id, title, category, cost);
    }

    public Disc(int id, String title, String director, int length){
        super(id, title);
        this.director = director;
        this.length = length;
    }

    public Disc(int id, String title, String category, float cost, int length){
        super(id, title, category);
        this.length = length;
        this.cost = cost;
    }

    public Disc(int id, String title, String category, String director, int length){
        super(id, title, category);
        this.director = director;
        this.length = length;
    }

    public Disc(int id, String title, String category, float cost, String director, int length){
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public int compareTo(Object o) {
        return super.compareTo(o);
    }
}
