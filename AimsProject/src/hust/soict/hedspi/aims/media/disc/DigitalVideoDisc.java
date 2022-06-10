package hust.soict.hedspi.aims.media.disc;

import hust.soict.hedspi.aims.media.Media;

public class DigitalVideoDisc extends Disc implements Playable, Comparable<Media> {
    // Attribute declaration
    protected String director;
    protected int length;

    public DigitalVideoDisc(int id, String title, float cost) {
        super(id, title, cost);
    }

    public DigitalVideoDisc(int id, String title, int length, float cost) {
        super(id, title,length, cost);
    }

    public DigitalVideoDisc(int id, String title, String category, int length, float cost ) {
        super(id, title, category,length, cost);
    }

    public DigitalVideoDisc(int id, String title, String category, int length, String director, float cost) {
        super(id, title, category, length, director, cost);
    }

    // get and set methods
    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength(){
        return length;
    }

    public boolean setLength(int length) {
        if (length > 0) {
            this.length = length;
            return true;
        } else
            return false;
    }

    // Xây dựng phương thức tìm kiếm theo title
    public boolean search(String title) {
        String searchStr = this.getTitle();
        return searchStr.toLowerCase().contains(title.toLowerCase());
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());

    }

    public int compareTo(Media media) {
        if (media instanceof DigitalVideoDisc) {
            return Float.compare(this.getCost(), media.getCost());
        } else
            return super.compareTo(media);
    }
}
