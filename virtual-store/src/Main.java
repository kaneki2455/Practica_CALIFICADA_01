import adapter.ExternalPayPalService;
import adapter.PayPalAdapter;
import adapter.PaymentProcessor;
import model.Cart;
import model.Product;
import observer.AdminNotificationObserver;
import observer.EmailNotificationObserver;
import observer.InventoryObserver;
import service.OrderService;
import strategy.PorcentajeDiscountStrategy;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== TIENDA VIRTUAL ===\n");

        System.out.println("--- Productos agregados ---");
        Product laptop = new Product("Laptop", 1200.00);
        Product mouse = new Product("Mouse", 80.00);
        Product teclado = new Product("Teclado", 150.00);

        Cart cart = new Cart();
        cart.addProduct(laptop);
        cart.addProduct(mouse);
        cart.addProduct(teclado);

        OrderService orderService = new OrderService(cart);
        orderService.setDiscountStrategy(new PorcentajeDiscountStrategy(10));

        orderService.addObserver(new EmailNotificationObserver());
        orderService.addObserver(new InventoryObserver());
        orderService.addObserver(new AdminNotificationObserver());

        System.out.println("\n--- Descuento ---");
        double total = orderService.ejecutarDescuento();

        System.out.println("\n--- Método de Pago ---");
        PaymentProcessor paymentProcessor = new PayPalAdapter(new ExternalPayPalService());
        paymentProcessor.pay(total);

        System.out.println("\n--- Confirmación ---");
        orderService.confirmarOrden();
    }
}