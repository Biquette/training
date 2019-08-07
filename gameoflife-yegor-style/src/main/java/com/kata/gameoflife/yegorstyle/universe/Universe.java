package com.kata.gameoflife.yegorstyle.universe;

import com.kata.gameoflife.yegorstyle.printer.Printer;

public interface Universe {

    void goForwardInTime(int turns);

    Printer print(Printer media);

}