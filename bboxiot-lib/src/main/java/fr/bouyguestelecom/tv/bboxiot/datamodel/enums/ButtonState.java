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
 * TH
 * package fr.bouyguestelecom.tv.bboxiot.datamodel;
 * <p/>
 * /**
 *
 * @author Bertrand Martel
 */
package fr.bouyguestelecom.tv.bboxiot.datamodel.enums;

/**
 * @author Bertrand Martel
 */
public enum ButtonState {

    NONE(0),
    RELEASED(1),
    PUSHED(2),
    DOUBLE_PUSH(3),
    LONG_PUSH(4),
    LONG_PUSH_RELEASE(5);

    private final int value;

    private ButtonState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ButtonState getState(int value) {

        switch (value) {
            case 1:
                return RELEASED;
            case 2:
                return PUSHED;
            case 3:
                return DOUBLE_PUSH;
            case 4:
                return LONG_PUSH;
            case 5:
                return LONG_PUSH_RELEASE;
        }
        return NONE;
    }
}
