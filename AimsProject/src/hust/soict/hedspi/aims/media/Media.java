package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.media.book.Book;
import hust.soict.hedspi.aims.media.disc.CompactDisc;
import hust.soict.hedspi.aims.media.disc.DigitalVideoDisc;

public abstract class Media implements Comparable<Media> {
    protected String title;
    protected String category;
    protected float cost;
    protected int id = 1;

    public Media(int id, String title, float cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public Media(int id, String title, String category, float cost) {
        this(id, title, cost);
        this.category = category;
    }

    public Media() {

    }

    public String getTitle() {
        return this.title;
    }

    public String getCategory() {
        return this.category;
    }

    public float getCost() {
        return this.cost;
    }

    public int getId() {
        return id;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Media other = (Media) obj;
        if (id != other.id)
            return false;

        return true;
    }

    public int compareTo(Media media) {
        if (this instanceof Book &&
                (media instanceof DigitalVideoDisc || media instanceof CompactDisc))
            return -1;
        if(this instanceof DigitalVideoDisc && media instanceof CompactDisc)
            return -1;
        if(this instanceof CompactDisc &&
                (media instanceof DigitalVideoDisc || media instanceof Book))
            return 1;
        if(this instanceof DigitalVideoDisc && media instanceof Book)
            return 1;
        return 0;
    }
}
