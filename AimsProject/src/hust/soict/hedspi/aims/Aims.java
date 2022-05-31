package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.order.Order;

import java.util.ArrayList;
import java.util.Scanner;

public class Aims {

    // Use ArrayList to store data
    private static ArrayList<Media> StoreMedias = new ArrayList<Media>();
    private static ArrayList<Order> StoreOrders = new ArrayList<Order>();


    public Aims() {

    }

    public static void main(String[] args) {
        //option
        int option;
        //orderID
        int orderID;
        int mediaID=0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            showMenu();
            option = sc.nextInt();
            switch (option) {
                case 1 -> {
                    Order tempOrder = new Order();
                    tempOrder.createOrder();
                    StoreOrders.add(tempOrder);
                }
                case 2 -> {
                    int subOption = -1;
                    while (subOption != 0) {
                        showSubMenu();
                        subOption = sc.nextInt();
                        switch (subOption) {
                            case 1:
                                Book tempBook = new Book();
                                tempBook.createBook();
                                tempBook.setId(mediaID);
                                System.out.println(tempBook.toString());
                                StoreMedias.add(tempBook);
                                mediaID++;
                                System.out.println();
                                break;
                            case 2:

                                break;
                            case 3:
                                DigitalVideoDisc tempDVD = new DigitalVideoDisc();
                                tempDVD.createDigitalVideoDisc();
                                tempDVD.setId(mediaID);
                                System.out.println(tempDVD.toString());
                                StoreMedias.add(tempDVD);
                                mediaID++;
                                System.out.println();
                                break;
                            case 4:
                                System.out.println("Enter OrderID:");
                                orderID = sc.nextInt();
                                System.out.println("Enter mediaID you want to add to Order: ");
                                mediaID = sc.nextInt();
                                StoreOrders.get(orderID).addMedia(StoreMedias.get(mediaID));
                                break;
                            case 5:
                                for (Media storeMedia : StoreMedias) {
                                    System.out.println(storeMedia.toString());
                                }
                                System.out.println();
                            case 0:
                                break;
                        }
                    }
                }
                case 3 -> {
                    System.out.print("Enter OrderID: ");
                    orderID = sc.nextInt();
                    if (orderID < StoreOrders.size()) {
                        System.out.print("Enter MediaID: ");
                        mediaID = sc.nextInt();
                        StoreOrders.get(orderID).removeMedia(mediaID);
                    } else {
                        System.out.println("No order with ID: " + orderID);
                    }
                }
                case 4 -> {
                    System.out.println("Choose which order you want to see ");
                    orderID = sc.nextInt();
                    if (orderID < StoreOrders.size()) {
                        StoreOrders.get(orderID).printOrder();
                    } else {
                        System.out.println("No order with ID: " + orderID);
                    }

                }
                case 0 -> System.exit(0);
            }

        }
    }

    public static void showMenu() {
        System.out.println("Order Management Application: ");
        System.out.println("--------------------------------");
        System.out.println("1. Create new order");
        System.out.println("2. Add item to the order");
        System.out.println("3. Delete item by id");
        System.out.println("4. Display the items list of order");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void showSubMenu() {
        System.out.println("Create Media ");
        System.out.println("--------------------------------");
        System.out.println("1. Book");
        System.out.println("2. CD");
        System.out.println("3. DVD");
        System.out.println("4. Add Media to Order by ID");
        System.out.println("5. List of Medias");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: ");
    }
}
