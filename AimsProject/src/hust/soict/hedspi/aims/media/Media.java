package hust.soict.hedspi.aims.media;

import java.util.Scanner;

public class Media {

    private String title;
    private String category;
    private float cost;
    private int id = 0;

    public Media() {

    }

    public Media(String title) {
        this.title = title;
    }

    public Media(String title, String category) {
        this(title);
        this.category = category;
    }

    public Media(String title, String category, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return this.cost;
    }

    public void setCost(float cost) {
        if (cost > 0) {
            this.cost = cost;
        }
        else this.cost = 0.0f;
    }

    protected void createMedia() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the title: ");
        this.title = sc.nextLine();
        System.out.println("Input the category: ");
        this.category = sc.nextLine();
        System.out.println("Input the cost: ");
        this.cost = sc.nextFloat();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "ID: "+ this.id + " - Title: " + this.title + " - Category: " + this.category + " - Price: " + this.cost;
    }
}
