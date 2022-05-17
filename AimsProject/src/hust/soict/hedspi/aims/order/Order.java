package hust.soict.hedspi.aims.order;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.utils.MyDate;

public class Order {
    // Declare 1 constant: maximum number of products per order
    public static final int MAX_NUMBER_ORDERED = 10;
    // Declare an array of DVD objects
    private final DigitalVideoDisc[] itemOrdered = new DigitalVideoDisc[MAX_NUMBER_ORDERED];

    // Declare an attribute containing the number of products currently in the order
    private int qtyOrdered = 0;

    private MyDate dateOrdered;
    public static final int MAX_LIMMITED_ORDERED = 5;
    public static int nbOrders = 0;

    public Order() {
        if (this.nbOrders == MAX_LIMMITED_ORDERED) {
            System.out.println("Over numbers of order!");
        } else {
            this.qtyOrdered = 0;
            this.dateOrdered = new MyDate();
            nbOrders++;
        }
    }

    // get and set methods
    public int getQtyOrdered(){
        return this.qtyOrdered;
    }

    public void setQtyOrdered(int qtyOrdered){
        if (qtyOrdered >= 0) {
            this.qtyOrdered = qtyOrdered;
        }
    }

    // Method to add a DVD object to the order
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if (this.qtyOrdered == MAX_NUMBER_ORDERED) {
            System.out.println("The order is almost full");
        }
        else{
            itemOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
            System.out.println("Total disc: " + this.qtyOrdered);
        }
    }

    // Method overloading
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        if (this.qtyOrdered == MAX_NUMBER_ORDERED || this.qtyOrdered + dvdList.length > MAX_NUMBER_ORDERED) {
            System.out.println("The order is full.");
        } else {
            for (int i = 0; i < dvdList.length; i++)
                this.addDigitalVideoDisc(dvdList[i]);
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        this.addDigitalVideoDisc(dvd1);
        this.addDigitalVideoDisc(dvd2);
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        DigitalVideoDisc[] discOrderTemp = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
        int index = 0;
        int count = 0;
        if (this.qtyOrdered == 0) {
            System.out.println("Nothing in your order list");
        }
        else{
            for(int i = 0; i < qtyOrdered; i++){
                if (itemOrdered[i] == disc) {
                    index = i;
                    count++;
                    break;                
                }
            }
            if (count == 0) {
                System.out.println("Haven't any item that you want to delete in your order list");
            }
            else{
                qtyOrdered = qtyOrdered-1;
                for(int i = index; i < qtyOrdered; i++){
                    itemOrdered[i] = itemOrdered[i+1];
                }
                System.out.println("Delete successed");
            }
        }
    }

    public float totalCost(){
        float total = 0.0f;
        for(int i = 0; i < this.qtyOrdered; i++)
        {
            total += itemOrdered[i].getCost();
        }
        return total;
    }

    // Phương thức in đơn hàng
    public void printOrder() {
        System.out.println("***********************hust.soict.hedspi.aims.order.Order***********************");
        System.out.println("Date: " + this.dateOrdered);
        System.out.println("Ordered Items:");
        for (int i = 0; i < this.qtyOrdered; i++) {
            System.out.println((i + 1) + ". DVD - " + itemOrdered[i].getTitle() + " - " +
                    itemOrdered[i].getCategory() + " - " +
                    itemOrdered[i].getDirector() + " - " + itemOrdered[i].getLength() + ": " + itemOrdered[i].getCost() + " $");
        }
        System.out.printf("Total cost: %.2f\n", totalCost());
        System.out.println("***************************************************");
    }


    // Xây dựng phương thức chọn một sản phẩm
    // ngẫu nhiên trong danh sách và miễn phí cho sản phẩm đó
    public DigitalVideoDisc getALuckyItem() {
        Random rd = new Random();
        int luckyNumber = rd.nextInt(this.qtyOrdered);
        this.itemOrdered[luckyNumber].setCost(0);
//        for (int i = 0; i < this.qtyOrdered; i++) {
//            if (i == luckyNumber) {
//                this.itemOrdered[i].setCost(0);
//                break;
//            }
//        }
        return this.itemOrdered[luckyNumber];
    }
}
