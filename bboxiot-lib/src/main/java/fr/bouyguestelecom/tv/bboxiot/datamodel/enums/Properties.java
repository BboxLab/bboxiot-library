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
public enum Properties {

    NONE(0, "none"),
    ONOFF(1, "onoff"),
    CURRENT(2, "current"),
    TENSION(3, "tension"),
    POWER_FACTOR(4, "power_factor"),
    ACTIVE_POWER(5, "active_power"),
    REACTIVE_POWER(6, "reactive_power"),
    FREQUENCY_MEASUREMENT(7, "frequency_measurement"),
    STATE(8, "state"),
    SUNLIGHT(9, "sunlight"),
    AIR_TEMPERATURE(10, "air_temperature"),
    SOIL_TEMPERATURE(11, "soil_temperature"),
    SOIL_ELECTRODUCTIVITY(12, "soil_electroductivity"),
    WATER_CONTENT(13, "water_content"),
    COLOR(14, "color"),
    INTENSITY(15, "intensity"),
    TEMPERATURE(16, "temperature"),
    SPEED(17, "speed"),
    HUMIDITY(18, "humidity");

    private int value = 0;
    private String valueStr = "";

    private Properties(int value, String valueStr) {
        this.value = value;
        this.valueStr = valueStr;
    }

    public static Properties getPropertyValue(int value) {

        for (Properties property : Properties.values()) {
            if (value == property.value)
                return property;
        }
        return NONE;
    }

    public static Properties getPropertyStr(String valueStr) {

        for (Properties property : Properties.values()) {
            if (valueStr.equals(property.valueStr))
                return property;
        }
        return NONE;
    }
}
