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
 * Functions enum
 *
 * @author Bertrand Martel
 */
public enum Functions {

    NONE("none"),
    SWITCH("switch"),
    SMART_METER("smart_meter"),
    BATTERY("battery"),
    PLANT_MONITOR("plant_monitor"),
    RGB_LED("rgb_light"),
    WHITE_LED("white_light"),
    OIL_DIFFUSER("oil_diffuser"),
    TEMPERATURE("thermometer"),
    HUMIDITY("hygrometer"),
    BUTTON("button"),
    BUZZER("buzzer"),
    PIXEL("pixel");

    private String valueStr = "";

    private Functions(String valueStr) {
        this.valueStr = valueStr;
    }

    public static Functions getFunctionStr(String value) {

        for (Functions function : Functions.values()) {
            if (value.equals(function.valueStr))
                return function;
        }
        return NONE;
    }

    public String getValueStr() {
        return valueStr;
    }
}
