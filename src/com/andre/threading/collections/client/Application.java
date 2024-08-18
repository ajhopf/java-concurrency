package com.andre.threading.collections.client;

import com.andre.threading.collections.inventory.InventoryManager;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        InventoryManager inventoryManager = new InventoryManager();

        Thread inventoryTask = new Thread(new Runnable() {
            @Override
            public void run() {
                inventoryManager.populateSoldProductsList();
            }
        });

        Thread displayTask = new Thread(new Runnable() {
            @Override
            public void run() {
                inventoryManager.displaySoldProducts();
            }
        });

        inventoryTask.start();

        Thread.sleep(2000);

        displayTask.start();
    }
}
