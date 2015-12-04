package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.impl;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.connection.BtConnection;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.GenericEventAbstr;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.constant.AssociationEventConstant;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.ConnectionState;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventTopic;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventType;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.inter.IAssociationEvent;

/**
 * @author Bertrand Martel
 */
public class ConnectionEvent extends GenericEventAbstr implements IAssociationEvent {

    private static String TAG = ConnectionEvent.class.getSimpleName();

    private ConnectionState state = ConnectionState.UNDEFINED;

    private BtConnection connection = null;

    public ConnectionEvent(EventTopic topic, EventType type, String eventId, JSONObject data) {
        super(topic, type, eventId, data);

        try {

            if (data.has(AssociationEventConstant.ASSOCIATION_EVENT_STATE)) {

                state = ConnectionState.getState(data.getInt(AssociationEventConstant.ASSOCIATION_EVENT_STATE));

                if (data.has(AssociationEventConstant.ASSOCIATION_EVENT_CONNECTION))
                    connection = BtConnection.parse(data.getJSONObject(AssociationEventConstant.ASSOCIATION_EVENT_CONNECTION));
            } else {
                Log.e(TAG, "Error bad format for association event");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ConnectionState getState() {
        return state;
    }

    @Override
    public BtConnection getConnection() {
        return connection;
    }
}
