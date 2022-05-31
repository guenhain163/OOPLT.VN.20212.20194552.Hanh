package hust.soict.hedspi.aims.order;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.utils.MyDate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Order {
    // Declare 1 constant: maximum number of products per order
    public static final int MAX_NUMBER_ORDERED = 10;
    // Declare an array of DVD objects
    private final ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    private MyDate dateOrdered;
    public static final int MAX_LIMITED_ORDERED = 5;
    public static int nbOrders = 0;

    public Order() {

    }

    public void createOrder() {
        if (nbOrders >= MAX_LIMITED_ORDERED) {
            System.out.println("Over numbers of order!");
        } else {
            this.dateOrdered = new MyDate();
            nbOrders++;
        }
    }

    // get and set methods
    public int getQtyOrdered(){
        return this.itemsOrdered.size();
    }

    public void addMedia(Media media) {
        if (!(itemsOrdered.contains(media))) {
            this.itemsOrdered.add(media);
        }
    }

    public void addMedia(Media[] mediaList) {
        for (int i = 0; i < mediaList.length; i++) {
            this.addMedia(mediaList[i]);
        }
    }

    public void addMedia(Media media1, Media media2) {
        this.addMedia(media1);
        this.addMedia(media2);
    }

    public void removeMedia(Media media) {
        if (!(itemsOrdered.contains(media))) {
            this.itemsOrdered.remove(media);
        }
    }

    public void removeMedia(int ID) {
        boolean found = false;
        for(int i = 0; i < itemsOrdered.size(); i++) {
            if(itemsOrdered.get(i).getId() == ID) {
                itemsOrdered.remove(i);
                System.out.println("Successfully remove items with ID: " + ID);
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
        System.out.println("Ordered Items");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println(itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("**********************************\n");
    }

    // Xây dựng phương thức chọn một sản phẩm
    // ngẫu nhiên trong danh sách và miễn phí cho sản phẩm đó
    public Media getALuckyItem() {
        Random rd = new Random();
        int luckyNumber = rd.nextInt(this.itemsOrdered.size());
        this.itemsOrdered.get(luckyNumber).setCost(0);
        return this.itemsOrdered.get(luckyNumber);
    }
}
