package com.dscfgos.patterns.structural.proxy;

public class ProxyImage implements Image {
    private Image realImage;
    private final String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void showImage() {
        if (this.realImage == null) {
            this.realImage = new ExpensiveImage(this.fileName);
        }

        this.realImage.showImage();
    }
}
