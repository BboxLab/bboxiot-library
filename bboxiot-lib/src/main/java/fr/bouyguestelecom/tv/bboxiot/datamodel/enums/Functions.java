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

    NONE(0, "none"),
    SWITCH(1, "switch"),
    SMART_METER(2, "smart_meter"),
    BATTERY(3, "battery"),
    PLANT_MONITOR(4, "plant_monitor"),
    RGB_LED(5, "rgb_light"),
    WHITE_LED(6, "white_light"),
    OIL_DIFFUSER(7, "oil_diffuser"),
    TEMPERATURE(8, "thermometer"),
    HUMIDITY(9, "hygrometer"),
    BUTTON(10, "button"),
    BUZZER(11, "buzzer"),
    PIXEL(12, "pixel");

    private int value = 0;
    private String valueStr = "";

    private Functions(int value, String valueStr) {
        this.value = value;
        this.valueStr = valueStr;
    }

    public static Functions getFunctionValue(int value) {

        for (Functions function : Functions.values()) {
            if (value == function.value)
                return function;
        }
        return NONE;
    }

    public static Functions getFunctionStr(String value) {

        for (Functions function : Functions.values()) {
            if (value.equals(function.valueStr))
                return function;
        }
        return NONE;
    }
}
