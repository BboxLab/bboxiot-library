package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.impl;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.connection.BtConnection;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.GenericEventAbstr;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.constant.AssociationEventConstant;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.AssociationState;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventTopic;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums.EventType;
import fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.inter.IAssociationEvent;

/**
 * @author Bertrand Martel
 */
public class AssociationEvent extends GenericEventAbstr implements IAssociationEvent {

    private static String TAG = AssociationEvent.class.getSimpleName();

    private AssociationState state = AssociationState.ASSOCIATION_UNDEFINED;

    private BtConnection connection = null;

    public AssociationEvent(EventTopic topic, EventType type, String eventId, JSONObject data) {
        super(topic, type, eventId, data);

        try {

            if (data.has(AssociationEventConstant.ASSOCIATION_EVENT_STATE) &&
                    data.has(AssociationEventConstant.ASSOCIATION_EVENT_CONNECTION)) {

                state = AssociationState.getState(data.getInt(AssociationEventConstant.ASSOCIATION_EVENT_STATE));
                connection = BtConnection.parse(data.getJSONObject(AssociationEventConstant.ASSOCIATION_EVENT_CONNECTION));
            } else {
                Log.e(TAG, "Error bad format for association event");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public AssociationState getState() {
        return state;
    }

    @Override
    public BtConnection getConnection() {
        return connection;
    }
}
