package hust.soict.hedspi.aims.media.book;

import hust.soict.hedspi.aims.media.Media;

import java.util.*;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();
    private String content;
    public List<String> contentTokens = new ArrayList<String>();
    public Map<String, Integer> wordFrequency = new TreeMap<String, Integer>();

    public Book() {
        super();
    }

    public Book(int id,String title){
        super(id,title);
    }

    public Book(int id, String title, String category){
        super(id, title, category);
    }

    public Book(int id, String title, String category, float cost){
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

    public Book(int id, String title, String category, float cost, ArrayList<String> authors, String content) {
        super(id, title, category, cost);
        if (authors.size() != 0) {
            this.authors = authors;
            this.content = content;
        } else {
            System.out.println("Authors list is empty !");
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        processContent();
    }

    private  void processContent() {
        content = content.replace('.',' ');
        contentTokens.addAll(Arrays.asList(content.split("\\s+")));
        Collections.sort(contentTokens);
        for (String string : contentTokens) {
            if (!wordFrequency.containsKey(string)) {
                wordFrequency.put(string, 1);
            } else {
                int numOfToken = wordFrequency.get(string);
                numOfToken++;
                wordFrequency.put(string, numOfToken);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Id: ").append(super.id).append("\n");
        string.append("Title: ").append(super.title).append("\n");
        string.append("Category: ").append(super.category).append("\n");
        string.append("Cost: ").append(super.cost).append("\n");
        string.append("Author: ").append(getAuthors()).append("\n");
        string.append("Number of tokens: ").append(contentTokens.size()).append("\n");
        string.append("Work frequency \\tWord\\n");
        for(Map.Entry<String, Integer> entry: wordFrequency.entrySet()) {
            string.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");
        }
        return string.toString();
    }

    @Override
    public int compareTo(Object o) {
        return super.compareTo(o);
    }
}
