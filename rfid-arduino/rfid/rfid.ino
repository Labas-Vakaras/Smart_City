/*
 * For demonstration purposes we write a CityItemId to the RFID card
 * and then we read it back
 * 
 * Typical pin layout used:
 * -----------------------------------------------------------------------------------------
 *             MFRC522      Arduino       Arduino   Arduino    Arduino          Arduino
 *             Reader/PCD   Uno           Mega      Nano v3    Leonardo/Micro   Pro Micro
 * Signal      Pin          Pin           Pin       Pin        Pin              Pin
 * -----------------------------------------------------------------------------------------
 * RST/Reset   RST          9             5         D9         RESET/ICSP-5     RST
 * SPI SS      SDA(SS)      10            53        D10        10               10
 * SPI MOSI    MOSI         11 / ICSP-4   51        D11        ICSP-4           16
 * SPI MISO    MISO         12 / ICSP-1   50        D12        ICSP-1           14
 * SPI SCK     SCK          13 / ICSP-3   52        D13        ICSP-3           15
 * 
 */

#include <SPI.h>//include the SPI bus library
#include <MFRC522.h>//include the RFID reader library

#define SS_PIN 10  //slave select pin
#define RST_PIN 5  //reset pin
MFRC522 mfrc522(SS_PIN, RST_PIN); // instatiate a MFRC522 reader object.
MFRC522::MIFARE_Key key; //create a MIFARE_Key struct named 'key', which will hold the card information

int block=4; //Read Write Block
byte blockcontent[16] = {"590e1bfe0a975a4d85964909"};//an array with 16 bytes to be written into one of the 64 card blocks is defined
//byte blockcontent[16] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};//all zeros. This can be used to delete a block.
byte readbackblock[18];//This array is used for reading out a block. The MIFARE_Read method requires a buffer that is at least 18 bytes to hold the 16 bytes of a block.


void setup() {
  Serial.begin(9600);
  SPI.begin();
  mfrc522.PCD_Init();
  //Serial.println("Scan a card");
  
  // Prepare the security key for the read and write functions - all six key bytes are set to 0xFF from the factory.
  // Since the cards in the kit are new and the keys were never defined, they are 0xFF
  
  for (byte i = 0; i < 6; i++) {
    key.keyByte[i] = 0xFF;//keyByte is defined in the "MIFARE_Key" 'struct' definition in the .h file of the library
  }
}

void loop()
{

  /** Establish connection with a tag/card **/
        
  // Look for new cards
	if ( !mfrc522.PICC_IsNewCardPresent()) {//if PICC_IsNewCardPresent returns 1, a new card has been found and we continue
		return; //if it did not find a new card, it returns to the start of the loop
	}

	// Select one of the cards
	if ( !mfrc522.PICC_ReadCardSerial()) {//if PICC_ReadCardSerial returns 1, the "uid" struct contains the ID of the read card.
		return;//if it returns a '0' something went wrong and we return to the start of the loop
	}

  //Serial.println("card selected");

  /** Writing and reading on the card **/

  //City Item ID is more than 16 bytes (size of block) so we use 2 of them (#2 and #4)
  writeBlock(2, {"590e1bfe0a975a4d"});//the blockcontent array is written into the card block
  writeBlock(4, {"85964909"});
  //mfrc522.PICC_DumpToSerial(&(mfrc522.uid));
         
  //The 'PICC_DumpToSerial' method 'dumps' the entire MIFARE data block into the serial monitor. Very useful while programming a sketch with the RFID reader...
  //Notes:
  //(1) MIFARE cards conceal key A in all trailer blocks, and shows 0x00 instead of 0xFF. This is a secutiry feature. Key B appears to be public by default.
  //(2) The card needs to be on the reader for the entire duration of the dump. If it is removed prematurely, the dump interrupts and an error message will appear.
  //(3) The dump takes longer than the time alloted for interaction per pairing between reader and card, i.e. the readBlock function below will produce a timeout if
  //    the dump is used.
         
  //mfrc522.PICC_DumpToSerial(&(mfrc522.uid));//uncomment this if you want to see the entire 1k memory with the block written into it.
         
  readBlock(2, readbackblock);//read the block back
  //Serial.print("read block: ");
  for (int j=0 ; j<16 ; j++)//print the block contents
  {
   Serial.write (readbackblock[j]);//Serial.write() transmits the ASCII numbers as human readable characters to serial monitor
  }

  //clear read block
  for(int i=0; i<sizeof(readbackblock); i++) {
    readbackblock[i] = 0;
  }
  
  readBlock(4, readbackblock);//read the block back
  for (int j=0 ; j<8 ; j++)//print the block contents
  {
   Serial.write (readbackblock[j]);//Serial.write() transmits the ASCII numbers as human readable characters to serial monitor
  }
  
  Serial.println("");
}


