package fr.bouyguestelecom.tv.bboxiot.datamodel.enums;

/**
 * Color enum for Niu device
 * <p/>
 * Created by akinaru on 27/01/16.
 */
public enum NiuColor {

    NONE("none"),
    WHITE("white"),
    TECH_BLUE("tech_blue"),
    COZY_GREY("cozy_grey"),
    WAZABI("wazabi"),
    LAGOON("lagoon"),
    SOFTBERRY("softberry");

    private String valueStr = "";

    private NiuColor(String valueStr) {
        this.valueStr = valueStr;
    }

    public static NiuColor getNiuColorStr(String value) {

        for (NiuColor niuColor : NiuColor.values()) {
            if (value.equals(niuColor.valueStr))
                return niuColor;
        }
        return NONE;
    }

    public String getValueStr() {
        return valueStr;
    }
}
