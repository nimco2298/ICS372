Please use the folder "ourClasses" for the most current version of the program
  
Packages to use: ourClasses, Test

It is necessary to import the JSON jar file that can be located at: https://code.google.com/archive/p/json-simple/downloads

IDE used: Eclipse

Android App:

Configure Emulator for Importing

  First, run your emulator. While it is running, open the Device Explorer on the bottom right hand side of Android Studio
  Second, you need to place any .json/.xml files that need to be read, in the Downloads folder of the sdcard folder inside the    Device Explorer.
  Next, set these permissions in your AndroidManifest.xml file.
  Then, run the emulator. Find the Settings of the Android phone and select Permissions. Once you are at the permissions page, select the Field Agents App and turn on the Storage option. Now your app is able to read from the sd card!
  Finally, run the Android Emulator.
