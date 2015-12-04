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
 * Enumerate connection events
 *
 * @author Bertrand Martel Bouygues Telecom
 */
public enum ConnectionEvents {

    CONNECTION_STATE_GATT_CONNECTED(1),
    CONNECTION_STATE_GATT_SERVICE_DISCOVERED(2),
    CONNECTION_STATE_GATT_DISCONNECTED(3),
    CONNECTION_STATE_ASSOCIATION_COMPLETE(4),
    CONNECTION_STATE_DEVICE_UP(5),
    CONNECTION_STATE_GATT_CONNECTED_TIMEOUT(100),
    CONNECTION_STATE_GATT_DISCOVERY_TIMEOUT(101),
    CONNECTION_STATE_GATT_INTERNAL_ERROR(102),
    CONNECTION_STATE_SMART_DEVICE_INSTANCE_ERROR(103),
    CONNECTION_STATE_DEVICE_NOT_DISCOVERED(104),
    CONNECTION_STATE_DEVICE_INIT_TIMEOUT(105);

    private int value = 0;

    private ConnectionEvents(int value) {
        this.value = value;
    }

    public static ConnectionEvents getEvents(int value) {

        switch (value) {
            case 1:
                return CONNECTION_STATE_GATT_CONNECTED;
            case 2:
                return CONNECTION_STATE_GATT_SERVICE_DISCOVERED;
            case 3:
                return CONNECTION_STATE_GATT_DISCONNECTED;
            case 4:
                return CONNECTION_STATE_ASSOCIATION_COMPLETE;
            case 5:
                return CONNECTION_STATE_DEVICE_UP;
            case 100:
                return CONNECTION_STATE_GATT_CONNECTED_TIMEOUT;
            case 101:
                return CONNECTION_STATE_GATT_DISCOVERY_TIMEOUT;
            case 102:
                return CONNECTION_STATE_GATT_INTERNAL_ERROR;
            case 103:
                return CONNECTION_STATE_SMART_DEVICE_INSTANCE_ERROR;
            case 104:
                return CONNECTION_STATE_DEVICE_NOT_DISCOVERED;
            case 105:
                return CONNECTION_STATE_DEVICE_INIT_TIMEOUT;
        }
        return CONNECTION_STATE_GATT_CONNECTED;
    }
}
