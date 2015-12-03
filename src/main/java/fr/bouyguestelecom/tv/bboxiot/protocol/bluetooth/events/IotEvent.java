package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.BluetoothSmartDevice;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.connection.BtConnection;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.constant.AssociationEventConstant;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.constant.Common;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.constant.GenericEventConstant;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventTopic;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventType;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.ScanRegistrationType;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.impl.AssociationEvent;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.impl.AssociationList;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.impl.BluetoothStateEvent;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.impl.ConnectionItem;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.impl.RegistrationEvent;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.impl.ScanItemEvent;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.impl.ScanListItem;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.impl.ScanStatusChangeEvent;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.impl.ScanStatusEvent;

/**
 * @author Bertrand Martel
 */
public class IotEvent {

    private static String TAG = IotEvent.class.getSimpleName();

    public static IGenericEvent parse(String eventStr) {

        Log.i(TAG, "event : " + eventStr);

        JSONObject object = null;

        try {

            object = new JSONObject(eventStr);

            if (object.has(GenericEventConstant.GENERIC_EVENT_CONSTANT_TYPE) &&
                    object.has(GenericEventConstant.GENERIC_EVENT_CONSTANT_DATA) &&
                    object.has(GenericEventConstant.GENERIC_EVENT_CONSTANT_EVENT_ID) &&
                    object.has(GenericEventConstant.GENERIC_EVENT_CONSTANT_TOPIC)) {

                EventTopic topic = EventTopic.getTopic(object.getInt(GenericEventConstant.GENERIC_EVENT_CONSTANT_TOPIC));
                EventType eventType = EventType.getType(object.getInt(GenericEventConstant.GENERIC_EVENT_CONSTANT_TYPE));
                String eventId = object.getString(GenericEventConstant.GENERIC_EVENT_CONSTANT_EVENT_ID);
                JSONObject data = object.getJSONObject(GenericEventConstant.GENERIC_EVENT_CONSTANT_DATA);

                switch (eventType) {

                    case EVENT_INCOMING: {

                        switch (topic) {

                            case TOPIC_SCAN: {

                                if (data.has(Common.CONSTANT_COMMON_TYPE)) {

                                    ScanRegistrationType scanEventType = ScanRegistrationType.getType(data.getInt(Common.CONSTANT_COMMON_TYPE));

                                    if (scanEventType == ScanRegistrationType.SCAN_EVENT_NEW_DEVICE_DISCOVERED) {

                                        return new ScanItemEvent(topic, eventType, eventId, data);

                                    } else if (scanEventType == ScanRegistrationType.SCAN_EVENT_STATUS_CHANGE) {

                                        return new ScanStatusChangeEvent(topic, eventType, eventId, data);

                                    }
                                }
                                return new ScanItemEvent(topic, eventType, eventId, data);

                            }
                            case TOPIC_CONNECTION: {

                                return new AssociationEvent(topic, eventType, eventId, data);
                            }
                            case TOPIC_PROPERTIES: {
                                break;
                            }
                            case TOPIC_BLUETOOTH_STATE: {

                                return new BluetoothStateEvent(topic, eventType, eventId, data);
                            }
                            default: {
                                break;
                            }
                        }
                        break;
                    }
                    case EVENT_REGISTRATION: {

                        return new RegistrationEvent(topic, eventType, eventId, data);
                    }
                    case EVENT_REQUEST: {

                        switch (topic) {

                            case TOPIC_SCAN: {
                                return new ScanStatusEvent(topic, eventType, eventId, data);
                            }
                            case TOPIC_CONNECTION: {
                                break;
                            }
                            case TOPIC_PROPERTIES: {
                                break;
                            }
                            case TOPIC_BLUETOOTH_STATE: {
                            }
                            default: {
                                break;
                            }
                        }
                        break;
                    }
                    case EVENT_RESPONSE: {

                        switch (topic) {

                            case TOPIC_CONNECTION: {

                                if (data.has(AssociationEventConstant.ASSOCIATION_EVENT_ITEMS)) {

                                    return new AssociationList(topic, eventType, eventId, data);

                                } else if (data.has(AssociationEventConstant.ASSOCIATION_EVENT_ITEM)) {

                                    return new ConnectionItem(topic, eventType, eventId, data);

                                }
                                break;
                            }
                            case TOPIC_SCAN: {

                                return new ScanListItem(topic, eventType, eventId, data);
                            }
                            default: {
                                break;
                            }
                        }
                        break;
                    }
                    default: {
                        break;
                    }
                }

            } else {
                Log.e(TAG, "Error event doesnt respect format");
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public static BtConnection parseConnectionItem(String request) {

        Log.i(TAG, "event : " + request);

        JSONObject object = null;

        try {

            object = new JSONObject(request);

            if (object.has(GenericEventConstant.GENERIC_EVENT_CONSTANT_TYPE) &&
                    object.has(GenericEventConstant.GENERIC_EVENT_CONSTANT_DATA) &&
                    object.has(GenericEventConstant.GENERIC_EVENT_CONSTANT_EVENT_ID) &&
                    object.has(GenericEventConstant.GENERIC_EVENT_CONSTANT_TOPIC)) {

                EventTopic topic = EventTopic.getTopic(object.getInt(GenericEventConstant.GENERIC_EVENT_CONSTANT_TOPIC));
                EventType eventType = EventType.getType(object.getInt(GenericEventConstant.GENERIC_EVENT_CONSTANT_TYPE));
                String eventId = object.getString(GenericEventConstant.GENERIC_EVENT_CONSTANT_EVENT_ID);
                JSONObject data = object.getJSONObject(GenericEventConstant.GENERIC_EVENT_CONSTANT_DATA);

                if (eventType == EventType.EVENT_RESPONSE &&
                        topic == EventTopic.TOPIC_CONNECTION &&
                        data.has(AssociationEventConstant.ASSOCIATION_EVENT_ITEM)) {

                    return new ConnectionItem(topic, eventType, eventId, data).getItem();

                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static Map<String, BtConnection> parseAssociationList(String request) {

        Log.i(TAG, "event : " + request);

        JSONObject object = null;

        try {

            object = new JSONObject(request);

            if (object.has(GenericEventConstant.GENERIC_EVENT_CONSTANT_TYPE) &&
                    object.has(GenericEventConstant.GENERIC_EVENT_CONSTANT_DATA) &&
                    object.has(GenericEventConstant.GENERIC_EVENT_CONSTANT_EVENT_ID) &&
                    object.has(GenericEventConstant.GENERIC_EVENT_CONSTANT_TOPIC)) {

                EventTopic topic = EventTopic.getTopic(object.getInt(GenericEventConstant.GENERIC_EVENT_CONSTANT_TOPIC));
                EventType eventType = EventType.getType(object.getInt(GenericEventConstant.GENERIC_EVENT_CONSTANT_TYPE));
                String eventId = object.getString(GenericEventConstant.GENERIC_EVENT_CONSTANT_EVENT_ID);
                JSONObject data = object.getJSONObject(GenericEventConstant.GENERIC_EVENT_CONSTANT_DATA);

                if (eventType == EventType.EVENT_RESPONSE &&
                        topic == EventTopic.TOPIC_CONNECTION) {

                    return new AssociationList(topic, eventType, eventId, data).getList();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new HashMap<>();
    }

    public static Map<String, BluetoothSmartDevice> parseScanningList(String request) {

        Log.i(TAG, "event : " + request);

        JSONObject object = null;

        try {

            object = new JSONObject(request);

            if (object.has(GenericEventConstant.GENERIC_EVENT_CONSTANT_TYPE) &&
                    object.has(GenericEventConstant.GENERIC_EVENT_CONSTANT_DATA) &&
                    object.has(GenericEventConstant.GENERIC_EVENT_CONSTANT_EVENT_ID) &&
                    object.has(GenericEventConstant.GENERIC_EVENT_CONSTANT_TOPIC)) {

                EventTopic topic = EventTopic.getTopic(object.getInt(GenericEventConstant.GENERIC_EVENT_CONSTANT_TOPIC));
                EventType eventType = EventType.getType(object.getInt(GenericEventConstant.GENERIC_EVENT_CONSTANT_TYPE));
                String eventId = object.getString(GenericEventConstant.GENERIC_EVENT_CONSTANT_EVENT_ID);
                JSONObject data = object.getJSONObject(GenericEventConstant.GENERIC_EVENT_CONSTANT_DATA);

                if (eventType == EventType.EVENT_RESPONSE &&
                        topic == EventTopic.TOPIC_SCAN) {

                    return new ScanListItem(topic, eventType, eventId, data).getList();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }
}
