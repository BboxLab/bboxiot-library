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
public enum ConnectionState {

    UNDEFINED(0),
    ASSOCIATION_COMPLETE(1),
    CONNECTED(2),
    DISCONNECTED(3),
    DEVICE_NOT_FOUND(4),
    CONNECTION_ERROR(5),
    CONNECTION_IDLE(6);

    private int value;

    private ConnectionState(int value) {
        this.value = value;
    }

    public static ConnectionState getState(int value) {

        switch (value) {
            case 0:
                return UNDEFINED;
            case 1:
                return ASSOCIATION_COMPLETE;
            case 2:
                return CONNECTED;
            case 3:
                return DISCONNECTED;
            case 4:
                return DEVICE_NOT_FOUND;
            case 5:
                return CONNECTION_ERROR;
            case 6:
                return CONNECTION_IDLE;
            default:
                return UNDEFINED;
        }
    }
}
