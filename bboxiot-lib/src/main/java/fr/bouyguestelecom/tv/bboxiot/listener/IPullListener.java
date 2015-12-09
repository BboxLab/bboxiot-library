package fr.bouyguestelecom.tv.bboxiot.listener;

/**
 * @author Bertrand Martel
 */
public interface IPullListener {

    public boolean onPull(String eventId);
}
