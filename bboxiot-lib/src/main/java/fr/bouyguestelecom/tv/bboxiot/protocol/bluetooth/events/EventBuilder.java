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
package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Set;

import fr.bouyguestelecom.tv.bboxiot.datamodel.SmartProperty;
import fr.bouyguestelecom.tv.bboxiot.datamodel.enums.Capability;
import fr.bouyguestelecom.tv.bboxiot.datamodel.enums.Functions;
import fr.bouyguestelecom.tv.bboxiot.datamodel.enums.Properties;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.BluetoothSmartDevice;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.connection.BtConnection;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.constant.BluetoothConst;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.constant.AssociationEventConstant;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.constant.Common;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.constant.PropertiesEventConstant;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.constant.ScanningEventConstant;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.ConnectionState;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventSubscription;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventTopic;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventType;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.ScanRegistrationType;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.ScanningAction;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.ScanningType;
import fr.bouyguestelecom.tv.bboxiot.utils.RandomGen;

/**
 * @author Bertrand Martel
 */
public class EventBuilder {

    private final static String TAG = EventBuilder.class.getSimpleName();

    public static GenericEventAbstr buildConnectionItem(BtConnection connection) {

        JSONObject data = new JSONObject();

        try {
            data.put(AssociationEventConstant.ASSOCIATION_EVENT_ITEM, connection.toJson());
            return new GenericEvent(EventTopic.TOPIC_CONNECTION, EventType.EVENT_RESPONSE, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), data);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static GenericEventAbstr buildConnectionList(List<BtConnection> connectionList) {

        JSONObject data = new JSONObject();
        JSONArray items = new JSONArray();

        for (int i = 0; i < connectionList.size(); i++) {
            items.put(connectionList.get(i).toJson());
        }

        try {

            data.put(AssociationEventConstant.ASSOCIATION_EVENT_ITEMS, items);
            return new GenericEvent(EventTopic.TOPIC_CONNECTION, EventType.EVENT_RESPONSE, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), data);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;

    }

    public static GenericEventAbstr buildAssociationEvent(ConnectionState state, BtConnection connection) {

        JSONObject data = new JSONObject();

        try {

            data.put(AssociationEventConstant.ASSOCIATION_EVENT_STATE, state.ordinal());

            if (connection != null)
                data.put(AssociationEventConstant.ASSOCIATION_EVENT_CONNECTION, connection.toJson());

            return new GenericEvent(EventTopic.TOPIC_CONNECTION, EventType.EVENT_INCOMING, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), data);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static GenericEventAbstr buildScanStatusChange(ScanningAction action) {

        JSONObject data = new JSONObject();

        try {
            data.put(Common.CONSTANT_COMMON_TYPE, ScanRegistrationType.SCAN_EVENT_STATUS_CHANGE.ordinal());
            data.put(ScanningEventConstant.SCANNING_EVENT_ACTION, action.ordinal());

            return new GenericEvent(EventTopic.TOPIC_SCAN, EventType.EVENT_INCOMING, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), data);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static GenericEventAbstr buildScanList(List<BluetoothSmartDevice> deviceList) {

        JSONObject data = new JSONObject();
        JSONArray items = new JSONArray();

        for (int i = 0; i < deviceList.size(); i++) {
            items.put(deviceList.get(i).toJson());
        }

        try {

            data.put(ScanningEventConstant.SCANNING_EVENT_ITEMS, items);

            return new GenericEvent(EventTopic.TOPIC_SCAN, EventType.EVENT_RESPONSE, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), data);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static GenericEventAbstr buildScanItem(BluetoothSmartDevice device) {

        JSONObject data = new JSONObject();

        try {

            data.put(Common.CONSTANT_COMMON_TYPE, ScanRegistrationType.SCAN_EVENT_NEW_DEVICE_DISCOVERED.ordinal());
            data.put(ScanningEventConstant.SCANNING_EVENT_ITEMS, device.toJson());

            return new GenericEvent(EventTopic.TOPIC_SCAN, EventType.EVENT_INCOMING, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), data);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static GenericEventAbstr buildStopScan() {
        return buildScanStatus(ScanningAction.SCANNING_ACTION_STOP, ScanningType.SCANNING_TYPE_UNDEFINED, -1, -1, "");
    }

    public static GenericEventAbstr buildContinuousScan(int period) {
        return buildScanStatus(ScanningAction.SCANNING_ACTION_START, ScanningType.SCANNING_TYPE_CONTINUOUS, period, -1, "");
    }

    public static GenericEventAbstr buildPeriodicScan(int period, int dutyCycle) {
        return buildScanStatus(ScanningAction.SCANNING_ACTION_START, ScanningType.SCANNING_TYPE_PERIODIC, period, dutyCycle, "");
    }

    public static GenericEventAbstr buildPermanentScan() {
        return buildScanStatus(ScanningAction.SCANNING_ACTION_START, ScanningType.SCANNING_TYPE_PERMANENT, -1, -1, "");
    }

    public static GenericEventAbstr buildScanStatus(ScanningAction action, ScanningType scanType, int period, int dutyCycle, String targetDevice) {

        JSONObject data = new JSONObject();

        try {
            if (action == ScanningAction.SCANNING_ACTION_START && scanType != ScanningType.SCANNING_TYPE_UNDEFINED) {

                switch (scanType) {

                    case SCANNING_TYPE_CONTINUOUS: {

                        if (period > 0) {

                            data.put(ScanningEventConstant.SCANNING_EVENT_ACTION, action.ordinal());
                            data.put(ScanningEventConstant.SCANNING_EVENT_TYPE, scanType.ordinal());
                            data.put(ScanningEventConstant.SCANNING_EVENT_PERIOD, period);

                            if (!targetDevice.equals("")) {
                                data.put(ScanningEventConstant.SCANNING_EVENT_TARGET_DEVICE_UID, targetDevice);
                            }

                            return new GenericEvent(EventTopic.TOPIC_SCAN, EventType.EVENT_REQUEST, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), data);
                        } else {
                            Log.e(TAG, "Error period must be > 0");
                        }
                        break;
                    }
                    case SCANNING_TYPE_PERIODIC: {

                        if (period > 0 && dutyCycle >= 0 && dutyCycle <= 100) {

                            data.put(ScanningEventConstant.SCANNING_EVENT_ACTION, action.ordinal());
                            data.put(ScanningEventConstant.SCANNING_EVENT_TYPE, scanType.ordinal());
                            data.put(ScanningEventConstant.SCANNING_EVENT_PERIOD, period);
                            data.put(ScanningEventConstant.SCANNING_EVENT_DUTY, dutyCycle);

                            return new GenericEvent(EventTopic.TOPIC_SCAN, EventType.EVENT_REQUEST, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), data);
                        } else {
                            Log.e(TAG, "Error period must be > 0 && duty cycle must be >0 & < 100");
                        }
                        break;
                    }
                    case SCANNING_TYPE_PERMANENT: {

                        data.put(ScanningEventConstant.SCANNING_EVENT_ACTION, action.ordinal());
                        data.put(ScanningEventConstant.SCANNING_EVENT_TYPE, scanType.ordinal());
                        return new GenericEvent(EventTopic.TOPIC_SCAN, EventType.EVENT_REQUEST, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), data);
                    }
                }

            } else if (action == ScanningAction.SCANNING_ACTION_START && scanType == ScanningType.SCANNING_TYPE_UNDEFINED) {

                Log.e(TAG, "Error SCANNING_ACTION_START cant have SCANNING_TYPE_UNDEFINED");

            } else if (action == ScanningAction.SCANNING_ACTION_STOP) {

                data.put(ScanningEventConstant.SCANNING_EVENT_ACTION, action.ordinal());
                return new GenericEvent(EventTopic.TOPIC_SCAN, EventType.EVENT_REQUEST, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), data);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static IGenericEvent buildSubscription(Set<EventSubscription> subscriptionTypeList) {

        JSONArray array = new JSONArray();

        for (EventSubscription event : subscriptionTypeList) {
            array.put(event.ordinal());
        }

        JSONObject value = new JSONObject();
        try {
            value.put(Common.CONSTANT_COMMON_DATA, array);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new GenericEvent(EventTopic.TOPIC_BLUETOOTH_STATE, EventType.EVENT_SUBSCRIPTION, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), value);
    }

    public static IGenericEvent buildBluetoothStateEvent(boolean state) {

        JSONObject value = new JSONObject();
        try {
            value.put(Common.CONSTANT_COMMON_VALUE, state);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new GenericEvent(EventTopic.TOPIC_BLUETOOTH_STATE, EventType.EVENT_INCOMING, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), value);
    }

    public static IGenericEvent buildAddDeviceEvent(BluetoothSmartDevice device) {

        JSONObject value = new JSONObject();
        try {
            value.put(ScanningEventConstant.SCANNING_EVENT_ITEMS, device.toJson());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new GenericEvent(EventTopic.TOPIC_CONNECTION, EventType.EVENT_REQUEST, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), value);
    }

    public static <T> String buildPushRequest(Properties property, Functions function, T value) {

        JSONObject request = new JSONObject();
        try {
            request.put(PropertiesEventConstant.PROPERTIES_EVENT_TYPE, Capability.PUSH.ordinal());
            request.put(PropertiesEventConstant.PROPERTIES_EVENT_FUNCTION, function);
            request.put(PropertiesEventConstant.PROPERTIES_EVENT_PROPERTY, property);
            request.put(PropertiesEventConstant.PROPERTIES_EVENT_VALUE, value);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new GenericEvent(EventTopic.TOPIC_PROPERTIES, EventType.EVENT_REQUEST, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), request).toJsonString();
    }


    public static String buildPullRequest(Properties property, Functions function) {
        JSONObject request = new JSONObject();
        try {
            request.put(PropertiesEventConstant.PROPERTIES_EVENT_TYPE, Capability.PULL.ordinal());
            request.put(PropertiesEventConstant.PROPERTIES_EVENT_FUNCTION, function);
            request.put(PropertiesEventConstant.PROPERTIES_EVENT_PROPERTY, property);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new GenericEvent(EventTopic.TOPIC_PROPERTIES, EventType.EVENT_REQUEST, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), request).toJsonString();
    }

    public static IGenericEvent buildPropertyEvent(SmartProperty property, String deviceUuid) {

        JSONObject request = new JSONObject();

        try {
            request.put(PropertiesEventConstant.PROPERTIES_EVENT_PROPERTY, property.toJson());
            request.put(BluetoothConst.BLUETOOTH_DEVICE_UUID, deviceUuid);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new GenericEvent(EventTopic.TOPIC_PROPERTIES, EventType.EVENT_INCOMING, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), request);
    }
}
