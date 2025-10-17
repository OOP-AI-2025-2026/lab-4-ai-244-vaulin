package ua.opnu;

import ua.opnu.java.inheritance.bill.*;

public class DiscountBill extends GroceryBill {
    private final boolean regularCustomer;
    private int discountCount;
    private double discountAmount;

    public DiscountBill(Employee clerk, boolean is_regular_customer) {
        super(clerk);
        this.regularCustomer = is_regular_customer;
    }

    @Override
    public void add(Item item) {
        super.add(item);
        if (regularCustomer && item.getDiscount() > 0.0) {
            discountCount++;
            discountAmount += item.getDiscount();
        }
    }

    @Override
    public double getTotal() {
        double total = super.getTotal();
        if (regularCustomer) {
            total -= discountAmount;
        }
        return total;
    }

    public int getDiscountCount() {
        return regularCustomer ? discountCount : 0;
    }

    public double getDiscountAmount() {
        return regularCustomer ? discountAmount : 0.0;
    }

    public double getDiscountPercent() {
        if (!regularCustomer) return 0.0;
        double totalWithoutDiscount = super.getTotal();
        return (discountAmount / totalWithoutDiscount) * 100.0;
    }
}