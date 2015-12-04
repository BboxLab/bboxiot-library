package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.impl;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.connection.BtConnection;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.GenericEventAbstr;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.constant.AssociationEventConstant;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventTopic;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventType;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.inter.IConnectionItem;

/**
 * @author Bertrand Martel
 */
public class ConnectionItem extends GenericEventAbstr implements IConnectionItem {

    private static String TAG = ScanItemEvent.class.getSimpleName();

    private BtConnection btConnection = null;

    public ConnectionItem(EventTopic topic, EventType type, String eventId, JSONObject data) {
        super(topic, type, eventId, data);

        try {
            if (data.has(AssociationEventConstant.ASSOCIATION_EVENT_CONNECTION)) {

                JSONObject connectionJson = data.getJSONObject(AssociationEventConstant.ASSOCIATION_EVENT_CONNECTION);

                BtConnection connection = BtConnection.parse(connectionJson);

                btConnection = connection;

            } else {
                Log.e(TAG, "Error in association item event format");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public BtConnection getItem() {
        return btConnection;
    }
}
