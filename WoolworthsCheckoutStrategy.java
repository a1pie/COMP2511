package unsw.shopping;

import java.util.List;

class WoolworthsCheckoutStrategy extends CheckoutTemplate {
    private final String card = "Everyday Rewards";

    public String getCard() {
        return this.card;
    }

    public void printReciept(List<Item> items) {
        System.out.print("Your purchase: ");

        for (int i = 0; i < items.size() - 1; i++) {
            System.out.print(items.get(i).getName() + ", ($" + items.get(i).getPrice() + "), ");
        }
        System.out
                .println(items.get(items.size() - 1).getName() + " ($" + items.get(items.size() - 1).getPrice() + ").");
    }

    public void checkItemRestriction(List<Item> items) {
        if (items.size() >= 55) {
            System.out.println("Sorry, that's more than we can handle in a single order!");
        }
    }
}
