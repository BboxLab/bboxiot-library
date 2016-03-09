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
package fr.bouyguestelecom.tv.bboxiot.events.enums;

/**
 * Scan registration type enum
 *
 * @author Bertrand Martel
 */
public enum ScanRegistrationType {

    SCAN_EVENT_UNDEFINED("scan_event_undefined"),
    SCAN_EVENT_NEW_DEVICE_DISCOVERED("scan_event_new_device_discovered"),
    SCAN_EVENT_STATUS_CHANGE("scan_event_status_change");

    private String valueStr = "";

    private ScanRegistrationType(String valueStr) {
        this.valueStr = valueStr;
    }

    public static ScanRegistrationType getScanRegistrationTypeStr(String value) {

        for (ScanRegistrationType scanRegistrationType : ScanRegistrationType.values()) {
            if (value.equals(scanRegistrationType.valueStr))
                return scanRegistrationType;
        }
        return SCAN_EVENT_UNDEFINED;
    }

    public String getValueStr() {
        return valueStr;
    }
}
