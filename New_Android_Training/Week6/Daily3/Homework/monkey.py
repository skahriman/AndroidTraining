# Imports the monkeyrunner modules used by this program
from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice

# Connects to the current device, returning a MonkeyDevice object
device = MonkeyRunner.waitForConnection()

# Installs the Android package. Notice that this method returns a boolean, so you can test
# to see if the installation worked.
device.installPackage('/Users/SefakKahriman/Desktop/TestingProject/MonkeyRunner/app/build/intermediates/instant-run-apk/debug/app-debug.apk')

# sets a variable with the package's internal name
package = 'com.example.sefakkahriman.monkeyrunner'

# sets a variable with the name of an Activity in the package
activity = 'com.example.sefakkahriman.monkeyrunner.MainActivity'

# sets the name of the component to start
runComponent = package + '/' + activity

# Runs the component
device.startActivity(component=runComponent)
MonkeyRunner.sleep(5)

# Presses the Menu button
device.press('KEYCODE_MENU', MonkeyDevice.DOWN_AND_UP)

# Takes a screenshot
result = device.takeSnapshot()

# Writes the screenshot to a file
result.writeToFile('/Users/SefakKahriman/Desktop/TestingProject/shot1.png','png')
