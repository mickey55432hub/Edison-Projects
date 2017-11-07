- - -- - - - -- - - -- - - - - -- - - - -
//truning on the flashlight on button
var groveSensor = require('jsupm_grove');
// Create the button object using GPIO pin 0
var button = new groveSensor.GroveButton(2);
// Read the input and print, waiting one second between readings
function readButtonValue() {
    console.log(button.name() + " value is " + button.value());
    var v=button.value();
    if(v==1){ led.on();}
    if(v==0){ led.off();}
}
setInterval(readButtonValue, 1000);




- - - -- - - - - -- - - - -- - - - - - - -
//Analog microphone

function readSoundSensorValue() {
    var buffer = new upmMicrophone.uint16Array(128);
    var len = myMic.getSampledWindow(2, 128, buffer);
    if (len)
    {
        var thresh = myMic.findThreshold(threshContext, 30, buffer, len);
        myMic.printGraph(threshContext);
        if (thresh)
            console.log("Threshold is " + thresh);
        v.saveValue(thresh);
        if(thresh>50 && thresh<150)
         showNormalLCD();
		  if(thresh>=150)
        showLCD();
        if(thresh<50)
        showSleepLCD();
    }
}
setInterval(readSoundSensorValue, 1000); 


- - - - - -- - - - -- - - - - - - - - - - -

  var temp = new groveSensor.GroveTemp(1);
console.log(temp.name());
var i = 0;
var waiting = setInterval(function() {
        var celsius = temp.value();
        var fahrenheit = celsius * 9.0/5.0 + 32.0;
        console.log(celsius + " degrees Celsius, or " +
            Math.round(fahrenheit) + " degrees Farenheit");
        i++;
        if (i == 10) clearInterval(waiting);
        }, 1000);
		
		
// Code for displaying time and Temperature
var lcd = new jsUpmI2cLcd.Jhd1313m1(6, 0x3E, 0x62);
var groveSensor = require('jsupm_grove');
var today = setInterval(function ()
    {
    var d = new Date();
    var b= d.toTimeString();
    lcd.setColor(0, 255, 0);
// Go to the 2nd row, 6th character (0-indexed)

    lcd.setCursor(0,0);
    lcd.write(b);
        var celsius = temp.value();
        var fahrenheit = celsius * 9.0/5.0 + 32.0;
        var t = Math.round(fahrenheit);
        lcd.setCursor(1, 1);
        lcd.write(t+" *F");
        v.saveValue(t);
}, 1000);

- - - - -- - - - -- - - - - - -- - - -- - - - -


//Load Grove Motion module
 var grove_motion = require('jsupm_biss0001');
 // Instantiate a Grove Motion sensor on GPIO pin D2
 var myMotionObj = new grove_motion.BISS0001(2);
 setInterval(function()
 {
 if (myMotionObj.value())
 {
 BlinkLED();
 melody();
 v.saveValue(1);
 console.log("Detecting moving object");
}
 else
 console.log("No moving objects detected");
 v.saveValue(0);
 }, 1000);
// Print message when exiting
 process.on('SIGINT', function()
 {
 console.log("Exiting...");
 process.exit(0);
 });
 
 
 
 
 
 - - - - - - - - --  - - - - - - - ---- -- - -- - -
 
  - - - - - - - - - - -
  
  
  
  
