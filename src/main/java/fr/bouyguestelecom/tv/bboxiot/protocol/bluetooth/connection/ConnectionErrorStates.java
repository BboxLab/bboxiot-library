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
package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.connection;

/**
 * Enum used for connection error
 *
 * @author Bertrand Martel Bouygues Telecom
 */
public enum ConnectionErrorStates {

    GATT_CONNECTED_TIMEOUT(0),
    GATT_DISCOVERY_TIMEOUT(1),
    GATT_INTERNAL_ERROR(2),
    SMART_DEVICE_INSTANCE_ERROR(3),
    DEVICE_INIT_TIMEOUT(4),
    DEVICE_NOT_DISCOVERED(5);

    private final int value;

    private ConnectionErrorStates(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ConnectionErrorStates getError(int value) {

        switch (value) {
            case 0:
                return GATT_CONNECTED_TIMEOUT;
            case 1:
                return GATT_DISCOVERY_TIMEOUT;
            case 2:
                return GATT_INTERNAL_ERROR;
            case 3:
                return SMART_DEVICE_INSTANCE_ERROR;
            case 4:
                return DEVICE_INIT_TIMEOUT;
            case 5:
                return DEVICE_NOT_DISCOVERED;
        }
        return GATT_CONNECTED_TIMEOUT;
    }

}