package hust.soict.hedspi.aims.order;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.utils.MyDate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Order {
    // Declare 1 constant: maximum number of products per order
    public static final int MAX_NUMBERS_ORDERED = 10;
    public static final int MAX_LIMITED_ORDERED = 5;
    // Declare an array of DVD objects
    private final ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    private MyDate dateOrdered = new MyDate();
    public static int nbOrders = 0;

    public Order() {
        if (nbOrders >= MAX_LIMITED_ORDERED) {
            System.out.println("Over numbers of order!");
        } else {
            nbOrders++;
        }
    }

    // get and set methods
    public int getQtyOrdered(){
        return this.itemsOrdered.size();
    }

    public MyDate getDateOrdered() {
        return dateOrdered;
    }

    public static Order getOrder() {
        if(nbOrders < MAX_LIMITED_ORDERED) {
            Order newOrder = new Order();
            nbOrders++;
            System.out.println("Creat new order successfully!");
            return newOrder;
        } else {
            System.out.println("The numbers of orders is almost max.");
            return null;
        }
    }

    public void addMedia(Media media) {
        if (!(itemsOrdered.contains(media))) {
            this.itemsOrdered.add(media);
            System.out.println("MSG: The media with title: " + media.getTitle() + " has been added.");
        } else {
            System.err.println("ERR: The media with title: " + media.getTitle() + " is existed!");
        }
    }

    public void addMedia(Media[] mediaList) {
        for (Media media : mediaList) {
            this.addMedia(media);
        }
    }

    public void addMedia(Media media1, Media media2) {
        this.addMedia(media1);
        this.addMedia(media2);
    }

    public void removeMedia(Media media) {
        if(itemsOrdered.contains(media)) {
            System.out.println("MSG: Media with ID: " + media.getId() + " has been deleted!");
            this.itemsOrdered.remove(media);
        }else {
            System.err.println("ERR: The media may not exist!");
        }
    }

    public void removeMedia(int ID) {
        boolean found = false;
        for(Media media: itemsOrdered) {
            if(media.getId() == ID) {
                removeMedia(media);
//                System.out.println("Successfully remove items with ID: " + ID);
                found = true;
                break;
            }
        }

        if (!found) System.out.println("No items with ID: " + ID);

        System.out.println();
    }

    public float totalCost(){
        // store the running total of the items in the order
        float total = 0;
        Media mediaItem;
        Iterator<Media> iter = itemsOrdered.iterator();
        while (iter.hasNext()) {
            mediaItem = (Media) (iter.next());
            total += mediaItem.getCost();
        }
        return total;
    }

    public void printOrder() {
        System.out.println();
        System.out.println("*************Order****************");
        System.out.print("Date: ");
        dateOrdered.printFormat("d/M/yyyy");
        System.out.println("Ordered Items:");
        int i = 1;
        System.out.printf("%-3s | %-6s | %-20s | %-15s |  %-5s ", "STT", "ID", "Title", "Category", "Total");
        System.out.println();
        for(Media media: itemsOrdered) {
            System.out.printf("%-3s | %-6s | %-20s | %-15s | %.2f$\n",
                    i, media.getId(), media.getTitle(), media.getCategory(), media.getCost());
            i++;
        }
        System.out.printf("Total cost: %.2f$\n", totalCost());
        System.out.println("**********************************\n");
    }

    // Xây dựng phương thức chọn một sản phẩm
    // ngẫu nhiên trong danh sách và miễn phí cho sản phẩm đó
    public Media getALuckyItem() {
        Random rd = new Random();
        int luckyNumber = rd.nextInt(this.itemsOrdered.size());
//        this.itemsOrdered.get(luckyNumber).setCost(0);
        return this.itemsOrdered.get(luckyNumber);
    }
}
