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
public enum Functions {

    NONE(0),
    SWITCH(1),
    SMART_METER(2),
    BATTERY(3),
    PLANT_MONITOR(4),
    RGB_LED(5),
    WHITE_LED(6),
    OIL_DIFFUSER(7),
    TEMPERATURE(8),
    HUMIDITY(9),
    BUTTON(10),
    BUZZER(11),
    PIXEL(12);

    private int value = 0;

    private Functions(int value) {
        this.value = value;
    }

    public static Functions getFunction(int value) {

        switch (value) {
            case 0:
                return NONE;
            case 1:
                return SWITCH;
            case 2:
                return SMART_METER;
            case 3:
                return BATTERY;
            case 4:
                return PLANT_MONITOR;
            case 5:
                return RGB_LED;
            case 6:
                return WHITE_LED;
            case 7:
                return OIL_DIFFUSER;
            case 8:
                return TEMPERATURE;
            case 9:
                return HUMIDITY;
            case 10:
                return BUTTON;
            case 11:
                return BUZZER;
            case 12:
                return PIXEL;
        }
        return NONE;
    }
}
