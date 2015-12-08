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
package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.os.RemoteException;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import fr.bouyguestelecom.tv.bboxiot.config.GenericDevice;
import fr.bouyguestelecom.tv.bboxiot.config.GenericDeviceConst;
import fr.bouyguestelecom.tv.bboxiot.datamodel.Model;
import fr.bouyguestelecom.tv.bboxiot.datamodel.enums.Functions;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.connection.ConnectionMode;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.constant.BluetoothConst;

/**
 * Generic Bluetooth device object
 *
 * @author Bertrand Martel Bouygues Telecom
 */
public class BluetoothSmartDevice {

    private final static String TAG = BluetoothSmartDevice.class.getSimpleName();

    /**
     * generic device object
     */
    private GenericDevice genericDevice = null;

    /**
     * define if device has been found on network or not
     */
    private boolean deviceUp = false;

    /**
     * device unique identifier
     */
    private String deviceUuid = "";

    /**
     * Bluetooth device name (this is not unique device name)
     */
    private List<String> deviceNameList = new ArrayList<>();

    /**
     * manufacturer data AD frame
     */
    private byte[] manufacturerData = new byte[]{};

    /**
     * last device activity timestamp
     */
    private long lastActivityTimeStamp = -1;

    private ConnectionMode deviceMode = ConnectionMode.MODE_NONE;

    private String address = "";

    private BluetoothDevice device = null;

    /**
     * Build bluetooth device object
     */
    public BluetoothSmartDevice(String address,
                                String deviceUid,
                                List<String> deviceName,
                                byte[] manufacturerData,
                                long lastTimeStamp,
                                GenericDevice genericDevice,
                                ConnectionMode deviceMode) {

        this.address = address;

        this.deviceUuid = deviceUid;

        this.genericDevice = genericDevice;

        if (deviceName != null)
            this.deviceNameList = deviceName;

        if (manufacturerData != null)
            this.manufacturerData = manufacturerData;

        this.lastActivityTimeStamp = lastTimeStamp;

        this.deviceUp = true;

        this.deviceMode = deviceMode;
    }

    public ConnectionMode getDeviceMode() {
        return deviceMode;
    }

    public String getDeviceUuid() {
        return deviceUuid;
    }

    public GenericDevice getGenericDevice() {
        return genericDevice;
    }

    public List<String> getDeviceNameList() {
        return deviceNameList;
    }

    public byte[] getManufacturerData() {
        return manufacturerData;
    }

    /**
     * convert BluetoothSmartDevice to json object
     *
     * @return
     */
    public JSONObject toJson() {

        JSONObject result = new JSONObject();

        try {
            result.put(BluetoothConst.BLUETOOTH_DEVICE_UUID, deviceUuid);
            result.put(GenericDeviceConst.GENERIC_DEVICE, new JSONObject(genericDevice.toJsonString()));
            result.put(BluetoothConst.DEVICE_UP, deviceUp);

            result.put(BluetoothConst.DEVICE_LAST_TIMESTAMP, lastActivityTimeStamp);

            JSONArray manufacturerDataArray = new JSONArray();
            for (int i = 0; i < manufacturerData.length; i++) {
                manufacturerDataArray.put((manufacturerData[i] & 0xFF));
            }
            result.put(BluetoothConst.JSON_CONFIG_MANUFACTURER_DATA, manufacturerDataArray);

            JSONArray deviceNameArray = new JSONArray();
            for (int i = 0; i < deviceNameList.size(); i++) {
                deviceNameArray.put(deviceNameList.get(i));
            }
            result.put(BluetoothConst.JSON_CONFIG_DEVICE_NAME, deviceNameArray);
            result.put(BluetoothConst.JSON_CONFIG_DEVICE_MODE, deviceMode.ordinal());
            result.put(BluetoothConst.DEVICE_ADDRESS, address);

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean isUp() {
        return deviceUp;
    }

    public long getLastActivityTime() {
        return lastActivityTimeStamp;
    }

    public static BluetoothSmartDevice parse(JSONObject item) {

        try {
            if (item.has(BluetoothConst.BLUETOOTH_DEVICE_UUID) &&
                    item.has(GenericDeviceConst.GENERIC_DEVICE) &&
                    item.has(BluetoothConst.DEVICE_UP) &&
                    item.has(BluetoothConst.DEVICE_LAST_TIMESTAMP) &&
                    item.has(BluetoothConst.JSON_CONFIG_MANUFACTURER_DATA) &&
                    item.has(BluetoothConst.JSON_CONFIG_DEVICE_NAME) &&
                    item.has(BluetoothConst.DEVICE_ADDRESS)
                    ) {

                String deviceUid = item.getString(BluetoothConst.BLUETOOTH_DEVICE_UUID);

                JSONArray deviceNameList = item.getJSONArray(BluetoothConst.JSON_CONFIG_DEVICE_NAME);

                List<String> deviceName = new ArrayList<>();

                for (int i = 0; i < deviceNameList.length(); i++) {
                    deviceName.add(deviceNameList.get(i).toString());
                }

                JSONArray manufacturerDataList = item.getJSONArray(BluetoothConst.JSON_CONFIG_MANUFACTURER_DATA);

                byte[] manufacturerData = new byte[manufacturerDataList.length()];

                for (int i = 0; i < manufacturerDataList.length(); i++) {
                    manufacturerData[i] = (byte) manufacturerDataList.getInt(i);
                }

                long lastTimeStamp = item.getLong(BluetoothConst.DEVICE_LAST_TIMESTAMP);

                GenericDevice genericDevice = GenericDevice.parse(item.getJSONObject(GenericDeviceConst.GENERIC_DEVICE));

                if (genericDevice == null) {

                    Log.e(TAG, "Error generic device parsing failed");
                    return null;
                }

                ConnectionMode deviceMode = ConnectionMode.getMode(item.getInt(BluetoothConst.JSON_CONFIG_DEVICE_MODE));

                boolean deviceUp = item.getBoolean(BluetoothConst.DEVICE_UP);

                String deviceAddr = item.getString(BluetoothConst.DEVICE_ADDRESS);

                BluetoothSmartDevice smartDevice = new BluetoothSmartDevice(deviceAddr, deviceUid, deviceName, manufacturerData, lastTimeStamp, genericDevice, deviceMode);

                smartDevice.setDeviceUp(deviceUp);

                return smartDevice;

            } else {
                Log.e(TAG, "Error missing filed in BluetoothSmartDevice Json object");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getDeviceAddress() {
        return address;
    }

    public void setDeviceUp(boolean deviceUp) {
        this.deviceUp = deviceUp;
    }


    public void setDevice(BluetoothDevice device) {
        this.device = device;
    }

    public BluetoothDevice getDevice() {
        return device;
    }
}