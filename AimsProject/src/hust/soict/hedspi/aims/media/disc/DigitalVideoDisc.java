package hust.soict.hedspi.aims.media.disc;

import hust.soict.hedspi.aims.exceptions.PlayerException;
import hust.soict.hedspi.aims.media.Media;

public class DigitalVideoDisc extends Disc implements Playable {
    // Attribute declaration
//    protected String director;
//    protected int length;
    private String message;

    public DigitalVideoDisc() {

    }

    public DigitalVideoDisc(int id, String title, String director, int length) {
        super(id, title, director, length);
    }

    public DigitalVideoDisc(int id, String title, String category, String director, int length) {
        super(id, title, category, director, length);
    }

    public DigitalVideoDisc(int id, String title, String category, float cost, String director, int length) {
        super(id, title, category, cost, director, length);
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

    public String getMessage(){
        return message;
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
    public String toString(){
        return "DVD - " + super.getTitle() + " - " + super.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + " : " + super.getCost() + " $";
    }

    public void play() throws PlayerException {
        if(this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
            message = "Playing DVD: " + this.getTitle() + "\n" + "DVD length: " + this.getLength();
        }else {
            throw new PlayerException("ERROR: DVD length is non-positive");
        }
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof DigitalVideoDisc) {
            if(this.getCost() < ((Media)o).getCost())
                return -1;
            else if(this.getCost() > ((Media)o).getCost())
                return 1;
            else{
                if(this.getLength()< ((DigitalVideoDisc) o).getLength())
                    return -1;
                else if(this.getLength() > ((DigitalVideoDisc) o).getLength())
                    return 1;
                else{
                    return super.compareTo(o);
                }
            }
        }else {
            return super.compareTo(o);
        }
    }
}
