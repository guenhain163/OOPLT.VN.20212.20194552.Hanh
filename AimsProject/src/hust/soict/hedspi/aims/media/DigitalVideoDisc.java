package hust.soict.hedspi.aims.media;

import java.util.Scanner;

public class DigitalVideoDisc extends Disc implements Playable {
    // Attribute declaration
    private String director;
    private int length;

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

//    public void createDigitalVideoDisc() {
//        super.createMedia();
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Input Director: ");
//        this.director = sc.nextLine();
//        System.out.println("Input the length: ");
//        this.length = sc.nextInt();
//    }

    // get and set methods
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

    // Method to print information of DVD object
//    public void printInfo(){
//        System.out.println("------------DVD Info------------");
//        System.out.println("Title: " + this.title);
//        System.out.println("Category: " + this.category);
//        System.out.println("Director: " + this.director);
//        System.out.println("Length: " + this.length);
//        System.out.println("Cost: " + this.cost);
//    }

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
}
