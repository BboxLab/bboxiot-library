package fr.bouyguestelecom.tv.bboxiot.listener;

/**
 * Listener for pull request clients
 *
 * @author Bertrand Martel
 */
public interface IPullListener {

    /**
     * called when a client has pulled value from a property
     *
     * @param eventId event identifier
     * @return
     */
    boolean onPull(String eventId);
}
