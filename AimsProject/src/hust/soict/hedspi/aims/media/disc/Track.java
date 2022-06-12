package hust.soict.hedspi.aims.media.disc;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public Track() {

    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() {
        System.out.println("Playing Track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Track other = (Track) obj;
        if (length != other.length)
            return false;
        if (title == null)
            if (other.title != null)
                return false;
        else if (!title.equals(other.title))
            return false;

        return true;
    }

}
