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

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import fr.bouyguestelecom.tv.bboxiot.datamodel.SmartFunction;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.BluetoothSmartDevice;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.constant.BluetoothConst;

/**
 * Bluetooth connection
 *
 * @author Bertrand Martel Bouygues Telecom
 */
public class BtConnection {

    /**
     * Bluetooth devivce object
     */
    protected BluetoothSmartDevice btSmartDevice = null;

    protected List<SmartFunction> deviceFunctions = new ArrayList<>();

    private static String TAG = BtConnection.class.getSimpleName();

    /**
     * define if device has already been connected before
     */
    protected boolean firstConnection = true;

    /**
     * indicate bluetooth connection is in connecting state
     */
    protected boolean busy = false;

    /**
     * device unique identifier
     */
    protected String deviceUuid = "";

    /**
     * define if device is connected or not
     */
    protected boolean connected = false;

    public BtConnection(String deviceUuid, boolean connected, boolean isFirstConnection, boolean busy, BluetoothSmartDevice device, List<SmartFunction> deviceFunctions) {
        this.deviceUuid = deviceUuid;
        this.connected = connected;
        this.firstConnection = isFirstConnection;
        this.busy = busy;
        this.btSmartDevice = device;
        this.deviceFunctions = deviceFunctions;
    }

    /**
     * Convert Connection object to json object
     *
     * @return
     */
    public JSONObject toJson() {
        JSONObject result = new JSONObject();

        try {
            result.put(BluetoothConst.BLUETOOTH_DEVICE_UUID, deviceUuid);
            result.put(BluetoothConst.BT_CONNECTION_CONNECTED, connected);
            result.put(BluetoothConst.BT_CONNECTION_FIRST_CONNECTION, firstConnection);
            result.put(BluetoothConst.BT_CONNECTION_BUSY, busy);
            result.put(BluetoothConst.BT_CONNECTION_DEVICE, btSmartDevice.toJson());

            JSONArray array = new JSONArray();
            for (int i = 0; i < deviceFunctions.size(); i++) {
                JSONObject parsedFunction = deviceFunctions.get(i).toJson();
                if (parsedFunction != null)
                    array.put(parsedFunction);
                else
                    Log.e(TAG, "Error device function item is null");
            }
            result.put(BluetoothConst.BT_CONNECTION_SMART_FUNCTION_ARRAY, array);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean isConnected() {
        return connected;
    }

    public boolean isBusy() {
        return busy;
    }

    public boolean isFirstConnection() {
        return firstConnection;
    }

    public String getDeviceUuid() {
        return deviceUuid;
    }

    public BluetoothSmartDevice getBtSmartDevice() {
        return btSmartDevice;
    }

    public static BtConnection parse(JSONObject item) {

        try {
            if (item.has(BluetoothConst.BLUETOOTH_DEVICE_UUID) &&
                    item.has(BluetoothConst.BT_CONNECTION_CONNECTED) &&
                    item.has(BluetoothConst.BT_CONNECTION_FIRST_CONNECTION) &&
                    item.has(BluetoothConst.BT_CONNECTION_BUSY) &&
                    item.has(BluetoothConst.BT_CONNECTION_DEVICE) &&
                    item.has(BluetoothConst.BT_CONNECTION_SMART_FUNCTION_ARRAY)) {

                String deviceUuid = item.getString(BluetoothConst.BLUETOOTH_DEVICE_UUID);
                boolean connected = item.getBoolean(BluetoothConst.BT_CONNECTION_CONNECTED);
                boolean isFirstConnection = item.getBoolean(BluetoothConst.BT_CONNECTION_FIRST_CONNECTION);
                boolean busy = item.getBoolean(BluetoothConst.BT_CONNECTION_BUSY);

                JSONArray smartFunctionArray = item.getJSONArray(BluetoothConst.BT_CONNECTION_SMART_FUNCTION_ARRAY);

                ArrayList<SmartFunction> smartFunctions = new ArrayList<>();

                for (int i = 0; i < smartFunctionArray.length(); i++) {
                    smartFunctions.add(SmartFunction.parse(smartFunctionArray.getJSONObject(i)));
                }

                JSONObject device = item.getJSONObject(BluetoothConst.BT_CONNECTION_DEVICE);

                BluetoothSmartDevice smartDevice = BluetoothSmartDevice.parse(device);

                if (smartDevice == null) {
                    Log.e(TAG, "Error wrong format in bluetooth smart device");
                    return null;
                }

                return new BtConnection(deviceUuid, connected, isFirstConnection, busy, smartDevice, smartFunctions);

            } else {
                Log.e(TAG, "Error wrong formatted BtConnection json Object");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
