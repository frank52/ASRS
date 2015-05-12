package ASRS;

/**
 * Created by Willem on 12-5-2015.
 */
public interface Algoritme {

    void Algoritme(Order order);

    Order getOrder();

    Route getRoute();

    void berekenRoute(Order order);
}
