
var MongoClient = require('mongodb').MongoClient;
var assert = require('assert');
var bodyParser = require("body-parser");
var express = require('express');
var cors = require('cors');
var app = express();

const url = 'mongodb+srv://ps:sha@cluster0-d53wt.mongodb.net/test?retryWrites=true&w=majority\n';
var ObjectID = require('mongodb').ObjectID;

app.use(cors());
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
app.post('/create', function (req, res) {
    MongoClient.connect(url, function(err, db) {
        var dbase = db.db('pss');
        if(err)
        {
            res.write("Failed, Error while connecting to Database");
            res.end();
        }
        insertDocument(dbase, req.body, function() {
            res.write("Successfully inserted");
            res.end();
        });
    });
});

app.get('/get', function (req, res) {
    MongoClient.connect(url, function(err, db) {
        if(err)
        {
            res.write("Failed, Error while connecting to Database");
            res.end();
        }
        var dbase = db.db('pss');
        dbase.collection('books').find().toArray(function(err, result){

            if(err)
            {
                res.write("get Failed");
                res.end();
            }else
            {

                res.send(JSON.stringify(result));
            }
            console.log("Got All Documents");

        });
    });

});

app.get('/delete/:toBeDeleted_id', function (req, res) {
    // 2.Connect to MongoDB . Handle the error and write the logic for deleting the desired book
    MongoClient.connect(url, function(err, db) {
        if (err) throw err;
        var dbase = db.db("pss");
        var myquery = { _id: ObjectID(req.params.toBeDeleted_id) };
        dbase.collection("books").deleteOne(myquery, function(err, obj) {
            if (err) throw err;
            console.log(obj.result.n + " document(s) deleted");
            db.close();
        });
    });
});


app.post('/update/:toBeUpdated_id', function (req, res) {
    //3.connect to MongoDB. Handle the error and write the logic for updating the selected field
    MongoClient.connect(url, function(err, db) {
        if (err) throw err;
        var dbase = db.db("pss");
        var myquery = {_id: ObjectID(req.params.toBeUpdated_id)};
        var newvalues = {$set: req.body};
        dbase.collection("books").updateMany(myquery, newvalues, function (err, res) {
            if (err) throw err;
            console.log(res.result.nModified + " record(s) updated");
            db.close();
        });
    });
});



var insertDocument = function(db, data, callback) {
    db.collection('books').insertOne( data, function(err, result) {
        if(err)
        {
            res.write("Registration Failed, Error While Registering");
            res.end();
        }
        console.log("Inserted a document into the books collection.");
        callback();
    });
};

var server = app.listen(8081, function () {
    var host = server.address().address;
    var port = server.address().port;

    console.log("Example app listening at http://%s:%s", host, port)
});
