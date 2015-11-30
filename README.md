# Bbox IoT library v0.7

Bbox IoT is an Android service aiming at controlling and monitoring connected devices through high-level APIs

At this moment, this library is concentrating on Bluetooth Low Energy devices. Further Radio protocol could be added later.

Specific features are :

* bluetooth Low Energy devices control
* bluetooth connection workflow management
* high level APIs for for controlling bluetooth workflow and devices
* flexible architecture and datamodel for multi-protocol implementation

## Version History

Current release : <a href="#">0.7</a>

| version                                                                |    comment                 |
|------------------------------------------------------------------------|----------------------------|
| 0.7                                                                    | API refactoring            |
| 0.6                                                                    | witti devices support      |

## Scope

* Bluetooth discovery
  * scanning
* Bluetooth device control
  * association
  * connection
  * write/read characteristics
  * event monitoring
* Device database
  * store associated devices 

## Architecture

### Global 

![architecture](architecture.png)

### Supported devices

List of currently supported devices : 

|   Product Name               |    Manufacturer   |  functionnalities    |
|---------------------------|---------------|-----------------------------|
|   SmartLite   |     Beewi           |     state / color / intensity     |
|   SmartClim   |     Beewi          |     temperature / humidity         |
|   SmartTrack   |     Beewi          |     button single/double push (advertizing)         |
|   Aroma Light   |     AwoX          |     state / color / intensity / odor         |
|   SmartPlug   |     AwoX          |     state / active power         |
|   Flower Power   |     Parrot          |     air temperature / soil temperature / soil electroductivity / water content / luminosity         |
|   NIU   |     Altyor          |     button single push (advertizing)         |

This list may not be exhaustive, please go to https://dev.bouyguestelecom.fr/forum/viewforum.php?f=36 to get a fully updated list of supported device