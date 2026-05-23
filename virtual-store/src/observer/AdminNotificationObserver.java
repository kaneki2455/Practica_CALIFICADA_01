package observer;

public class AdminNotificationObserver implements OrderObserver {
    @Override
    public void update(String message) {
        System.out.println("[ADMIN] Notificando al administrador: " + message);
    }
}