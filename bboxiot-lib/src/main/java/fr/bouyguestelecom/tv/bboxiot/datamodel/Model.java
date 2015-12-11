package fr.bouyguestelecom.tv.bboxiot.datamodel;

import java.util.HashMap;
import java.util.Map;

import fr.bouyguestelecom.tv.bboxiot.datamodel.enums.ButtonState;
import fr.bouyguestelecom.tv.bboxiot.datamodel.enums.Functions;
import fr.bouyguestelecom.tv.bboxiot.datamodel.enums.Properties;
import fr.bouyguestelecom.tv.bboxiot.datamodel.enums.PropertyTypes;
import fr.bouyguestelecom.tv.bboxiot.datamodel.enums.Unit;

/**
 * @author Bertrand Martel
 */
public class Model {

    public static HashMap<Functions, Map<Properties, SmartProperty>> dataMap = new HashMap<>();

    static {
        Map<Properties, SmartProperty> properties = new HashMap<>();
        properties.put(Properties.ONOFF, new SmartProperty<Boolean>(Functions.SWITCH, Properties.ONOFF, PropertyTypes.BOOLEAN, Unit.NONE, false));
        dataMap.put(Functions.SWITCH, properties);

        properties = new HashMap<>();
        properties.put(Properties.CURRENT, new SmartProperty<Float>(Functions.SMART_METER, Properties.CURRENT, PropertyTypes.FLOAT, Unit.AMPERE, 0F));
        properties.put(Properties.TENSION, new SmartProperty<Float>(Functions.SMART_METER, Properties.TENSION, PropertyTypes.FLOAT, Unit.VOLTAGE, 0F));
        properties.put(Properties.POWER_FACTOR, new SmartProperty<Float>(Functions.SMART_METER, Properties.POWER_FACTOR, PropertyTypes.FLOAT, Unit.NONE, 0F));
        properties.put(Properties.ACTIVE_POWER, new SmartProperty<Float>(Functions.SMART_METER, Properties.ACTIVE_POWER, PropertyTypes.FLOAT, Unit.WATT, 0F));
        properties.put(Properties.REACTIVE_POWER, new SmartProperty<Float>(Functions.SMART_METER, Properties.REACTIVE_POWER, PropertyTypes.FLOAT, Unit.WATT, 0F));
        properties.put(Properties.FREQUENCY_MEASUREMENT, new SmartProperty<Integer>(Functions.SMART_METER, Properties.FREQUENCY_MEASUREMENT, PropertyTypes.INTEGER, Unit.SECOND, 0));
        dataMap.put(Functions.SMART_METER, properties);

        properties = new HashMap<>();
        properties.put(Properties.STATE, new SmartProperty<Integer>(Functions.BATTERY, Properties.STATE, PropertyTypes.INTEGER, Unit.PURCENT, 0));
        dataMap.put(Functions.BATTERY, properties);

        properties = new HashMap<>();
        properties.put(Properties.SUNLIGHT, new SmartProperty<Float>(Functions.PLANT_MONITOR, Properties.SUNLIGHT, PropertyTypes.FLOAT, Unit.NONE, 0F));
        properties.put(Properties.AIR_TEMPERATURE, new SmartProperty<Float>(Functions.PLANT_MONITOR, Properties.AIR_TEMPERATURE, PropertyTypes.FLOAT, Unit.CELSIUS, 0F));
        properties.put(Properties.SOIL_TEMPERATURE, new SmartProperty<Float>(Functions.PLANT_MONITOR, Properties.SOIL_TEMPERATURE, PropertyTypes.FLOAT, Unit.CELSIUS, 0F));
        properties.put(Properties.SOIL_ELECTRODUCTIVITY, new SmartProperty<Float>(Functions.PLANT_MONITOR, Properties.SOIL_ELECTRODUCTIVITY, PropertyTypes.FLOAT, Unit.NONE, 0F));
        properties.put(Properties.WATER_CONTENT, new SmartProperty<Float>(Functions.PLANT_MONITOR, Properties.WATER_CONTENT, PropertyTypes.FLOAT, Unit.PURCENT, 0F));
        dataMap.put(Functions.PLANT_MONITOR, properties);

        properties = new HashMap<>();
        properties.put(Properties.COLOR, new SmartProperty<Integer>(Functions.RGB_LED, Properties.COLOR, PropertyTypes.INTEGER, Unit.NONE, 0));
        properties.put(Properties.INTENSITY, new SmartProperty<Integer>(Functions.RGB_LED, Properties.INTENSITY, PropertyTypes.INTEGER, Unit.PURCENT, 0));
        dataMap.put(Functions.RGB_LED, properties);

        properties = new HashMap<>();
        properties.put(Properties.INTENSITY, new SmartProperty<Integer>(Functions.WHITE_LED, Properties.INTENSITY, PropertyTypes.INTEGER, Unit.PURCENT, 0));
        properties.put(Properties.TEMPERATURE, new SmartProperty<Integer>(Functions.WHITE_LED, Properties.TEMPERATURE, PropertyTypes.INTEGER, Unit.PURCENT, 0));
        dataMap.put(Functions.WHITE_LED, properties);

        properties = new HashMap<>();
        properties.put(Properties.SPEED, new SmartProperty<Integer>(Functions.OIL_DIFFUSER, Properties.SPEED, PropertyTypes.INTEGER, Unit.PURCENT, 0));
        dataMap.put(Functions.OIL_DIFFUSER, properties);

        properties = new HashMap<>();
        properties.put(Properties.TEMPERATURE, new SmartProperty<Float>(Functions.TEMPERATURE, Properties.TEMPERATURE, PropertyTypes.FLOAT, Unit.CELSIUS, 0F));
        dataMap.put(Functions.TEMPERATURE, properties);

        properties = new HashMap<>();
        properties.put(Properties.HUMIDITY, new SmartProperty<Float>(Functions.HUMIDITY, Properties.HUMIDITY, PropertyTypes.FLOAT, Unit.PURCENT, 0F));
        dataMap.put(Functions.HUMIDITY, properties);

        properties = new HashMap<>();
        properties.put(Properties.STATE, new SmartProperty<ButtonState>(Functions.BUTTON, Properties.STATE, PropertyTypes.BUTTON_STATE, Unit.NONE, ButtonState.NONE));
        dataMap.put(Functions.BUTTON, properties);

        properties = new HashMap<>();
        dataMap.put(Functions.BUZZER, properties);

    }
}