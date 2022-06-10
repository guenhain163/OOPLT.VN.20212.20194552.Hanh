package hust.soict.hedspi.aims.media.book;

import hust.soict.hedspi.aims.media.Media;

import java.util.*;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();
    private String content;
    public List<String> contentTokens = new ArrayList<String>();
    public Map<String, Integer> wordFrequency = new TreeMap<String, Integer>();

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        processContent();
    }

    private  void processContent() {
        // split by \\s and convert Array<String> to List<String>
        // add all to contentTokens
        contentTokens.addAll(Arrays.asList(content.split("\\s+")));
        // contentToken has been sorted
        Collections.sort(contentTokens);
        // loop in List contentToken
        for (String string : contentTokens) {
            // if don't have key --> put to Map
            // else value++ --> put to Map
            if (!wordFrequency.containsKey(string)) {
                wordFrequency.put(string, 1);
            } else {
                int a = wordFrequency.get(string);
                a++;
                wordFrequency.put(string, a);
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
        string.append("Number of tokens: ").append(contentTokens.size()).append("\n");
        for(Map.Entry<String, Integer> entry: wordFrequency.entrySet()) {
            string.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");
        }
        return string.toString();
    }
}
