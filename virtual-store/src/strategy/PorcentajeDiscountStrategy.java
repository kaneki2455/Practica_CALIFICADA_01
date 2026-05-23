package strategy;

public class PorcentajeDiscountStrategy implements DiscountStrategy{
    private double porcentaje;
    public PorcentajeDiscountStrategy(double porcentaje){
       this.porcentaje=porcentaje;
    }
@Override
public double applyDiscount(double total) {
    double discount = total * (porcentaje / 100);
    System.out.println("Descuento porcentual (" + porcentaje + "%): S/ " + String.format("%.2f", discount));
    return total - discount;
}
}
