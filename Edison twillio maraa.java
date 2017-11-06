// Set up our input pin on pin 5 of the Edison Arduino Boardvar mraa = require('mraa');
var buttonPin = new mraa.Gpio(5);
buttonPin.dir(mraa.DIR_IN);

//Set up the stuffs for Twilio.  You will need to set up an
//account to get your SID and your token/authentication keyvar twilio = require('twilio');
var client = new twilio.RestClient('<<twilio sid>>',				   '<<twilio token>>');


//Read our button
var buttonPushed = buttonPin.read();

//If our button was pressed, send our message
//You will need to fill in your own twilio number to make this work.//Note, we are texting 1(555)123-4567 here.  This is obviously a //wrong number.  Put your friend's in there instead.
if(buttonPushed){
	client.sms.messages.create({
		to:'+15551234567',
		from: '<<your twilio number>>',		body: 'I can\'t hear my light saber go SWOOSH SWOOSH over your racket.'
		}, function(error, message){
			if(!error){				console.log("Message sent at " + message.dateCreated);			} else {				console.log("Message wasn't sent...");			}		});	}

//Hold in the program until we release the button.while (buttonPushed){	setTimeout(emptyFunction, 200); //debounce	buttonPushed = buttonPin.read();
}
//When we use forever.js, it will need to make sure that our program lasts at//least 1 millisecond each time it runs.  So, we wait for 4 milliseconds before//ending our functionsetTimeout(emptyFunction, 4);//Basically, we use this for our delay.  We have to call some flavor of//function to use the setTimeout function.function emptyFunction(){
}
