package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events;

import org.json.JSONException;
import org.json.JSONObject;

import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.constant.GenericEventConstant;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventTopic;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventType;

/**
 * @author Bertrand Martel
 */
public abstract class GenericEventAbstr implements IGenericEvent {

    private static String TAG = GenericEventAbstr.class.getSimpleName();

    protected EventTopic topic = EventTopic.TOPIC_NONE;

    protected EventType type = EventType.EVENT_UNKNOWN;

    protected JSONObject data = null;

    protected String eventId = "";

    public GenericEventAbstr(EventTopic topic, EventType type, String eventId, JSONObject data) {
        this.topic = topic;
        this.type = type;
        this.data = data;
        this.eventId = eventId;
    }

    @Override
    public EventTopic getTopic() {
        return topic;
    }

    @Override
    public EventType getType() {
        return type;
    }

    @Override
    public JSONObject getData() {
        return data;
    }

    @Override
    public String getEventId() {
        return eventId;
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
