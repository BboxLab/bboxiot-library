/**
 * The MIT License (MIT)
 * <p/>
 * Copyright (c) 2015 BboxLab
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
package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.datamodel;

/**
 * Error codes
 *
 * @author Bertrand Martel Bouygues Telecom
 */
public enum PropertyError {

    NONE(0),
    
    /**
     * PUSH call has timeout
     */
    PUSH_TIMEOUT_ERROR(1),

    /**
     * PULL call has timeout
     */
    PULL_TIMEOUT_ERROR(2),

    /**
     * a gatt error occured. This is likely to be a connection issue
     */
    GATT_ERROR(3),

    /**
     * called when error is triggered by bluetooth workflow issue or other overflow issue (eg task list full)
     */
    PROCESS_ERROR(4), ;

    private final int value;

    private PropertyError(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public PropertyError getErrorId(int value) {

        switch (value) {
            case 1:
                return PUSH_TIMEOUT_ERROR;
            case 2:
                return PULL_TIMEOUT_ERROR;
            case 3:
                return GATT_ERROR;
            case 4:
                return PROCESS_ERROR;

        }
        return NONE;
    }
}
