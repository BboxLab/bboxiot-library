package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Set;

import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.constant.Common;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventRegistration;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventTopic;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventType;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.impl.BluetoothStateEvent;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.impl.RegistrationEvent;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.utils.RandomGen;

/**
 * @author Bertrand Martel
 */
public class EventBuilder {

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
        return new RegistrationEvent(EventTopic.TOPIC_BLUETOOTH_STATE, EventType.EVENT_REGISTRATION, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), value);
    }

    public static IGenericEvent buildBluetoothStateEvent(boolean state) {

        JSONObject value = new JSONObject();
        try {
            value.put(Common.CONSTANT_COMMON_VALUE, state);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new BluetoothStateEvent(EventTopic.TOPIC_BLUETOOTH_STATE, EventType.EVENT_INCOMING, new RandomGen(Common.EVENT_ID_LENGTH).nextString(), value);
    }
}
