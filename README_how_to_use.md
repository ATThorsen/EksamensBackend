
<h2> SETUP </h2>

- Clone this project
- Rename your project
- Delete the .git folder
- Create your own git repository 
- Do "Your own" git init
- "First commit" and push
- Setup travis with github if you haven't already
- Find your github repository in on the travis webpage
- Locate <b> "More options" </b> and select <b> "Settings" </b>
- Locate Environment Variables and add fill out the input boxes with your environment variables <br>
<b> REMOTE_USER </b>  : <b> script_user </b>  <br>
<b> REMOTE_PW </b>  : Your value for the <b> "script_user" </b> password <br>







- Create two databases for local development xxx and xxx_test (if you are a group, make sure the databases are named the same)
- Create two databases on your droplet with the same name as your local. 
- in the .travis.yml file, find the command below, around line 43 and change "startcode_test" for your test database (xxx_test)
"- sudo mysql -u dev -pax2 -e "CREATE DATABASE startcode_test;"
- In gitbash run the "mvn test" command. 

<h2> Personalize your project </h2>

- Delete or Refactor Entity, Facade and Resources for your new project. 
- <b> Verify that your Resources has the correct database name.  <br>
Also make sure that config.properties has the correct database information </b>

- Clean and build your project (if you use netbeans repeat this step 3 or more times) 
- Test your project again with "mvn test" or "IDE test", if it fails its a do-over.

<h2> Deploying your project </h2>

- In your pom-file locate the properties section find the property below around line 18  and change it for you own server
  "  <remote.server>https://coffeeaddict.dk/manager/text</remote.server> " 
- ssh into your droplet and change the setenv.sh to match the properties of your database <br>
 "<b> sudo nano /opt/tomcat/bin/setenv.sh </b>" 
 
 -make sure you have the following in the setenv.sh file, using your own values. <br>
export DEPLOYED="DEV_ON_DIGITAL_OCEAN" <br>
export USER= <b>"YOUR_DB_USER" </b> <br>
export PW= <b>"YOUR_DB_PASSWORD" </b> <br>
export CONNECTION_STR="jdbc:mysql://localhost:3306/<b>NAME_OF_YOUR_DB</b>" <br>
- Save the file, and restart Tomcat with the command below <br>
<b> "sudo systemctl restart tomcat" </b>

- In your local Git-BASH deploy your project with the command below, make sure to change <b> PW_FOR_script_user </b> for your actual value<br> 
<b> " mvn clean test -Dremote.user=script_user -Dremote.password=PW_FOR_script_user tomcat7:deploy " </b>
 
- At this point your project should be deployed on your droplet. 
- Test some of your endpoints to make sure, your projects is deployed correcly. 







