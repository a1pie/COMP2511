package unsw.shopping;

import java.util.List;

abstract class CheckoutTemplate {
    private int amountPurchased;

    public void checkout(List<Item> items, String paymentMethod, int paymentAmount, boolean receipt) {
        System.out.println("Welcome! Please scan your first item. If you have a " + getCard()
                + " card, please scan it at any time.");

        scanItems(items);

        if (!paymentChecks(paymentAmount, paymentMethod))
            return;

        if (receipt)
            printReciept(items);
    }

    public void scanItems(List<Item> items) {
        checkItemRestriction(items);

        if (items.size() == 0) {
            System.out.println("You do not have any items to purchase.");
            return;
        }

        for (Item item : items) {
            amountPurchased += item.getPrice();
        }
    }

    public boolean paymentChecks(int paymentAmount, String paymentMethod) {
        if (paymentAmount < amountPurchased) {
            System.out.println("Not enough $$$.");
            return false;
        }

        if (paymentMethod.equals("cash")) {
            System.out.println("Paid $" + paymentAmount + " with $" + (paymentAmount - amountPurchased) + " change.");
        } else {
            paymentAmount = amountPurchased;
            System.out.println("Paid $" + paymentAmount + ".");
        }

        return true;
    }

    public abstract void checkItemRestriction(List<Item> items);

    public abstract void printReciept(List<Item> items);

    public abstract String getCard();
}
