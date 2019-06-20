/**
 * Created by Vijaya Yeruva on 5/27/2017.
 */

var MongoClient = require('mongodb').MongoClient;
var url = 'mongodb+srv://dbuser:dbpwd@cluster0-q7pex.mongodb.net/test?retryWrites=false&w=majority';

MongoClient.connect(url, function(err, db) {
    if (err) throw err;
    var dbase = db.db("Web_Lesson6");
    var myquery = { address: /^H/ };
    var newvalues = {$set: {name: "Pagadala"} };
    var myoptions = { multi: true };
    dbase.collection("NewOne").updateMany(myquery, newvalues, myoptions, function(err, res) {
        if (err) throw err;
        console.log(res.result.nModified + " record(s) updated");
        db.close();
    });
});
