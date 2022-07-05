package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.exceptions.LimitExceedException;
import hust.soict.hedspi.aims.exceptions.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.book.Book;
import hust.soict.hedspi.aims.media.disc.CompactDisc;
import hust.soict.hedspi.aims.media.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.disc.Track;
import hust.soict.hedspi.aims.order.Order;

import javax.naming.LimitExceededException;
import java.util.ArrayList;
import java.util.Scanner;

public class Aims {

    // Use ArrayList to store data
    private static final ArrayList<Media> StoreMedias = new ArrayList<>();
    private static final ArrayList<Order> StoreOrders = new ArrayList<>();

    public static void main(String[] args) throws LimitExceedException, LimitExceededException {
        //option
        int option;
        int flagOption = 0;
        //orderID
        int orderID;
        int mediaID = 1;
        Scanner sc = new Scanner(System.in);
        while (true) {
            showMenu();
            option = sc.nextInt();
            switch (option) {
                case 1 -> {
                    if(Order.nbOrders < Order.MAX_NUMBERS_ORDERED) {
                        Order tempOrder = new Order();
                        StoreOrders.add(tempOrder);
                        System.out.println("MSG: An order has been created!");
                    } else {
                        System.err.println("ERR: You can't creat new order because number of orders is full!");
                    }
                    flagOption = 1;
                }
                case 2 -> {
                    if(flagOption == 0) {
                        System.err.println("ERR: Please create new order first by choosing option 1!");
                        break;
                    }
                    int subOption;
                    do {
                        showSubMenu();
                        subOption = sc.nextInt();
                        switch (subOption) {
                            case 1:
                                Book tempBook = createBook(mediaID);
                                StoreMedias.add(tempBook);
                                mediaID++;
                                System.out.println();
                                break;
                            case 2:
                                CompactDisc tempCD = createCompactDisc(mediaID);
                                StoreMedias.add(tempCD);
                                mediaID++;
                                System.out.println();
                                break;
                            case 3:
                                DigitalVideoDisc tempDVD = createDigitalVideoDisc(mediaID);
                                StoreMedias.add(tempDVD);
                                mediaID++;
                                System.out.println();
                                break;
                            case 4:
                                System.out.println("Enter OrderID:");
                                orderID = sc.nextInt();
                                System.out.println("Enter mediaID you want to add to Order: ");
                                mediaID = sc.nextInt();
                                StoreOrders.get(orderID - 1).addMedia(StoreMedias.get(mediaID - 1));
                                break;
                            case 5:
                                int i = 1;
                                System.out.printf("%-3s | %-6s | %-20s | %-15s |  %-5s \n", "STT", "ID", "Title", "Category", "Total");
                                for (Media storeMedia : StoreMedias) {
                                    System.out.printf("%-3s | %-6s | %-20s | %-15s | %.2f$\n",
                                            i, storeMedia.getId(), storeMedia.getTitle(), storeMedia.getCategory(), storeMedia.getCost());
                                    i++;
                                }
                                System.out.println();
                            case 0:
                                break;
                        }
                    } while (subOption != 0);
                }
                case 3 -> {
                    if(flagOption == 0) {
                        System.err.println("ERR: Please create new order first by choosing option 1!");
                        break;
                    }
                    System.out.print("Enter OrderID: ");
                    orderID = sc.nextInt();
                    if (orderID <= StoreOrders.size() && orderID > 0) {
                        System.out.print("Enter MediaID: ");
                        mediaID = sc.nextInt();
                        StoreOrders.get(orderID - 1).removeMedia(mediaID);
                    } else {
                        System.out.println("No order with ID: " + orderID);
                    }
                }
                case 4 -> {
                    if(flagOption == 0) {
                        System.err.println("ERR: Please create new order first by choosing option 1!");
                        break;
                    }
                    System.out.println("Choose which order you want to see ");
                    orderID = sc.nextInt();
                    if (orderID <= StoreOrders.size() && orderID > 0) {
                        StoreOrders.get(orderID - 1).printOrder();
                    } else {
                        System.out.println("No order with ID: " + orderID);
                    }
                }
                case 0 -> System.exit(0);
                default -> System.err.println("ERR: Wrong option, please choose again!");
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

    public static Book createBook(int MediaID) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter title: ");
        String title = sc.nextLine();
        System.out.print("Enter category: ");
        String category = sc.nextLine();
        System.out.print("Enter cost: ");
        float cost = sc.nextFloat();
        Book book = new Book(MediaID, title, category, cost);
        System.out.print("Enter number of authors: ");
        int numberAuthors = sc.nextInt();
        while(numberAuthors <= 0) {
            System.err.println("ERR: Number of authors must be than 0!");
            System.out.print("Enter number of authors: ");
            numberAuthors = sc.nextInt();
        }
        sc.nextLine();

        while(numberAuthors > 0) {
            System.out.print("Enter author's name: ");
            String author = sc.nextLine();
            book.addAuthor(author);
            numberAuthors--;
        }

        return book;
    }

    public static DigitalVideoDisc createDigitalVideoDisc(int MediaID) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter title: ");
        String title = keyboard.nextLine();
        System.out.print("Enter category: ");
        String category = keyboard.nextLine();
        System.out.print("Enter director: ");
        String director = keyboard.nextLine();
        System.out.print("Enter cost: ");
        float cost = keyboard.nextFloat();
        System.out.print("Enter length: ");
        int length = keyboard.nextInt();
        keyboard.nextLine();

        return new DigitalVideoDisc(MediaID, title, category, cost, director, length);
    }

    public static CompactDisc createCompactDisc(int MediaID) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter title: ");
        String title = sc.nextLine();
        System.out.print("Enter category: ");
        String category = sc.nextLine();
        System.out.print("Enter artist: ");
        String artist = sc.nextLine();
        System.out.print("Enter cost: ");
        float cost = sc.nextFloat();
        CompactDisc cd = new CompactDisc(MediaID, title, category, artist, cost);
        System.out.print("Number of tracks: ");
        int count = sc.nextInt();
        while(count <= 0) {
            System.err.println("Number of tracks must be than 0");
            System.out.print("Number of tracks: ");
            count = sc.nextInt();
        }
        sc.nextLine();
        Track track;
        String titleTrack;
        int lengthTrack;
        for(int i = 0; i < count; i++) {
            System.out.println("Track " + (i+1));
            System.out.print("Enter title of track: ");
            titleTrack = sc.nextLine();
            System.out.print("Enter length of track: ");
            lengthTrack = sc.nextInt();
            track = new Track(titleTrack, lengthTrack);
            cd.addTrack(track);
            sc.nextLine();
        }
        String ask;
        do {
            System.out.print("You want to listen? (yes/no)");
            ask = sc.nextLine();
            switch (ask) {
                case "yes":
                    System.out.println("===============================");
                    try {
                        cd.play();
                    } catch (PlayerException e) {
                        e.printStackTrace();
                    }
                    System.out.println("===============================");
                    break;
                case "no":
                    break;
                default:
                    System.err.println("ERR: Wrong syntax! Must yes or no");
            }
        } while (!ask.equalsIgnoreCase("yes") && !ask.equalsIgnoreCase("no"));

        return cd;
    }
}
