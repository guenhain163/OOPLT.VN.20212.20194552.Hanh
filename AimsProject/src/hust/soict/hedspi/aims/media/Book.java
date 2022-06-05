package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book(int id, String title, float cost) {
        super(id, title, cost);
    }

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public Book(int id, String title, String category, float cost, ArrayList<String> authors) {
        super(id, title, category, cost);
        if (authors.size() != 0) {
            this.authors = authors;
        } else {
            System.out.println("Authors list is empty!");
        }
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName) {
        // ensure that the author is not already in
        // the ArrayList before adding
        if (!(authors.contains(authorName))) {
            authors.add(authorName);
        } else {
            System.out.println("ERR: Exist author name!");
        }
    }

    public void removeAuthor(String authorName) {
        // ensure that the author is not already in
        // the arrayList before removing
        if (!(authors.contains(authorName))) {
            authors.remove(authorName);
        }  else {
            System.err.println("ERR: Author name isn't existed!");
        }
    }

//    public void createBook() {
//        super.createMedia();
//        Scanner sc = new Scanner(System.in);
//        int authNum;
//        System.out.println("Enter numbers of authors: ");
//        authNum = sc.nextInt();
//        for(int i = 0; i < authNum; i++) {
//            Scanner sc2 = new Scanner(System.in);
//            String temp;
//            System.out.println("Enter author name: ");
//            temp = sc2.nextLine();
//            this.addAuthor(temp);
//        }
//    }
}
