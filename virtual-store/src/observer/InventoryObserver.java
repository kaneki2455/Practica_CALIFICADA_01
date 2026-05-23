package observer;

public class InventoryObserver implements OrderObserver {
    @Override
    public void update(String message) {
        System.out.println("[INVENTARIO] Actualizando inventario: " + message);
    }
}