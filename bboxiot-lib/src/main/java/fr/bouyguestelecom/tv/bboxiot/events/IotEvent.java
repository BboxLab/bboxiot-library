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

import org.json.JSONException;
import org.json.JSONObject;

import fr.bouyguestelecom.tv.bboxiot.events.constant.AssociationEventConstant;
import fr.bouyguestelecom.tv.bboxiot.events.constant.Common;
import fr.bouyguestelecom.tv.bboxiot.events.constant.GenericEventConstant;
import fr.bouyguestelecom.tv.bboxiot.events.enums.EventTopic;
import fr.bouyguestelecom.tv.bboxiot.events.enums.EventType;
import fr.bouyguestelecom.tv.bboxiot.events.enums.ScanRegistrationType;
import fr.bouyguestelecom.tv.bboxiot.events.impl.AssociationList;
import fr.bouyguestelecom.tv.bboxiot.events.impl.BluetoothStateEvent;
import fr.bouyguestelecom.tv.bboxiot.events.impl.ConnectionEvent;
import fr.bouyguestelecom.tv.bboxiot.events.impl.ConnectionItem;
import fr.bouyguestelecom.tv.bboxiot.events.impl.PropertyResponseEvent;
import fr.bouyguestelecom.tv.bboxiot.events.impl.PropertyIncomingEvent;
import fr.bouyguestelecom.tv.bboxiot.events.impl.PropertyRequestEvent;
import fr.bouyguestelecom.tv.bboxiot.events.impl.RegistrationEvent;
import fr.bouyguestelecom.tv.bboxiot.events.impl.ScanItemEvent;
import fr.bouyguestelecom.tv.bboxiot.events.impl.ScanListItem;
import fr.bouyguestelecom.tv.bboxiot.events.impl.ScanStatusChangeEvent;
import fr.bouyguestelecom.tv.bboxiot.events.impl.ScanStatusEvent;
import fr.bouyguestelecom.tv.bboxiot.events.inter.IAssociationList;
import fr.bouyguestelecom.tv.bboxiot.events.inter.IScanList;

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

                                return new ConnectionEvent(topic, eventType, eventId, data);
                            }
                            case TOPIC_PROPERTIES: {

                                return new PropertyIncomingEvent(topic, eventType, eventId, data);
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
                    case EVENT_SUBSCRIPTION: {

                        return new RegistrationEvent(topic, eventType, eventId, data);
                    }
                    case EVENT_REQUEST: {

                        switch (topic) {

                            case TOPIC_SCAN: {
                                return new ScanStatusEvent(topic, eventType, eventId, data);
                            }
                            case TOPIC_CONNECTION: {
                                return new ScanItemEvent(topic, eventType, eventId, data);
                            }
                            case TOPIC_PROPERTIES: {
                                return new PropertyRequestEvent(topic, eventType, eventId, data);
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
                            case TOPIC_PROPERTIES: {

                                return new PropertyResponseEvent(topic, eventType, eventId, data);
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

    public static PropertyRequestEvent parsePropertyRequest(String request) {

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

                if ((eventType == EventType.EVENT_REQUEST) && (topic == EventTopic.TOPIC_PROPERTIES)) {
                    return new PropertyRequestEvent(topic, eventType, eventId, data);
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

    public static ConnectionItem parseConnectionItem(String request) {

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
                        data.has(AssociationEventConstant.ASSOCIATION_EVENT_CONNECTION)) {

                    return new ConnectionItem(topic, eventType, eventId, data);

                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static IAssociationList parseAssociationList(String request) {

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

                    return new AssociationList(topic, eventType, eventId, data);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static IScanList parseScanningList(String request) {

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

                    return new ScanListItem(topic, eventType, eventId, data);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
