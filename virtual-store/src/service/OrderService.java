package service;

import model.Cart;
import strategy.DiscountStrategy;

public class OrderService {

    private Cart cart;
    private DiscountStrategy discountStrategy;

    public OrderService(Cart cart) {
        this.cart = cart;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double ejecutarDescuento() {
        double total = cart.getTotal();
        System.out.println("Total sin descuento: S/ " + String.format("%.2f", total));
        double totalConDescuento = discountStrategy.applyDiscount(total);
        System.out.println("Total con descuento: S/ " + String.format("%.2f", totalConDescuento));
        return totalConDescuento;
    }
}