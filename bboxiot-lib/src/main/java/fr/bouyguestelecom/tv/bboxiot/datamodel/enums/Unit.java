/**
 * The MIT License (MIT)
 * <p/>
 * Copyright (c) 2015 InnovationLab BboxLab
 * <p/>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p/>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p/>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * TH
 * package fr.bouyguestelecom.tv.bboxiot.datamodel;
 * <p/>
 * /**
 *
 * @author Bertrand Martel
 */
package fr.bouyguestelecom.tv.bboxiot.datamodel.enums;

/**
 * @author Bertrand Martel
 */
public enum Unit {

    NONE(0),
    CELSIUS(1),
    PURCENT(2),
    VOLTAGE(3),
    AMPERE(4),
    SECOND(5),
    WATT(6);

    private int value = 0;

    private Unit(int value) {
        this.value = value;
    }

    public static Unit getUnit(int value) {

        switch (value) {
            case 0:
                return NONE;
            case 1:
                return CELSIUS;
            case 2:
                return PURCENT;
            case 3:
                return VOLTAGE;
            case 4:
                return AMPERE;
            case 5:
                return SECOND;
            case 6:
                return WATT;
        }
        return NONE;
    }

    public static String getUnitStr(Unit value) {

        switch (value) {
            case CELSIUS:
                return "°C";
            case PURCENT:
                return "%";
            case VOLTAGE:
                return "V";
            case AMPERE:
                return "A";
            case SECOND:
                return "s";
            case WATT:
                return "W";
        }
        return "";
    }

}
