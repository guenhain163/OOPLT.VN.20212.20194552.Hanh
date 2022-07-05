package hust.soict.hedspi.aims.media;

public abstract class Media implements Comparable<Object> {
    protected String title;
    protected String category;
    protected float cost;
    protected int id;

    public Media() {

    };

    public Media(int id, String title) {
        this.id = id;
        this.title = title;
    }
    public Media(int id, String title, String category) {
        this.id = id;
        this.title = title;
        this.category = category;
    }
    public Media(int id, String title, String category, float cost){
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public String getTitle() {
        return this.title;
    }

    public String getCategory() {
        return this.category;
    }

    public float getCost() {
        return this.cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public boolean equals(Object obj)  throws NullPointerException, ClassCastException {
        if (obj != null){
            if (obj instanceof Media){
                return this.getTitle().equalsIgnoreCase(((Media) obj).getTitle()) && this.getCost() == ((Media) obj).getCost();
            } else {
                throw new ClassCastException("ERROR: Object casting");
            }
        } else {
            throw new NullPointerException("ERROR: Null pointerexception");
        }
    }

    public int compareTo(Object obj) throws NullPointerException, ClassCastException {
        if (obj != null){
            if (obj instanceof Media){
                return this.title.compareTo(((Media) obj).getTitle());
            } else {
                throw new ClassCastException("ERROR: Object casting");
            }
        } else {
            throw new NullPointerException("ERROR: Null pointer exception");
        }
    }
}
