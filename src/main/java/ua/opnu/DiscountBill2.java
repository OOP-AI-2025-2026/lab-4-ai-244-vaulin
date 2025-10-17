package ua.opnu;

import ua.opnu.java.inheritance.bill.*;

public class DiscountBill2 {
    private GroceryBill bill;

    private final boolean regularCustomer;
    private int discountCount;
    private double discountAmount;

    public DiscountBill2(Employee clerk, boolean is_regular_customer) {
        this.bill = new GroceryBill(clerk);
        this.regularCustomer = is_regular_customer;
    }

    public void add(Item item) {
        bill.add(item);
        if (regularCustomer && item.getDiscount() > 0.0) {
            discountCount++;
            discountAmount += item.getDiscount();
        }
    }

    public double getTotal() {
        double total = bill.getTotal();
        if (regularCustomer) {
            total -= discountAmount;
        }
        return total;
    }

    public int getDiscountCount() {
        return regularCustomer ? discountCount : 0;
    }

    public Employee getClerk() { return bill.getClerk(); }

    public double getDiscountAmount() {
        return regularCustomer ? discountAmount : 0.0;
    }

    public double getDiscountPercent() {
        if (!regularCustomer) return 0.0;
        double totalWithoutDiscount = bill.getTotal();
        return (discountAmount / totalWithoutDiscount) * 100.0;
    }
}