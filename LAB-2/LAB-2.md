# CSEE5590/490: Web/Mobile Programming (Summer 2019)
LAB ASSIGNMENT       
TEAM ID: 5      
Team members:     
Sravan Kumar Pagadala, Class ID: 12    
Nagarjuna Kolla, Class ID: 6   
Sushmanth Makkena, Class ID: 9    
Sindhusha Tiyyagura, Class ID: 17    

# TASK-1  ::: Developing MEAN stack application for User Authentication.    

## i. Introduction
1) Main page with LogIn and SignUp options.
2) After signing up - User details are stored in the MongoDB as a document with the user email, firstname, lastname, encrypted password details.
3) After saving the details - User will be redirected to the LogIn page( including few validations ), authenticated by matching the user details.
4) After Logging In, User profile is shown with all the details provided during the registration. 

## ii. Objectives
The main objective of the web application is:
1) to create a basic web application using MEAN stack where user details are stored and retrieved from the MongoDB account or automatically logged In based on the user session and JWT token.

## iii. Approaches/Methods
1) We have created the server code using NodeJS, ExpressJS and MongoDB connections.   
To give `npm install` - to install all the libraries mentioned in the package.json files.   
Then giving `node app.js` or `nodemon` :-    
where node command doesn't check for any changes to the app.js file - where as nodemon command checks for file changes and reruns automatically.    
The following server code will be ran at localhost:3000 port number.
![](https://github.com/sindhusha-t/web-mobile-programming/raw/master/LAB-2/Task-1%20MEAN%20Authentication/Documentation/running%20server.png)

2) In the server side code:- We are using mongoose library to connect to the MongoDB - Document Database.   
app.js file opens the port number 3000 for MongoDB CRUD operations.   
models folder contains the MongoDB URL connection using mongoose library connect() function and the User model schema along with the validations and jwttoken.   
Before saving the details to the MongoDB - the password is hashed and then stored in the mongoDB.    
Register/Authenticate/userprofile does the operations like {saving the details to the MongoDB using save() function}/ {getting the jwttoken generated for particular user using passport library} / {getting or retrieving the details of the user from mongoDB server} respectively. 
![](https://github.com/sindhusha-t/web-mobile-programming/raw/master/LAB-2/Task-1%20MEAN%20Authentication/Documentation/MongoDB%20cloud%20storage.png)

3) In the client side: code is written in Angular6.    
 To give `npm install` - to install all the libraries mentioned in the package.json files.   
Then giving `ng server --open`:- which starts listening on port number 4200.
![](https://github.com/sindhusha-t/web-mobile-programming/raw/master/LAB-2/Task-1%20MEAN%20Authentication/Documentation/running%20client.png)

Created LogIn, signUp, User, UserProfile components using `ng g component name`.   
Created Auth Service using `ng g service name`.   

## iv. Workflow
1) Initially LogIn page is loaded --> Where auth service checks whether there is any local storage with the JWTtoken value.    
If present -> User is automatically authenticated and redirected to the UserProfile page.   
If there is no token present -> then User is redirected to the LogIn Page.
![](https://github.com/sindhusha-t/web-mobile-programming/raw/master/LAB-2/Task-1%20MEAN%20Authentication/Documentation/signin%20page.png)

2) In SignUp page -> User details are stored in the MongoDB by connecting to the port:3000/api/register URL which is a localhost server URL.   
During the storing process -> password is hased/encrypted and stored for non human readable format.
![](https://github.com/sindhusha-t/web-mobile-programming/raw/master/LAB-2/Task-1%20MEAN%20Authentication/Documentation/sign%20up%20page.png)

3) If the user tries to register again --> It shows an error message as shown below.
There are validations mentioned for the user details at both client side and Userschema side.
![](https://github.com/sindhusha-t/web-mobile-programming/raw/master/LAB-2/Task-1%20MEAN%20Authentication/Documentation/sign%20up%20for%20duplicate%20email.png)

4) The SignUp page after successful registration of User details.
![](https://github.com/sindhusha-t/web-mobile-programming/raw/master/LAB-2/Task-1%20MEAN%20Authentication/Documentation/sign%20up%20after%20successful.png)

5) There are validations mentioned for LogIn page as well.  LogIn calls localhost:3000/api/authenticate server URL for authenticating the user. 
![](https://github.com/sindhusha-t/web-mobile-programming/raw/master/LAB-2/Task-1%20MEAN%20Authentication/Documentation/LogIn%20After%20invalid%20details.png)

6) UserProfile is launched in two cases:    
a) When User Logging In for the first time.   
b) When user hits the page again without logging out.    
![](https://github.com/sindhusha-t/web-mobile-programming/raw/master/LAB-2/Task-1%20MEAN%20Authentication/Documentation/User%20Profile.png)

7) MongoDB storage Screenshot:
![](https://github.com/sindhusha-t/web-mobile-programming/raw/master/LAB-2/Task-1%20MEAN%20Authentication/Documentation/MongoDB%20cloud%20storage.png)

## v. Datasets and Parameters
We have used MongoDB for storing the user details.

# vii. Evaluation & Discussion
Initially we faced issues with the JWTtoken. We have learnt a lot trying to fix the errors and understand what is going in the backend working.

## viii. Conclusion
We have learnt how to automatically authorize the user to the main page using JWTtoken(authentication server(middle layer between client and server) before hitting the actual server). 

## ix. Links:
### Source code: 
https://github.com/sindhusha-t/web-mobile-programming/tree/master/LAB-2/Task-1%20MEAN%20Authentication/client
https://github.com/sindhusha-t/web-mobile-programming/tree/master/LAB-2/Task-1%20MEAN%20Authentication/server
### Documentation: 
https://github.com/sindhusha-t/web-mobile-programming/tree/master/LAB-2/Task-1%20MEAN%20Authentication/Documentation

# TASK-2  ::: Developing mobile application with user authentication using firebase and facebook social login.    

## i. Introduction
1) Main page with Login, Registration, Facebook social login features.
2) Registration page with email and password
3) login page with email and password
4) Facebook page redirects to the facebook URL.
5) User Profile page shows the user details from the login page or from the facebook URL. 

