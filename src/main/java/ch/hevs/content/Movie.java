package ch.hevs.content;

public class Movie implements CatalogComponent {
    private String title;
    private String director;
    private String year;
    private int rating;

    public Movie(String title, String director, String year) {
        this.title = title;
        this.director = director;
        this.year = year;
        rating = 0;
    }

    public String getTitle() {
        return title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public void display() {
        System.out.println( title + " (" + year + ")" + " - " + director + " - " + rating + "/100");
    }

    @Override
    public String toString() {
        return title + " (" + year + ")" + " - " + director + " - " + rating + "/100";
    }
}
