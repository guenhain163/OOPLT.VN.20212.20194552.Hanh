package hust.soict.hedspi.aims.disc;

public class DigitalVideoDisc {
    // Attribute declaration
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    // get and set methods
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

    public float getCost() {
        return this.cost;
    }

    public void setCost(float cost) {
        if (cost > 0) {
            this.cost = cost;
        }
        else this.cost = 0.0f;
    }

    // 1. Constructor không tham số
    public DigitalVideoDisc() {
        this.title = "noname";
        this.category = "unknown";
        this.director = "unknown";
        this.length = 0;
        this.cost = 0.0f;
    }

    // 2.Constructor có 1 tham số
    public DigitalVideoDisc(String title) {
        this.title = title;
    }

    // 3.Constructor có 2 tham số
    public DigitalVideoDisc(String title, String category) {
        this.title = title;
        this.category = category;
    }

    // 4.Constructor có 3, 4, 5, ... tham số
    public DigitalVideoDisc(String title, String category, String director) {
        this.title = title;
        this.category = category;
        this.director = director;
    }

    // 5.Constructor với tất cả các tham số
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    // Method to print information of DVD object
    public void printInfo(){
        System.out.println("------------DVD Info------------");
        System.out.println("Title: " + this.title);
        System.out.println("Category: " + this.category);
        System.out.println("Director: " + this.director);
        System.out.println("Length: " + this.length);
        System.out.println("Cost: " + this.cost);
    }

    // Xây dựng phương thức tìm kiếm theo title
    public boolean search(String title) {
        // Tách title của tham số cần tìm thành các từ
        // --> phục vụ cho việc xử lý tìm kiếm
//        String sTitle[] = title.split(" ");
//        String sTitleDVD[] = this.title.split(" ");
//
//        for (int i = 0; i < sTitle.length; i++) {
//            for (int j = 0; j < sTitleDVD.length; j++) {
//                if (sTitleDVD[j].equalsIgnoreCase(sTitle[i])) {
//
//                }
//            }
//        }

        if (this.title.equalsIgnoreCase(sTitle)) {
            return true;
        }
        return false;
    }
}
