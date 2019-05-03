package model;

public class Item {
    private String ItemName;
    private int ItemPrice;
    private int ItemImageName;
    private String ItemDescription;



    public Item(String itemName, int itemPrice, int itemImageName, String itemDescription) {
        ItemName = itemName;
        ItemPrice = itemPrice;
        ItemImageName = itemImageName;
        ItemDescription = itemDescription;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public int getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(int itemPrice) {
        ItemPrice = itemPrice;
    }

    public int getItemImageName() {
        return ItemImageName;
    }

    public void setItemImageName(int itemImageName) {
        ItemImageName = itemImageName;
    }

    public String getItemDescription() {
        return ItemDescription;
    }

    public void setItemDescription(String itemDescription) {
        ItemDescription = itemDescription;
    }

}
