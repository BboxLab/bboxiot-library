package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.impl;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventTopic;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventType;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.GenericEvent;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.constant.Common;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.constant.GenericEventConstant;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.inter.IBluetoothStateEvent;

/**
 * @author Bertrand Martel
 */
public class BluetoothStateEvent extends GenericEvent implements IBluetoothStateEvent {

    private static String TAG = BluetoothStateEvent.class.getSimpleName();

    private boolean state = false;

    public BluetoothStateEvent(EventTopic topic, EventType type, String eventId, JSONObject data) {
        super(topic, type, eventId, data);

        try {
            if (data.has(Common.CONSTANT_COMMON_VALUE)) {
                this.state = data.getBoolean(Common.CONSTANT_COMMON_VALUE);
            } else {
                Log.e(TAG, "Error in Bluetooth state event format");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean getBluetoothState() {
        return state;
    }

    @Override
    public String toJsonString() {

        JSONObject event = new JSONObject();
        try {
            event.put(GenericEventConstant.GENERIC_EVENT_CONSTANT_TOPIC, topic.ordinal());
            event.put(GenericEventConstant.GENERIC_EVENT_CONSTANT_TYPE, type.ordinal());
            event.put(GenericEventConstant.GENERIC_EVENT_CONSTANT_EVENT_ID, eventId);
            event.put(GenericEventConstant.GENERIC_EVENT_CONSTANT_DATA, data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return event.toString();
    }
    
}
