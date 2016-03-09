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
 * Supported device list
 *
 * @author Bertrand Martel
 */
public enum SupportedDevices {

    UNDEFINED("undefined"),
    BEEWI_SMARTLITE("beewi_smartlite"),
    BEEWI_SMARTCLIM("beewi_smartclim"),
    BEEWI_SMARTRACK("beewi_smartrack"),
    ALTYOR_NIU("altyor_niu"),
    WITTY_NOTTI("witty_notti"),
    WITTY_DOTTI("witty_dotti"),
    AWOX_SMARTPLUG("awox_smartplug"),
    DICE_DICEPLUS("dice_diceplus"),
    AWOX_AROMALIGHT("awox_aromalight"),
    AWOX_SMARTLIGHT("awox_smartlight"),
    AWOX_SMARTLIGHT_COLOR("awox_smartlight_color"),
    IWEDIA_RTRK("iwedia_rtrk"),
    PARROT_FLOWERPOWER("parrot_flowerpower");

    private String valueStr = "";

    private SupportedDevices(String valueStr) {
        this.valueStr = valueStr;
    }

    public static SupportedDevices getSupportedDeviceStr(String value) {

        for (SupportedDevices action : SupportedDevices.values()) {
            if (value.equals(action.valueStr))
                return action;
        }
        return UNDEFINED;
    }

    public String getValueStr() {
        return valueStr;
    }

}
