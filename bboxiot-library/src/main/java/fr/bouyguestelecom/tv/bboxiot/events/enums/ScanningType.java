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
 * Scanning type enum
 *
 * @author Bertrand Martel
 */
public enum ScanningType {

    SCANNING_TYPE_UNDEFINED("scanning_type_undefined"),
    SCANNING_TYPE_CONTINUOUS("scanning_type_continuous"),
    SCANNING_TYPE_PERMANENT("scanning_type_permanent"),
    SCANNING_TYPE_PERIODIC("scanning_type_periodic");

    private String valueStr = "";

    private ScanningType(String valueStr) {
        this.valueStr = valueStr;
    }

    public static ScanningType getScanningTypeStr(String value) {

        for (ScanningType scanningType : ScanningType.values()) {
            if (value.equals(scanningType.valueStr))
                return scanningType;
        }
        return SCANNING_TYPE_UNDEFINED;
    }

    public String getValueStr() {
        return valueStr;
    }
}
