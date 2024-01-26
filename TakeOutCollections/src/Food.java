// Create Food class here
public class Food implements PriceItem<Integer>{
    private String name;
    private String description;
    private int price;
    public Food(String name, String description, int price){
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public Integer getPrice(){
        return this.price;
    }
    @Override
    public void setPrice(Integer price){
        this.price = price;
    }
    @Override
    public String toString(){
        return String.format("Enjoy %s: %s. Cost: $%d",name, description, price);
    }
}