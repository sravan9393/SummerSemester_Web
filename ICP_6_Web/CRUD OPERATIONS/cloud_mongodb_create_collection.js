/**
 * Created by Vijaya Yeruva on 5/27/2017.
 */
var MongoClient = require('mongodb').MongoClient;
var url = 'mongodb+srv://dbuser:dbpwd@cluster0-q7pex.mongodb.net/test?retryWrites=true&w=majority';

MongoClient.connect(url, function(err, db) {
    if (err) throw err;
    var dbase = db.db("Web_Lesson6");
    dbase.createCollection("second", function(err, res) {
        if (err) throw err;
        console.log("Collection created!");
        db.close();
    });
});
