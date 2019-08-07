package com.kata.gameoflife.yegorstyle.printer;

public class CustomStringPrinter implements Printer {

    private StringBuilder content;

    public CustomStringPrinter() {
        this.content = new StringBuilder(256);
    }

    public CustomStringPrinter(StringBuilder content) {
        this.content = content;
    }

    @Override
    public Printer with(String value) {
        return new CustomStringPrinter(content.append(value));
    }


    public String toCustomString() {
        return this.content.toString();
    }
}