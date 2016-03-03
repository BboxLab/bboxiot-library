# Bbox IoT library

[![Build Status](https://travis-ci.org/BboxLab/bboxiot-library.svg)](https://travis-ci.org/BboxLab/bboxiot-library)
[![Download](https://api.bintray.com/packages/bboxlab/maven/bboxiot-library/images/download.svg)](https://bintray.com/bboxlab/maven/bboxiot-library/_latestVersion)
[![Coverage Status](https://coveralls.io/repos/BboxLab/bboxiot-library/badge.svg?branch=master&service=github)](https://coveralls.io/github/BboxLab/bboxiot-library?branch=master)
[![License](http://img.shields.io/:license-mit-blue.svg)](LICENSE.md)

Android wrapper for BboxIoT

Bbox IoT is an Android service aiming at controlling and monitoring IoT devices through high-level APIs

<hr/>

At this moment, this library is concentrating on Bluetooth Low Energy devices. <br/>Further Radio protocol could be added later.

Specific features are :

* BLE devices control
* BLE connection workflow management
* high level APIs for controlling BLE workflow and devices
* flexible architecture and datamodel for multi-protocol implementation

## Including in your project

```
compile 'bboxlab:bboxiot-library:0.75'
```

## Version History

Current release : <a href="https://github.com/BboxLab/bboxiot-library/releases/tag/0.75">version 0.75</a>

| version                                                                |    comment                 |
|------------------------------------------------------------------------|----------------------------|
| 0.75                                                                   | bugs fix / more verbose JSON protocol / string alias for properties-functions |
| 0.73                                                                   | unit support for properties |
| 0.72                                                                   | SmarLite / Oblo / Notti devices support  |
| 0.71                                                                   | fewer API with JSON input for usability  |
| 0.7                                                                    | API refactoring            |
| 0.6                                                                    | witti devices support      |

## Requirements

To be able to use this library, you must have a Miami Box Android TV with BboxIoT service running

![Bbox Miami](img/bbox-miami.jpg)

## Scope

* BLE discovery
  * scanning
* BLE device control
  * association
  * connection
  * write/read characteristics
  * event monitoring
* Device database
  * store associated devices 

## Global architecture

![architecture](img/architecture.png)

The project you are watching is only the interface between your client and BboxIoT Service (in the middle)

## Supported devices

List of currently supported devices : 

|   Product Name               |    Manufacturer   |  Status                         |   type                 | functionnalities    |
|------------------------------|-------------------|---------------------------------|------------------------|---------------------|
|   SmartLite                  |     Beewi         |    ![good](img/status_good.png) |   actuator / sensor    | state / color / intensity     |
|   SmartClim                  |     Beewi         |  ![good](img/status_good.png)   |   sensor               | temperature / humidity         |
|   SmartTrack                 |     Beewi         |  ![good](img/status_good.png)   |    sensor              | button single/double push (advertizing)         |
|   Aroma Light                |     AwoX          | ![good](img/status_good.png)     |    actuator / sensor   | state / color / intensity / odor         |
|   SmartPlug                  |     AwoX          |   ![good](img/status_bad.png)   |    actuator / sensor   | state / active power         |
|   Flower Power               |     Parrot        |    ![good](img/status_bad.png)  |    sensor              | air temperature / soil temperature / soil electroductivity / water content / luminosity         |
|   NIU                        |     Altyor        |  ![good](img/status_good.png)   |     sensor             | button single push (advertizing)         |
|   Oblo                       |     RtRk          |    ![good](img/status_good.png) |     actuator / sensor  | state / tension / current / power factor / active power / reactive power     |
|   Notti                      |     Witty         |    ![good](img/status_good.png) |     actuator           | state / color     |

## Support

* BboxLab developper portal IoT section: https://dev.bouyguestelecom.fr/forum/viewforum.php?f=45
* BboxLab developper portal Download section : https://dev.bouyguestelecom.fr/forum/viewtopic.php?f=36&t=71

## License

The MIT License (MIT) Copyright (c) 2015-2016 InnovationLab BboxLab
