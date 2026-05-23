package strategy;

public class FixedAmountDiscountStrategy implements DiscountStrategy {
    private  double amount;

    public FixedAmountDiscountStrategy(double amount){
        this.amount= amount;
    }
    @Override
    public double applyDiscount(double total) {
        System.out.println("Descuento fijo: S/ " + String.format("%.2f", amount));
        return Math.max(0, total - amount);
    }
}
