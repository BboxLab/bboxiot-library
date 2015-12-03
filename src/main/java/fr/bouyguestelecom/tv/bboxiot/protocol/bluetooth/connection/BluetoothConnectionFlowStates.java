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
 * Bluetooth workflow states (check bluetooth workflow state)
 *
 * @author Bertrand Martel Bouygues Telecom
 */
public enum BluetoothConnectionFlowStates {

    STATE_NONE(0),
    STATE_CONNECT(1),
    STATE_SCAN(2),
    STATE_SCAN_SUCCESS(4),
    STATE_SCAN_FAILURE(3),
    STATE_CONNECT_GATT(5),
    STATE_CONNECT_GATT_ERROR(8),
    STATE_CONNECT_GATT_TIMEOUT(7),
    STATE_CONNECT_GATT_SUCCESS(6),
    STATE_SERVICE_DISCOVERY(9),
    STATE_SERVICE_DISCOVERY_SUCCESS(10),
    STATE_SERVICE_DISCOVERY_ERROR(12),
    STATE_SERVICE_DISCOVERY_TIMEOUT(11),
    STATE_INIT_DEVICE(13),
    STATE_INIT_SUCCESS(14),
    STATE_INIT_TIMEOUT(15),
    STATE_INIT_ERROR(16),
    STATE_DISCONNECT(17),
    STATE_DISCONNECT_SUCCESS(18),
    STATE_DISCONNECT_TIMEOUT(19),
    STATE_GATT_CLOSE(21),
    STATE_PROCESS_NEXT_DISCONNECTION(22),
    STATE_PROCESS_SCAN(23),
    STATE_PROCESS_NEXT_CONNECTION(24),
    STATE_SCAN_DEVICES(25),
    STATE_SCAN_DEVICES_END(26),
    STATE_RETRY_CONNECTION(27),
    STATE_BLUETOOTH_OFF(28),
    STATE_BLUETOOTH_ON(29),
    STATE_DISCONNECT_MAX_DEVICE(30),
    STATE_SCAN_PENDING(31);

    private int value;

    private BluetoothConnectionFlowStates(int value) {
        this.value = value;
    }

    public static BluetoothConnectionFlowStates getState(int value) {

        switch (value) {
            case 0:
                return STATE_NONE;
            case 1:
                return STATE_CONNECT;
            case 2:
                return STATE_SCAN_SUCCESS;
            case 3:
                return STATE_SCAN_FAILURE;
            case 5:
                return STATE_CONNECT_GATT;
            case 8:
                return STATE_CONNECT_GATT_ERROR;
            case 6:
                return STATE_CONNECT_GATT_SUCCESS;
            case 7:
                return STATE_CONNECT_GATT_TIMEOUT;
            case 9:
                return STATE_SERVICE_DISCOVERY;
            case 10:
                return STATE_SERVICE_DISCOVERY_SUCCESS;
            case 11:
                return STATE_SERVICE_DISCOVERY_TIMEOUT;
            case 12:
                return STATE_SERVICE_DISCOVERY_ERROR;
            case 13:
                return STATE_INIT_DEVICE;
            case 14:
                return STATE_INIT_SUCCESS;
            case 15:
                return STATE_INIT_TIMEOUT;
            case 16:
                return STATE_INIT_ERROR;
            case 17:
                return STATE_DISCONNECT;
            case 18:
                return STATE_DISCONNECT_SUCCESS;
            case 19:
                return STATE_DISCONNECT_TIMEOUT;
            case 21:
                return STATE_GATT_CLOSE;
            case 22:
                return STATE_PROCESS_NEXT_DISCONNECTION;
            case 23:
                return STATE_PROCESS_SCAN;
            case 24:
                return STATE_PROCESS_NEXT_CONNECTION;
            case 25:
                return STATE_SCAN_DEVICES;
            case 26:
                return STATE_SCAN_DEVICES_END;
            case 27:
                return STATE_RETRY_CONNECTION;
            case 28:
                return STATE_BLUETOOTH_OFF;
            case 29:
                return STATE_BLUETOOTH_ON;
            case 30:
                return STATE_DISCONNECT_MAX_DEVICE;
            case 31:
                return STATE_SCAN_PENDING;
        }
        return STATE_NONE;
    }

}
