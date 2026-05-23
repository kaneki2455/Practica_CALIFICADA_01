package service;

import model.Cart;
import observer.OrderObserver;
import strategy.DiscountStrategy;
import strategy.NoDiscountStrategy;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private Cart cart;
    private DiscountStrategy discountStrategy;
    private List<OrderObserver> observers = new ArrayList<>();

    public OrderService(Cart cart) {
        this.cart = cart;
        this.discountStrategy = new NoDiscountStrategy();
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public double ejecutarDescuento() {
        double total = cart.getTotal();
        System.out.println("Total sin descuento: S/ " + String.format("%.2f", total));
        double totalConDescuento = discountStrategy.applyDiscount(total);
        System.out.println("Total con descuento: S/ " + String.format("%.2f", totalConDescuento));
        return totalConDescuento;
    }

    public void confirmarOrden() {
        double total = ejecutarDescuento();
        String message = "Compra confirmada por S/ " + String.format("%.2f", total);
        System.out.println(message);
        for (OrderObserver observer : observers) {
            observer.update(message);
        }
    }
}