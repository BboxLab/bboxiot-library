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

import org.json.JSONException;
import org.json.JSONObject;

import fr.bouyguestelecom.tv.bboxiot.events.constant.Common;
import fr.bouyguestelecom.tv.bboxiot.events.constant.GenericEventConstant;
import fr.bouyguestelecom.tv.bboxiot.events.enums.EventTopic;
import fr.bouyguestelecom.tv.bboxiot.events.enums.EventType;

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
            event.put(GenericEventConstant.GENERIC_EVENT_CONSTANT_TOPIC, EventBuilder.buildPair(topic));
            event.put(GenericEventConstant.GENERIC_EVENT_CONSTANT_TYPE, EventBuilder.buildPair(type));
            
            event.put(GenericEventConstant.GENERIC_EVENT_CONSTANT_EVENT_ID, eventId);
            event.put(GenericEventConstant.GENERIC_EVENT_CONSTANT_DATA, data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return event.toString();
    }
}
