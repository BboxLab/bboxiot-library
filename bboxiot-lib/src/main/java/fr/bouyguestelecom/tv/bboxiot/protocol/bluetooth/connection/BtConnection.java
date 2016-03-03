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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import fr.bouyguestelecom.tv.bboxiot.datamodel.SmartProperty;
import fr.bouyguestelecom.tv.bboxiot.datamodel.enums.ButtonState;
import fr.bouyguestelecom.tv.bboxiot.datamodel.enums.Capability;
import fr.bouyguestelecom.tv.bboxiot.datamodel.enums.Functions;
import fr.bouyguestelecom.tv.bboxiot.datamodel.enums.Properties;
import fr.bouyguestelecom.tv.bboxiot.datamodel.enums.PropertyTypes;
import fr.bouyguestelecom.tv.bboxiot.datamodel.enums.Unit;
import fr.bouyguestelecom.tv.bboxiot.events.EventBuilder;
import fr.bouyguestelecom.tv.bboxiot.events.constant.Common;
import fr.bouyguestelecom.tv.bboxiot.events.constant.PropertiesEventConstant;
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

    protected HashMap<Functions, HashMap<Properties, SmartProperty>> deviceFunctions = new HashMap<>();

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

    public BtConnection(String deviceUuid, boolean connected, boolean isFirstConnection, boolean busy, BluetoothSmartDevice device, HashMap<Functions, HashMap<Properties, SmartProperty>> deviceFunctions) {
        this.deviceUuid = deviceUuid;
        this.connected = connected;
        this.firstConnection = isFirstConnection;
        this.busy = busy;
        this.btSmartDevice = device;
        this.deviceFunctions = deviceFunctions;
    }

    public HashMap<Functions, HashMap<Properties, SmartProperty>> getDeviceFunctions() {
        return deviceFunctions;
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

            Iterator it = deviceFunctions.entrySet().iterator();

            while (it.hasNext()) {

                Map.Entry<Functions, HashMap<Properties, SmartProperty>> pair = (Map.Entry) it.next();
                HashMap<Properties, SmartProperty> entries = pair.getValue();

                JSONObject functionItem = new JSONObject();
                functionItem.put(BluetoothConst.BT_CONNECTION_SMART_NAME, EventBuilder.buildPair(pair.getKey()));

                JSONArray propertiesArray = new JSONArray();

                Iterator it2 = entries.entrySet().iterator();

                while (it2.hasNext()) {

                    Map.Entry<Properties, SmartProperty> pair2 = (Map.Entry) it2.next();

                    JSONObject propertyItem = new JSONObject();
                    propertyItem.put(BluetoothConst.BT_CONNECTION_SMART_NAME, EventBuilder.buildPair(pair2.getKey()));
                    propertyItem.put(BluetoothConst.BT_CONNECTION_SMART_FUNCTION, EventBuilder.buildPair(pair.getKey()));
                    propertyItem.put(PropertiesEventConstant.PROPERTIES_UNIT, EventBuilder.buildPair(pair2.getValue().getUnit()));

                    Iterator<Capability> it3 = pair2.getValue().getCapabilities().iterator();

                    JSONArray capabilitiesArray = new JSONArray();
                    while (it3.hasNext()) {
                        capabilitiesArray.put(EventBuilder.buildPair(it3.next()));
                    }

                    propertyItem.put(BluetoothConst.BT_CONNECTION_SMART_CAPABILITIES, capabilitiesArray);

                    propertyItem.put(BluetoothConst.BLUETOOTH_DEVICE_UUID, deviceUuid);

                    propertyItem.put(PropertiesEventConstant.PROPERTIES_EVENT_PROPERTY_TYPE, EventBuilder.buildPair(pair2.getValue().getType()));

                    if (pair2.getValue().getType() == PropertyTypes.BUTTON_STATE) {
                        propertyItem.put(BluetoothConst.BT_CONNECTION_SMART_VALUE, EventBuilder.buildPair((ButtonState) pair2.getValue().getValue()));
                    } else {
                        propertyItem.put(BluetoothConst.BT_CONNECTION_SMART_VALUE, pair2.getValue().getValue());
                    }

                    propertiesArray.put(propertyItem);
                }

                functionItem.put(BluetoothConst.BT_CONNECTION_SMART_PROPERTY_ARRAY, propertiesArray);

                array.put(functionItem);
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

                HashMap<Functions, HashMap<Properties, SmartProperty>> smartFunctions = new HashMap<>();

                for (int i = 0; i < smartFunctionArray.length(); i++) {

                    JSONObject function = smartFunctionArray.getJSONObject(i);

                    if (function.has(BluetoothConst.BT_CONNECTION_SMART_NAME) &&
                            function.has(BluetoothConst.BT_CONNECTION_SMART_PROPERTY_ARRAY)) {

                        Functions type = Functions.getFunctionValue(function.getJSONObject(BluetoothConst.BT_CONNECTION_SMART_NAME).getInt(Common.CONSTANT_COMMON_PAIR_CODE));

                        JSONArray propertiesArray = function.getJSONArray(BluetoothConst.BT_CONNECTION_SMART_PROPERTY_ARRAY);

                        HashMap<Properties, SmartProperty> smartPropertyHashMap = new HashMap<>();

                        for (int j = 0; j < propertiesArray.length(); j++) {

                            JSONObject property = propertiesArray.getJSONObject(j);

                            if (property.has(BluetoothConst.BT_CONNECTION_SMART_NAME) &&
                                    property.has(BluetoothConst.BT_CONNECTION_SMART_CAPABILITIES) &&
                                    property.has(BluetoothConst.BT_CONNECTION_SMART_VALUE) &&
                                    property.has(BluetoothConst.BT_CONNECTION_SMART_FUNCTION) &&
                                    property.has(PropertiesEventConstant.PROPERTIES_EVENT_PROPERTY_TYPE) &&
                                    property.has(BluetoothConst.BLUETOOTH_DEVICE_UUID) &&
                                    property.has(PropertiesEventConstant.PROPERTIES_UNIT)) {

                                Properties propertyVal = Properties.getPropertyValue(property.getJSONObject(BluetoothConst.BT_CONNECTION_SMART_NAME).getInt(Common.CONSTANT_COMMON_PAIR_CODE));
                                Functions functionVal = Functions.getFunctionValue(property.getJSONObject(BluetoothConst.BT_CONNECTION_SMART_FUNCTION).getInt(Common.CONSTANT_COMMON_PAIR_CODE));
                                Unit unit = Unit.getUnit(property.getJSONObject(PropertiesEventConstant.PROPERTIES_UNIT).getInt(Common.CONSTANT_COMMON_PAIR_CODE));

                                JSONArray capabilitiesArray = property.getJSONArray(BluetoothConst.BT_CONNECTION_SMART_CAPABILITIES);

                                List<Capability> capabilities = new ArrayList<>();
                                for (int k = 0; k < capabilitiesArray.length(); k++) {
                                    capabilities.add(Capability.getCapability(capabilitiesArray.getJSONObject(k).getInt(Common.CONSTANT_COMMON_PAIR_CODE)));
                                }

                                Object value = property.get(BluetoothConst.BT_CONNECTION_SMART_VALUE);

                                PropertyTypes propertyType = PropertyTypes.getPropertyType(property.getJSONObject(PropertiesEventConstant.PROPERTIES_EVENT_PROPERTY_TYPE).getInt(Common.CONSTANT_COMMON_PAIR_CODE));

                                String deviceUid = property.getString(BluetoothConst.BLUETOOTH_DEVICE_UUID);

                                SmartProperty smartProperty = null;

                                if (propertyType == PropertyTypes.BUTTON_STATE) {
                                    ButtonState buttonState = ButtonState.getState(((JSONObject) value).getInt(Common.CONSTANT_COMMON_PAIR_CODE));
                                    smartProperty = new SmartProperty(deviceUid, functionVal, propertyVal, unit, capabilities, propertyType, buttonState);
                                } else {
                                    smartProperty = new SmartProperty(deviceUid, functionVal, propertyVal, unit, capabilities, propertyType, value);
                                }

                                if (smartProperty != null)
                                    smartPropertyHashMap.put(propertyVal, smartProperty);
                                else
                                    Log.e(TAG, "smart property object is null");
                            }
                        }
                        smartFunctions.put(type, smartPropertyHashMap);
                    }
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

    public JSONArray getJsonArrayFunctionList() {

        try {
            JSONArray array = new JSONArray();

            Iterator it = deviceFunctions.entrySet().iterator();

            while (it.hasNext()) {

                Map.Entry<Functions, HashMap<Properties, SmartProperty>> pair = (Map.Entry) it.next();
                HashMap<Properties, SmartProperty> entries = pair.getValue();

                JSONObject functionItem = new JSONObject();
                functionItem.put(BluetoothConst.BT_CONNECTION_SMART_NAME, EventBuilder.buildPair(pair.getKey()));

                JSONArray propertiesArray = new JSONArray();

                Iterator it2 = entries.entrySet().iterator();

                while (it2.hasNext()) {

                    Map.Entry<Properties, SmartProperty> pair2 = (Map.Entry) it2.next();

                    JSONObject propertyItem = new JSONObject();
                    propertyItem.put(BluetoothConst.BT_CONNECTION_SMART_NAME, EventBuilder.buildPair(pair2.getKey()));
                    propertyItem.put(BluetoothConst.BT_CONNECTION_SMART_FUNCTION, EventBuilder.buildPair(pair.getKey()));
                    propertyItem.put(PropertiesEventConstant.PROPERTIES_UNIT, EventBuilder.buildPair(pair2.getValue().getUnit()));

                    Iterator<Capability> it3 = pair2.getValue().getCapabilities().iterator();

                    JSONArray capabilitiesArray = new JSONArray();
                    while (it3.hasNext()) {
                        capabilitiesArray.put(EventBuilder.buildPair(it3.next()));
                    }

                    propertyItem.put(BluetoothConst.BT_CONNECTION_SMART_CAPABILITIES, capabilitiesArray);

                    propertyItem.put(BluetoothConst.BLUETOOTH_DEVICE_UUID, deviceUuid);

                    propertyItem.put(PropertiesEventConstant.PROPERTIES_EVENT_PROPERTY_TYPE, EventBuilder.buildPair(pair2.getValue().getType()));

                    if (pair2.getValue().getType() == PropertyTypes.BUTTON_STATE) {
                        propertyItem.put(BluetoothConst.BT_CONNECTION_SMART_VALUE, EventBuilder.buildPair((ButtonState) pair2.getValue().getValue()));
                    } else {
                        propertyItem.put(BluetoothConst.BT_CONNECTION_SMART_VALUE, pair2.getValue().getValue());
                    }

                    propertiesArray.put(propertyItem);
                }

                functionItem.put(BluetoothConst.BT_CONNECTION_SMART_PROPERTY_ARRAY, propertiesArray);

                array.put(functionItem);
            }

            return array;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new JSONArray();
    }
}
