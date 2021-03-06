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
package fr.bouyguestelecom.tv.bboxiot.events.impl;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import fr.bouyguestelecom.tv.bboxiot.events.GenericEventAbstr;
import fr.bouyguestelecom.tv.bboxiot.events.constant.AssociationEventConstant;
import fr.bouyguestelecom.tv.bboxiot.events.enums.EventTopic;
import fr.bouyguestelecom.tv.bboxiot.events.enums.EventType;
import fr.bouyguestelecom.tv.bboxiot.events.inter.IAssociationList;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.connection.BtAssociatedDevice;

/**
 * features an association list
 *
 * @author Bertrand Martel
 */
public class AssociationList extends GenericEventAbstr implements IAssociationList {

    private static String TAG = ConnectionEvent.class.getSimpleName();

    private Map<String, BtAssociatedDevice> connectionList = new HashMap<>();

    private JSONArray connectionItems = new JSONArray();

    public AssociationList(EventTopic topic, EventType type, String eventId, JSONObject data) {
        super(topic, type, eventId, data);

        try {
            if (data.has(AssociationEventConstant.ASSOCIATION_EVENT_ITEMS)) {

                connectionItems = data.getJSONArray(AssociationEventConstant.ASSOCIATION_EVENT_ITEMS);

                for (int i = 0; i < connectionItems.length(); i++) {

                    BtAssociatedDevice connection = BtAssociatedDevice.parse((JSONObject) connectionItems.get(i));

                    if (connection != null) {
                        connectionList.put(connection.getDeviceUuid(), connection);
                    }
                }

            } else {
                Log.e(TAG, "Error bad format for association event");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<String, BtAssociatedDevice> getList() {
        return connectionList;
    }

    @Override
    public JSONArray toJsonArray() {
        return connectionItems;
    }
}
