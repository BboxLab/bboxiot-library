package fr.bouyguestelecom.tv.bboxiot.listener;

/**
 * @author Bertrand Martel
 */
public interface IPushListener {

    public boolean onPush(Object value, String eventId);
}
