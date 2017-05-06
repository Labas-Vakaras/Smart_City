#======================================

import serial
import time
import webbrowser

print
print

# NOTE the user must ensure that the serial port and baudrate are correct
serPort = "/dev/ttyAMC0"
baudRate = 9600

ser = serial.Serial("/dev/serial/by-id/usb-Arduino__www.arduino.cc__0043_64032373933351B070D0-if00", baudRate, timeout=3.0)

print "Serial port " + serPort + " opened	Baudrate " + str(baudRate)

while True:
	line = ser.readline()
	if line != "":
		print line
		webbrowser.open('http://155.254.33.123:8082/item/report?id='+line, new=2)
		break


ser.close

