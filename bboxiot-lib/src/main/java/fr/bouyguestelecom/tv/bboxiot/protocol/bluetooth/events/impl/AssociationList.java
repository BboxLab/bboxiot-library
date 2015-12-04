package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.impl;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.connection.BtConnection;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.GenericEventAbstr;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.constant.AssociationEventConstant;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventTopic;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventType;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.inter.IAssociationList;

/**
 * @author Bertrand Martel
 */
public class AssociationList extends GenericEventAbstr implements IAssociationList {

    private static String TAG = AssociationEvent.class.getSimpleName();

    private Map<String, BtConnection> connectionList = new HashMap<>();

    public AssociationList(EventTopic topic, EventType type, String eventId, JSONObject data) {
        super(topic, type, eventId, data);

        try {
            if (data.has(AssociationEventConstant.ASSOCIATION_EVENT_ITEMS)) {

                JSONArray array = data.getJSONArray(AssociationEventConstant.ASSOCIATION_EVENT_ITEMS);

                for (int i = 0; i < array.length(); i++) {

                    BtConnection connection = BtConnection.parse((JSONObject) array.get(i));

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
    public Map<String, BtConnection> getList() {
        return connectionList;
    }
}
