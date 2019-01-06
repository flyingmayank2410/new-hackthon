var http = require('http');

const request = require('request');

request('http://localhost:8080/api/users/all', { json: true }, (err, res, body) => {
  if (err) { return console.log(err); }
  console.log(res);
  return res;
});

//create a server object:
http.createServer(function (req, res) {
  res.write('Hello World!'); //write a response to the client
  res.end(); //end the response
}).listen(3000); //the server object listens on port 8080