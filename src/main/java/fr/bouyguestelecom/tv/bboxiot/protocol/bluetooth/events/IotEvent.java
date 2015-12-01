package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.constant.GenericEventConstant;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventTopic;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventType;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.impl.BluetoothStateEvent;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.impl.RegistrationEvent;

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
                                break;
                            }
                            case TOPIC_CONNECTION: {
                                break;
                            }
                            case TOPIC_ASSOCIATION: {
                                break;
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
                        break;
                    }
                    case EVENT_RESPONSE: {
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
}
