package br.com.joaogabriel.lambda.method.reference.model;

public class Anime {
    private String title;
    private int amountInStock;

    public Anime(String title, int amountInStock) {
        this.title = title;
        this.amountInStock = amountInStock;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAmountInStock() {
        return amountInStock;
    }

    public void setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "title='" + title + '\'' +
                ", amountInStock=" + amountInStock +
                '}';
    }
}
