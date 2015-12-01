package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events;

import org.json.JSONObject;

import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventTopic;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventType;

/**
 * @author Bertrand Martel
 */
public interface IGenericEvent {

    public EventTopic getTopic();

    public EventType getType();

    public JSONObject getData();

    public String getEventId();

    public String toJsonString();
}