## ii. Objectives
The main objective of the mobile application is:
1) to create a basic mobile application with login, registration, facebook social login features.

## iii. Approaches/Methods
**Facebook Connection**
1) Created New Application in the facebook developers API -> It creates AppID and by default it is not live.
2) to make the application public --> One has to add Android Platform to the application and specify the hash key.
3) After adding the platform -> Developer has to give basic Privacy policy URL to the application.
4) After saving the details --> Android application is good to access the Facebook manager libraries.

![](https://github.com/sravan9393/SummerSemester_Web/raw/master/LAB-2/Task-2%20Documentation/platform%20permissions%20(1).png)
![](https://github.com/sravan9393/SummerSemester_Web/raw/master/LAB-2/Task-2%20Documentation/platform%20permissions%20(2).png)

**Firebase Connection**
1) In the Android SDK --> Developer has to open tools -> firebase.
2) It opens the required steps to connect to the firebase from the Android SDK.
3) After authentication specifying the application/project name in the firebase website.
4) Enabling email/password authentication in the firebase website.
5) After this adding the required dependencies in the build.gradle file.

**INTERNET ACCESS**
Adding the INTERNET ACCESS code in the manifest file for the android application to access the internet on the device.

**ANDROID APPLICATION**
1) For register User details are stored in the firebase.
2) For login User, user details are verified in the firebase account and it is authenticated and after successful authentication it is redirected to the User Profile page.
3) For Facebook Login User --> User is redirected to the facebook URL login page --> After Successful Login --> Page is redirected to User Profile page where user details are displayed after retrieving them from facebook. 

## iv. Workflow
1) First Launching page of the mobile application
![](https://github.com/sravan9393/SummerSemester_Web/raw/master/LAB-2/Task-2%20Documentation/Login%20page.jpeg)

2) Register page 
![](https://github.com/sravan9393/SummerSemester_Web/raw/master/LAB-2/Task-2%20Documentation/Register%20page.jpeg)

3) facebook Login page:
![](https://github.com/sravan9393/SummerSemester_Web/raw/master/LAB-2/Task-2%20Documentation/Facebook%20login%20page.jpeg)

4) After facebook Succesful LogIn:
![](https://github.com/sravan9393/SummerSemester_Web/raw/master/LAB-2/Task-2%20Documentation/After%20facebook%20login.jpeg)

5) After firebase succesful LogIn:
![](https://github.com/sravan9393/SummerSemester_Web/raw/master/LAB-2/Task-2%20Documentation/After%20firebase%20login.jpeg)

## v. Datasets and Parameters
We have used Firebase to store the user logIn details.

# vii. Evaluation & Discussion
Initially we faced issues with the dependency errors. After upgrading Android SDK version to the latest it was solved by following the guidelines it provides during the errors or warnings.

## viii. Conclusion
We have learnt how to do social login using facebook and twitter. 

## ix. Links:
### Source code: 
https://github.com/sravan9393/SummerSemester_Web/tree/master/LAB-2/Task-2%20Social%20Login%20Android%20Application

### Documentation: 
https://github.com/sravan9393/SummerSemester_Web/tree/master/LAB-2/Task-2%20Documentation
