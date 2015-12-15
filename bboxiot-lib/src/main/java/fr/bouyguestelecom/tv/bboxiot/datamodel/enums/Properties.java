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

    NONE(0),
    ONOFF(1),
    CURRENT(2),
    TENSION(3),
    POWER_FACTOR(4),
    ACTIVE_POWER(5),
    REACTIVE_POWER(6),
    FREQUENCY_MEASUREMENT(7),
    STATE(8),
    SUNLIGHT(9),
    AIR_TEMPERATURE(10),
    SOIL_TEMPERATURE(11),
    SOIL_ELECTRODUCTIVITY(12),
    WATER_CONTENT(13),
    COLOR(14),
    INTENSITY(15),
    TEMPERATURE(16),
    SPEED(17),
    HUMIDITY(18);

    private int value = 0;

    private Properties(int value) {
        this.value = value;
    }

    public static Properties getProperty(int value) {

        switch (value) {
            case 0:
                return NONE;
            case 1:
                return ONOFF;
            case 2:
                return CURRENT;
            case 3:
                return TENSION;
            case 4:
                return POWER_FACTOR;
            case 5:
                return ACTIVE_POWER;
            case 6:
                return REACTIVE_POWER;
            case 7:
                return FREQUENCY_MEASUREMENT;
            case 8:
                return STATE;
            case 9:
                return SUNLIGHT;
            case 10:
                return AIR_TEMPERATURE;
            case 11:
                return SOIL_TEMPERATURE;
            case 12:
                return SOIL_ELECTRODUCTIVITY;
            case 13:
                return WATER_CONTENT;
            case 14:
                return COLOR;
            case 15:
                return INTENSITY;
            case 16:
                return TEMPERATURE;
            case 17:
                return SPEED;
            case 18:
                return HUMIDITY;
        }
        return NONE;
    }
}
