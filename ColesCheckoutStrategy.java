package unsw.shopping;

import java.util.List;

class ColesCheckoutStrategy extends CheckoutTemplate {
    private final String card = "flybuys";

    public String getCard() {
        return this.card;
    }

    public void printReciept(List<Item> items) {
        System.out.println("Today at Coles you purchased the following:");

        for (Item item : items) {
            System.out.println("- " + item.getName() + " : $" + item.getPrice());
        }
    }

    public void checkItemRestriction(List<Item> items) {
        if (items.size() > 20) {
            System.out.println("Too many items.");
        }
    }
}
