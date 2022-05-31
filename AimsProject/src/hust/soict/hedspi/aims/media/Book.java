package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Book extends Media {

    private List<String> authors = new ArrayList<String>();

    public Book() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Book(String title) {
        super(title);
    }
    
    public Book(String title, String category) {
        super(title, category);
    }

    public Book(String title, String category, List<String> authors) {
        super(title, category);
        this.authors = authors;
    }

    public Book(String title, String category,float cost, ArrayList<String> authors){
        super(title, category, cost);
        this.authors = authors;
        //TODO: check author condition
    }

    public void addAuthor(String authorName) {
        // ensure that the author is not already in
        // the ArrayList before adding
        if (!(authors.contains(authorName))) {
            authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName) {
        // ensure that the author is not already in
        // the arrayList before removing
        if (!(authors.contains(authorName))) {
            authors.remove(authorName);
        }
    }

    public void createBook() {
        super.createMedia();
        Scanner sc = new Scanner(System.in);
        int authNum;
        System.out.println("Enter numbers of authors: ");
        authNum = sc.nextInt();
        for(int i = 0; i < authNum; i++) {
            Scanner sc2 = new Scanner(System.in);
            String temp;
            System.out.println("Enter author name: ");
            temp = sc2.nextLine();
            this.addAuthor(temp);
        }
    }
}
