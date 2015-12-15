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
public enum PropertyTypes {

    NONE(0),
    INTEGER(1),
    BOOLEAN(2),
    FLOAT(3),
    VOID(4),
    FLOAT_MAP(5),
    PIXEL(6),
    BUTTON_STATE(7);

    private int value = 0;

    private PropertyTypes(int value) {
        this.value = value;
    }

    public static PropertyTypes getPropertyType(int value) {

        switch (value) {
            case 0:
                return NONE;
            case 1:
                return INTEGER;
            case 2:
                return BOOLEAN;
            case 3:
                return FLOAT;
            case 4:
                return VOID;
            case 5:
                return FLOAT_MAP;
            case 6:
                return PIXEL;
            case 7:
                return BUTTON_STATE;
        }
        return NONE;
    }

}
