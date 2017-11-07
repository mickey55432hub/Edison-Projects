










 var ubidots = require('ubidots');
var client = ubidots.createClient('YOUR-API-KEY');
client.auth(function () {
  this.getDatasources(function (err, data) {
    console.log(data.results);
  });
  var ds = this.getDatasource('xxxxxxxx');
  ds.getVariables(function (err, data) {
    console.log(data.results);
  });
  ds.getDetails(function (err, details) {
   console.log(details);
 });
  var v = this.getVariable('xxxxxxx');
  v.getDetails(function (err, details) {
    console.log(details);
  });
  v.getValues(function (err, data) {
    console.log(data.results);
  });
  
