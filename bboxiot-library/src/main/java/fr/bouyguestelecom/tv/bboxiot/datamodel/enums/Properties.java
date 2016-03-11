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
 * Properties enum
 * <p/>
 * List of all properties
 *
 * @author Bertrand Martel
 */
public enum Properties {

    NONE("none"),
    ONOFF("onoff"),
    CURRENT("current"),
    TENSION("tension"),
    POWER_FACTOR("power_factor"),
    ACTIVE_POWER("active_power"),
    REACTIVE_POWER("reactive_power"),
    FREQUENCY_MEASUREMENT("frequency_measurement"),
    STATE("state"),
    SUNLIGHT("sunlight"),
    AIR_TEMPERATURE("air_temperature"),
    SOIL_TEMPERATURE("soil_temperature"),
    SOIL_ELECTRODUCTIVITY("soil_electroductivity"),
    WATER_CONTENT("water_content"),
    COLOR("color"),
    INTENSITY("intensity"),
    TEMPERATURE("temperature"),
    SPEED("speed"),
    HUMIDITY("humidity");

    private String valueStr = "";

    private Properties(String valueStr) {
        this.valueStr = valueStr;
    }

    /**
     * Retrieve property object from property string
     *
     * @param valueStr
     * @return
     */
    public static Properties getPropertyStr(String valueStr) {

        for (Properties property : Properties.values()) {
            if (valueStr.equals(property.valueStr))
                return property;
        }
        return NONE;
    }

    /**
     * Retrieve property string
     *
     * @return
     */
    public String getValueStr() {
        return valueStr;
    }
}
