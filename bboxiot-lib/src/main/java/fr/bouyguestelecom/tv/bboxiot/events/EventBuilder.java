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
package fr.bouyguestelecom.tv.bboxiot.events;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Set;

import fr.bouyguestelecom.tv.bboxiot.datamodel.SmartProperty;
import fr.bouyguestelecom.tv.bboxiot.datamodel.enums.ActionStatus;
import fr.bouyguestelecom.tv.bboxiot.datamodel.enums.Functions;
import fr.bouyguestelecom.tv.bboxiot.datamodel.enums.Properties;
import fr.bouyguestelecom.tv.bboxiot.events.constant.AssociationEventConstant;
import fr.bouyguestelecom.tv.bboxiot.events.constant.Common;
import fr.bouyguestelecom.tv.bboxiot.events.constant.PropertiesEventConstant;
import fr.bouyguestelecom.tv.bboxiot.events.constant.ScanningEventConstant;
import fr.bouyguestelecom.tv.bboxiot.events.enums.ConnectionState;
import fr.bouyguestelecom.tv.bboxiot.events.enums.EventSubscription;
import fr.bouyguestelecom.tv.bboxiot.events.enums.EventTopic;
import fr.bouyguestelecom.tv.bboxiot.events.enums.EventType;
import fr.bouyguestelecom.tv.bboxiot.events.enums.PropertyEventType;
import fr.bouyguestelecom.tv.bboxiot.events.enums.ScanRegistrationType;
import fr.bouyguestelecom.tv.bboxiot.events.enums.ScanningAction;
import fr.bouyguestelecom.tv.bboxiot.events.enums.ScanningType;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.BluetoothSmartDevice;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.connection.BtAssociatedItem;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.constant.BluetoothConst;
import fr.bouyguestelecom.tv.bboxiot.utils.RandomGen;

/**
 * Event builder
 *
 * @author Bertrand Martel
 */
public class EventBuilder {

    private final static String TAG = EventBuilder.class.getSimpleName();

