# Virtual Store - Patrones de Diseño en Java

## Descripción del problema


Se desarrolló una tienda virtual desde consola donde un cliente puede agregar productos a un carrito de compras, seleccionar una forma de pago, aplicar distintos métodos de descuento y recibir notificaciones automáticas al momento de confirmar una compra.

## Strategy - Descuentos
Se usó para manejar descuentos de forma flexible e intercambiable. NoDiscountStrategy, PorcentajeDiscountStrategy y FixedAmountDiscountStrategy implementan la interfaz DiscountStrategy y pueden cambiarse sin tocar la lógica del OrderService.

## Adapter - Métodos de pago
Se usó para integrar el servicio externo PayPal con la interfaz interna de la tienda. PayPalAdapter conecta ambos sin modificar ninguno. CreditCardPaymentProcessor implementa la interfaz directamente.

## Observer - Notificaciones
Se usó para notificar automáticamente a EmailNotificationObserver, InventoryObserver y AdminNotificationObserver cuando se confirma una compra mediante confirmarOrden().

![Salida Imagenes](C:\Users\Piero\Downloads\Main.png)

MarkDown