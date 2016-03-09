package fr.bouyguestelecom.tv.bboxiot.listener;

/**
 * Listener for push request from clients
 *
 * @author Bertrand Martel
 */
public interface IPushListener {

    /**
     * called when one client has pushed a value
     *
     * @param value   generic value
     * @param eventId event identifier
     * @return
     */
    boolean onPush(Object value, String eventId);
}
