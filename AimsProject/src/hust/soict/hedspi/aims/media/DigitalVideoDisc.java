package hust.soict.hedspi.aims.media;

import java.util.Scanner;

public class DigitalVideoDisc extends Media {
    // Attribute declaration
    private String director;
    private int length;

    // 1. Constructor không tham số
    public DigitalVideoDisc() {
        super();
    }

    // 2.Constructor có 1 tham số
    public DigitalVideoDisc(String title) {
        super(title);
    }

    // 3.Constructor có 2 tham số
    public DigitalVideoDisc(String title, String category) {
        super(title, category);
    }

    // 4.Constructor có 3, 4, 5, ... tham số
    public DigitalVideoDisc(String title, String category, String director) {
        super(title, category);
        this.director = director;
    }

    // 5.Constructor với tất cả các tham số
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }

    public void createDigitalVideoDisc() {
        super.createMedia();
        Scanner sc = new Scanner(System.in);
        System.out.println("Input Director: ");
        this.director = sc.nextLine();
        System.out.println("Input the length: ");
        this.length = sc.nextInt();
    }

    // get and set methods
    public String getDirector() {
        return this.director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength(){
        return this.length;
    }

    public void setLength(int length) {
        if (length > 0) {
            this.length = length;
        }
        else this.length = 0;

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
}
