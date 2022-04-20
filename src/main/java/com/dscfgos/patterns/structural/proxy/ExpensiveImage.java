package com.dscfgos.patterns.structural.proxy;

public class ExpensiveImage implements Image {

    private final String fileName;

    public ExpensiveImage(String fileName) {
        this.fileName = fileName;
        this.loadImage(fileName);
    }

    @Override
    public void showImage() {
        System.out.println("Showing image: " + fileName);
    }

    private void loadImage(String fileName) {
        synchronized (this){
            try {
                System.out.printf("Image  '%s' Loading... %n", fileName);
                this.wait(2000);
                System.out.println("Completed!!!!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
