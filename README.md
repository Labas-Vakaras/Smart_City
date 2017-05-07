# SmaCi - aka SmartCity

## Description
SmaCi is an online platform which provides a user friendly way to interact with your city. Here you can report problems to the appropriate authorities by scanning a QR barcode of the faulty city component, or just by using the near field communication features (RFID/NFC) of your smartphone

Great example of SmaCi capabilities is also the ability to send signals on traffic lights, which in turn can help people with disabilities cross the roads safely, by prolonging the green light. You only have to scan the QR code, or come closer to the passive RFID tag, which is embedded on the traffic light.

## Showcase
![smaci](https://cloud.githubusercontent.com/assets/6230644/25778211/7dad19b8-3300-11e7-9671-14a83ad58f80.gif)

## Technical
Smaci is written in JAVA along with Spark framework and MongoDB.

![technologies](https://cloud.githubusercontent.com/assets/6230644/25778306/b4b2ce7e-3302-11e7-86c1-e5e429d9b5f5.png)

## Run
* Make sure you have JAVA 8 or later installed and Mongo DB up and running
* Platform is running on local port 8082, which should be free
* Download the latest build from the releases
* Run it ``java -jar SmartCity-1.0-SNAPSHOT.jar``
* You can access it locally on ``https://localhost:8082``

## RFID Demonstration
> The repository also contains arduino code for RFID demonstration. Arduino RFID sensor scans IDs from passive tags and transmits it via serial usb interface. A computer running ComArduino.py python script, picks the ID and opens the browser to the problem report page. 

