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
package fr.bouyguestelecom.tv.bboxiot.datamodel;

/**
 * Error codes
 *
 * @author Bertrand Martel Bouygues Telecom
 */
public enum PropertyError {

    NONE("none"),

    /**
     * PUSH call has timeout
     */
    PUSH_TIMEOUT_ERROR("push_timeout_error"),

    /**
     * PULL call has timeout
     */
    PULL_TIMEOUT_ERROR("pull_timeout_error"),

    /**
     * a gatt error occured. This is likely to be a connection issue
     */
    GATT_ERROR("gatt_error"),

    /**
     * called when error is triggered by bluetooth workflow issue or other overflow issue (eg task list full)
     */
    PROCESS_ERROR("process_error"),;

    private String valueStr = "";

    private PropertyError(String valueStr) {
        this.valueStr = valueStr;
    }

    public static PropertyError getPropertyError(String value) {

        for (PropertyError propertyError : PropertyError.values()) {
            if (value.equals(propertyError.valueStr))
                return propertyError;
        }
        return NONE;
    }

    public String getValueStr() {
        return valueStr;
    }
}
