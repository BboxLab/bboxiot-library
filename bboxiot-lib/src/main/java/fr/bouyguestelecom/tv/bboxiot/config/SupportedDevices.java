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
 * THE SOFTWARE.
 */
package fr.bouyguestelecom.tv.bboxiot.config;

/**
 * @author Bertrand Martel
 */
public enum SupportedDevices {

    UNDEFINED(0),
    BEEWI_SMARTLITE(1),
    BEEWI_SMARTCLIM(2),
    BEEWI_SMARTRACK(3),
    ALTYOR_NIU(4),
    WITTY_NOTTI(5),
    WITTY_DOTTI(6),
    AWOX_SMARTPLUG(7),
    DICE_DICEPLUS(8),
    AWOX_AROMALIGHT(9),
    AWOX_SMARTLIGHT(10),
    AWOX_SMARTLIGHT_COLOR(11),
    IWEDIA_RTRK(12),
    PARROT_FLOWERPOWER(13);

    private int value;

    private SupportedDevices(int value) {
        this.value = value;
    }

    public static SupportedDevices getDevice(int value) {

        switch (value) {
            case 0:
                return UNDEFINED;
            case 1:
                return BEEWI_SMARTLITE;
            case 2:
                return BEEWI_SMARTCLIM;
            case 3:
                return BEEWI_SMARTRACK;
            case 4:
                return ALTYOR_NIU;
            case 5:
                return WITTY_NOTTI;
            case 6:
                return WITTY_DOTTI;
            case 7:
                return AWOX_SMARTPLUG;
            case 8:
                return DICE_DICEPLUS;
            case 9:
                return AWOX_AROMALIGHT;
            case 10:
                return AWOX_SMARTLIGHT;
            case 11:
                return AWOX_SMARTLIGHT_COLOR;
            case 12:
                return IWEDIA_RTRK;
            case 13:
                return PARROT_FLOWERPOWER;
            default:
                return UNDEFINED;
        }
    }
}
