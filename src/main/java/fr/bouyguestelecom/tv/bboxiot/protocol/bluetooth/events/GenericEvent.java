package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events;

import org.json.JSONObject;

import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventTopic;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventType;

/**
 * @author Bertrand Martel
 */
public abstract class GenericEvent implements IGenericEvent {

    private static String TAG = GenericEvent.class.getSimpleName();

    protected EventTopic topic = EventTopic.TOPIC_NONE;

    protected EventType type = EventType.EVENT_UNKNOWN;

    protected JSONObject data = null;

    protected String eventId = "";

    public GenericEvent(EventTopic topic, EventType type, String eventId, JSONObject data) {
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
}
