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
 * @author Bertrand Martel
 */
public enum ScanRegistrationType {

    SCAN_EVENT_UNDEFINED(0),
    SCAN_EVENT_NEW_DEVICE_DISCOVERED(1),
    SCAN_EVENT_STATUS_CHANGE(2);

    private int value;

    private ScanRegistrationType(int value) {
        this.value = value;
    }

    public static ScanRegistrationType getType(int value) {

        switch (value) {
            case 0:
                return SCAN_EVENT_UNDEFINED;
            case 1:
                return SCAN_EVENT_NEW_DEVICE_DISCOVERED;
            case 2:
                return SCAN_EVENT_STATUS_CHANGE;
            default:
                return SCAN_EVENT_UNDEFINED;
        }
    }

}
