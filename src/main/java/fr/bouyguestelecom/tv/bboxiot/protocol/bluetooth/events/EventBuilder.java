package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Set;

import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.BluetoothSmartDevice;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.connection.BtConnection;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.constant.AssociationEventConstant;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.constant.Common;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.constant.ScanningEventConstant;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.AssociationState;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventRegistration;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventTopic;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventType;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.ScanRegistrationType;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.ScanningAction;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.ScanningType;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.utils.RandomGen;

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

    public static GenericEventAbstr buildAssociationEvent(AssociationState state, BtConnection connection) {

        JSONObject data = new JSONObject();

        try {

            data.put(AssociationEventConstant.ASSOCIATION_EVENT_STATE, state.ordinal());
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

    public static IGenericEvent buildRegistration(Set<EventRegistration> registrationTypeList) {

        JSONArray array = new JSONArray();

        for (EventRegistration event : registrationTypeList) {
            array.put(event.ordinal());
        }

        JSONObject value = new JSONObject();
        try {
            value.put(Common.CONSTANT_COMMON_DATA, array);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new GenericEvent(EventTopic.TOPIC_BLUETOOTH_STATE, EventType.EVENT_REGISTRATION, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), value);
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
}
