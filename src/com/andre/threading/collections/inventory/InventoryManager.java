package com.andre.threading.collections.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InventoryManager {
    List<Product> soldProductsList = new CopyOnWriteArrayList<>();
    List<Product> purchasedProductsList = new ArrayList<>();

    public void populateSoldProductsList() {
        for (int i = 0; i < 1000; i++) {
            Product product = new Product(i, "test_product_" + i);
            soldProductsList.add(product);
            System.out.println("Added " + product);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("Problem in Sleep");
            }
        }
    }

    public void displaySoldProducts() {
        for (Product product : soldProductsList) {
            System.out.println("Sold Product: " + product);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("Problem in Sleep");
            }
        }
    }

}