    /**
     * Build associated item event
     *
     * @param connection connection object
     * @return
     */
    public static GenericEventAbstr buildConnectionItem(BtAssociatedItem connection) {

        JSONObject data = new JSONObject();

        try {
            data.put(AssociationEventConstant.ASSOCIATION_EVENT_CONNECTION, connection.toJson());
            return new GenericEvent(EventTopic.TOPIC_CONNECTION, EventType.EVENT_RESPONSE, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), data);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Build association list event
     *
     * @param connectionList associated item list
     * @return
     */
    public static GenericEventAbstr buildConnectionList(List<BtAssociatedItem> connectionList) {

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

    /**
     * Build association event
     *
     * @param state      association state
     * @param connection association item
     * @return
     */
    public static GenericEventAbstr buildAssociationEvent(ConnectionState state, BtAssociatedItem connection) {

        JSONObject data = new JSONObject();

        try {

            data.put(AssociationEventConstant.ASSOCIATION_EVENT_STATE, state.getValueStr());

            if (connection != null)
                data.put(AssociationEventConstant.ASSOCIATION_EVENT_CONNECTION, connection.toJson());

            return new GenericEvent(EventTopic.TOPIC_CONNECTION, EventType.EVENT_INCOMING, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), data);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Build scan status change event
     *
     * @param action scan status
     * @return
     */
    public static GenericEventAbstr buildScanStatusChange(ScanningAction action) {

        JSONObject data = new JSONObject();

        try {

            data.put(Common.CONSTANT_COMMON_TYPE, ScanRegistrationType.SCAN_EVENT_STATUS_CHANGE.getValueStr());
            data.put(ScanningEventConstant.SCANNING_EVENT_ACTION, action.getValueStr());

            return new GenericEvent(EventTopic.TOPIC_SCAN, EventType.EVENT_INCOMING, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), data);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Build scan list event
     *
     * @param scanningList scanning list
     * @return
     */
    public static GenericEventAbstr buildScanList(List<BluetoothSmartDevice> scanningList) {

        JSONObject data = new JSONObject();
        JSONArray items = new JSONArray();

        for (int i = 0; i < scanningList.size(); i++) {
            items.put(scanningList.get(i).toJson());
        }

        try {

            data.put(ScanningEventConstant.SCANNING_EVENT_ITEMS, items);

            return new GenericEvent(EventTopic.TOPIC_SCAN, EventType.EVENT_RESPONSE, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), data);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Build scan item event
     *
     * @param device bluetooth device discovered
     * @return
     */
    public static GenericEventAbstr buildScanItem(BluetoothSmartDevice device) {

        JSONObject data = new JSONObject();

        try {
            data.put(Common.CONSTANT_COMMON_TYPE, ScanRegistrationType.SCAN_EVENT_NEW_DEVICE_DISCOVERED.getValueStr());
            data.put(ScanningEventConstant.SCANNING_EVENT_ITEMS, device.toJson());

            return new GenericEvent(EventTopic.TOPIC_SCAN, EventType.EVENT_INCOMING, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), data);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Build stop scan event
     *
     * @return
     */
    public static GenericEventAbstr buildStopScan() {
        return buildScanStatus(ScanningAction.SCANNING_ACTION_STOP, ScanningType.SCANNING_TYPE_UNDEFINED, -1, -1, "");
    }

    /**
     * Build continuous scan event
     *
     * @param period scan period in seconds
     * @return
     */
    public static GenericEventAbstr buildContinuousScan(int period) {
        return buildScanStatus(ScanningAction.SCANNING_ACTION_START, ScanningType.SCANNING_TYPE_CONTINUOUS, period, -1, "");
    }

    /**
     * Build periodic scan event
     *
     * @param period    scan period in seconds
     * @param dutyCycle scan duty cycle in %
     * @return
     */
    public static GenericEventAbstr buildPeriodicScan(int period, int dutyCycle) {
        return buildScanStatus(ScanningAction.SCANNING_ACTION_START, ScanningType.SCANNING_TYPE_PERIODIC, period, dutyCycle, "");
    }

    /**
     * Build permanent scan event
     *
     * @return
     */
    public static GenericEventAbstr buildPermanentScan() {
        return buildScanStatus(ScanningAction.SCANNING_ACTION_START, ScanningType.SCANNING_TYPE_PERMANENT, -1, -1, "");
    }

    /**
     * Build scan status event
     *
     * @param action       scan status action
     * @param scanType     scan type
     * @param period       scan period in seconds
     * @param dutyCycle    scan duty cycle in %
     * @param targetDevice device to be tracked (scan is stopped when this device is  found if specified)
     * @return
     */
    public static GenericEventAbstr buildScanStatus(ScanningAction action, ScanningType scanType, int period, int dutyCycle, String targetDevice) {

        JSONObject data = new JSONObject();

        try {
            if (action == ScanningAction.SCANNING_ACTION_START && scanType != ScanningType.SCANNING_TYPE_UNDEFINED) {

                switch (scanType) {

                    case SCANNING_TYPE_CONTINUOUS: {

                        if (period > 0) {

                            data.put(ScanningEventConstant.SCANNING_EVENT_ACTION, action.getValueStr());
                            data.put(ScanningEventConstant.SCANNING_EVENT_TYPE, scanType.getValueStr());

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

                            data.put(ScanningEventConstant.SCANNING_EVENT_ACTION, action.getValueStr());
                            data.put(ScanningEventConstant.SCANNING_EVENT_TYPE, scanType.getValueStr());
                            data.put(ScanningEventConstant.SCANNING_EVENT_PERIOD, period);
                            data.put(ScanningEventConstant.SCANNING_EVENT_DUTY, dutyCycle);

                            return new GenericEvent(EventTopic.TOPIC_SCAN, EventType.EVENT_REQUEST, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), data);
                        } else {
                            Log.e(TAG, "Error period must be > 0 && duty cycle must be >0 & < 100");
                        }
                        break;
                    }
                    case SCANNING_TYPE_PERMANENT: {

                        data.put(ScanningEventConstant.SCANNING_EVENT_ACTION, action.getValueStr());
                        data.put(ScanningEventConstant.SCANNING_EVENT_TYPE, scanType.getValueStr());
                        return new GenericEvent(EventTopic.TOPIC_SCAN, EventType.EVENT_REQUEST, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), data);
                    }
                }

            } else if (action == ScanningAction.SCANNING_ACTION_START && scanType == ScanningType.SCANNING_TYPE_UNDEFINED) {

                Log.e(TAG, "Error SCANNING_ACTION_START cant have SCANNING_TYPE_UNDEFINED");

            } else if (action == ScanningAction.SCANNING_ACTION_STOP) {

                data.put(ScanningEventConstant.SCANNING_EVENT_ACTION, action.getValueStr());
                return new GenericEvent(EventTopic.TOPIC_SCAN, EventType.EVENT_REQUEST, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), data);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Build subscription event
     *
     * @param subscriptionTypeList list of topic to subscribe to
     * @return
     */
    public static IGenericEvent buildSubscription(Set<EventSubscription> subscriptionTypeList) {

        JSONArray array = new JSONArray();

        for (EventSubscription event : subscriptionTypeList) {
            array.put(event.getValueStr());
        }

        JSONObject value = new JSONObject();
        try {
            value.put(Common.CONSTANT_COMMON_DATA, array);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new GenericEvent(EventTopic.TOPIC_BLUETOOTH_STATE, EventType.EVENT_SUBSCRIPTION, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), value);
    }

    /**
     * Build bluetooth state event
     *
     * @param state new bluetooth state
     * @return
     */
    public static IGenericEvent buildBluetoothStateEvent(boolean state) {

        JSONObject value = new JSONObject();
        try {
            value.put(Common.CONSTANT_COMMON_VALUE, state);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new GenericEvent(EventTopic.TOPIC_BLUETOOTH_STATE, EventType.EVENT_INCOMING, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), value);
    }

    /**
     * Build a NewDeviceDiscovered event
     *
     * @param device bluetooth smart device discovered
     * @return
     */
    public static IGenericEvent buildAddDeviceEvent(BluetoothSmartDevice device) {

        JSONObject value = new JSONObject();
        try {
            value.put(ScanningEventConstant.SCANNING_EVENT_ITEMS, device.toJson());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new GenericEvent(EventTopic.TOPIC_CONNECTION, EventType.EVENT_REQUEST, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), value);
    }

    /**
     * BUild a push request event
     *
     * @param property smart property
     * @param value    property value to be pushed
     * @param <T>      generic value
     * @return
     */
    public static <T> String buildPushRequest(SmartProperty property, T value) {
        return buildPushRequest(property.getDeviceUid(), property.getFunction(), property.getProperty(), value);
    }

    /**
     * Build push request event
     *
     * @param deviceUid device uid
     * @param function  function target
     * @param property  property target
     * @param value     property value
     * @param <T>       generic value
     * @return
     */
    public static <T> String buildPushRequest(String deviceUid, Functions function, Properties property, T value) {

        JSONObject request = new JSONObject();
        try {
            request.put(PropertiesEventConstant.PROPERTIES_EVENT_TYPE, PropertyEventType.PUSH.getValueStr());
            request.put(BluetoothConst.BLUETOOTH_DEVICE_UUID, deviceUid);
            request.put(PropertiesEventConstant.PROPERTIES_EVENT_PROPERTY, property.getValueStr());
            request.put(PropertiesEventConstant.PROPERTIES_EVENT_FUNCTION, function.getValueStr());
            request.put(PropertiesEventConstant.PROPERTIES_EVENT_VALUE, value);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new GenericEvent(EventTopic.TOPIC_PROPERTIES, EventType.EVENT_REQUEST, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), request).toJsonString();
    }

    /**
     * Build pull request event
     *
     * @param property smart property object
     * @return
     */
    public static String buildPullRequest(SmartProperty property) {
        return buildPullRequest(property.getDeviceUid(), property.getFunction(), property.getProperty());
    }

    /**
     * Build a pull request event
     *
     * @param deviceUuid device uid
     * @param function   function target
     * @param property   property target
     * @return
     */
    public static String buildPullRequest(String deviceUuid, Functions function, Properties property) {

        JSONObject request = new JSONObject();
        try {
            request.put(PropertiesEventConstant.PROPERTIES_EVENT_TYPE, PropertyEventType.PULL.getValueStr());
            request.put(BluetoothConst.BLUETOOTH_DEVICE_UUID, deviceUuid);
            request.put(PropertiesEventConstant.PROPERTIES_EVENT_PROPERTY, property.getValueStr());
            request.put(PropertiesEventConstant.PROPERTIES_EVENT_FUNCTION, function.getValueStr());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new GenericEvent(EventTopic.TOPIC_PROPERTIES, EventType.EVENT_REQUEST, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), request).toJsonString();
    }

    /**
     * Build a property request event
     *
     * @param property  property target
     * @param function  function target
     * @param deviceUid device uid
     * @return
     */
    public static IGenericEvent buildRequestPropertyEvent(Properties property, Functions function, String deviceUid) {

        JSONObject request = new JSONObject();
        try {
            request.put(PropertiesEventConstant.PROPERTIES_EVENT_TYPE, PropertyEventType.PROPERTY.getValueStr());
            request.put(PropertiesEventConstant.PROPERTIES_EVENT_FUNCTION, function.getValueStr());
            request.put(PropertiesEventConstant.PROPERTIES_EVENT_PROPERTY, property.getValueStr());
            request.put(BluetoothConst.BLUETOOTH_DEVICE_UUID, deviceUid);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new GenericEvent(EventTopic.TOPIC_PROPERTIES, EventType.EVENT_REQUEST, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), request);
    }

    /**
     * Build property response event
     *
     * @param property property target
     * @return
     */
    public static IGenericEvent buildResponsePropertyEvent(SmartProperty property) {

        JSONObject request = new JSONObject();
        try {
            request.put(PropertiesEventConstant.PROPERTIES_EVENT_TYPE, PropertyEventType.PROPERTY.getValueStr());
            request.put(BluetoothConst.BLUETOOTH_DEVICE_UUID, property.getDeviceUid());
            request.put(PropertiesEventConstant.PROPERTIES_EVENT_PROPERTY, property.toJson());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new GenericEvent(EventTopic.TOPIC_PROPERTIES, EventType.EVENT_RESPONSE, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), request);
    }

    /**
     * Build incoming property change event
     *
     * @param property   property target
     * @param deviceUuid device uid
     * @return
     */
    public static IGenericEvent buildIncomingPropertyChangeEvent(SmartProperty property, String deviceUuid) {

        JSONObject request = new JSONObject();

        try {
            request.put(PropertiesEventConstant.PROPERTIES_EVENT_PROPERTY, property.toJson());
            request.put(BluetoothConst.BLUETOOTH_DEVICE_UUID, deviceUuid);
            request.put(PropertiesEventConstant.PROPERTIES_EVENT_TYPE, PropertyEventType.INCOMING.getValueStr());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new GenericEvent(EventTopic.TOPIC_PROPERTIES, EventType.EVENT_INCOMING, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), request);
    }

    /**
     * Build pull response event
     *
     * @param property   smart property target
     * @param deviceUuid deivce uid
     * @param status     action status for this pull response
     * @param eventId    event identifier
     * @return
     */
    public static IGenericEvent buildPullResponse(SmartProperty property, String deviceUuid, ActionStatus status, String eventId) {

        JSONObject request = new JSONObject();

        try {
            request.put(PropertiesEventConstant.PROPERTIES_EVENT_PROPERTY, property.toJson());
            request.put(BluetoothConst.BLUETOOTH_DEVICE_UUID, deviceUuid);
            request.put(PropertiesEventConstant.PROPERTIES_ACTION_ID, eventId);
            request.put(PropertiesEventConstant.PROPERTIES_ACTION_STATUS, status.getValueStr());
            request.put(PropertiesEventConstant.PROPERTIES_EVENT_TYPE, PropertyEventType.PULL.getValueStr());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new GenericEvent(EventTopic.TOPIC_PROPERTIES, EventType.EVENT_RESPONSE, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), request);
    }

    /**
     * BUild push response event
     *
     * @param property   smart property target
     * @param deviceUuid device uid
     * @param status     action status for this push response
     * @param eventId    event identifier
     * @return
     */
    public static IGenericEvent buildPushResponse(SmartProperty property, String deviceUuid, ActionStatus status, String eventId) {

        JSONObject request = new JSONObject();

        try {
            request.put(PropertiesEventConstant.PROPERTIES_EVENT_PROPERTY, property.toJson());
            request.put(BluetoothConst.BLUETOOTH_DEVICE_UUID, deviceUuid);
            request.put(PropertiesEventConstant.PROPERTIES_ACTION_ID, eventId);
            request.put(PropertiesEventConstant.PROPERTIES_ACTION_STATUS, status.getValueStr());
            request.put(PropertiesEventConstant.PROPERTIES_EVENT_TYPE, PropertyEventType.PUSH.getValueStr());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new GenericEvent(EventTopic.TOPIC_PROPERTIES, EventType.EVENT_RESPONSE, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), request);
    }

}
