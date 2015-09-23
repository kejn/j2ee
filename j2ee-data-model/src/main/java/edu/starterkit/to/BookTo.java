package edu.starterkit.to;

public class BookTo implements IdAware {
    private Long id;
    private String title;
    private String authors;

    public BookTo() {
    }

    public BookTo(Long id, String title, String authors) {
        this.id = id;
        this.title = title;
        this.authors = authors;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }
    
    @Override
    public String toString() {
    	StringBuilder stringBuilder = new StringBuilder();
    	stringBuilder.append("@" + getClass().getSimpleName());
    	stringBuilder.append("[id=" + id);
    	stringBuilder.append(",title=" + title);
    	stringBuilder.append(",authors=" + authors + "]");
    	return stringBuilder.toString();
    }
}
