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
package fr.bouyguestelecom.tv.bboxiot.protocol.bluetooth.events.enums;

/**
 * @author Bertrand Martel
 */
public enum EventTopic {

    TOPIC_NONE(0),
    TOPIC_SCAN(1),
    TOPIC_CONNECTION(2),
    TOPIC_PROPERTIES(3),
    TOPIC_BLUETOOTH_STATE(4);

    private int value;

    private EventTopic(int value) {
        this.value = value;
    }

    public static EventTopic getTopic(int value) {

        switch (value) {
            case 0:
                return TOPIC_NONE;
            case 1:
                return TOPIC_SCAN;
            case 2:
                return TOPIC_CONNECTION;
            case 3:
                return TOPIC_PROPERTIES;
            case 4:
                return TOPIC_BLUETOOTH_STATE;
            default:
                return TOPIC_NONE;
        }
    }
}
