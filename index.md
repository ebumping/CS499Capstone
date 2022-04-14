#For this self-assessment, I will be addressing several course outcomes that illustrate professional standards I have accomplished in the field of Computer Science.  

-Employ strategies for building collaborative environments that enable diverse audiences to support organizational decision making in the field of computer science 

In a team or individual environment when reviewing code (someone else’s or your own) it is important to be able to objectively evaluate and propose revisions before release. Code reviews are an important aspect that allow developers to better understand the weaknesses in functionalities within their software.  Code reviews make our product more robust, consistent, and sustainable.  They also offer us potential third-party insight that can often lead to vulnerability fixes as well as optimizations that we may have missed personally/the first time around.

-Design, develop, and deliver professional-quality oral, written, and visual communications that are coherent, technically sound, and appropriately adapted to specific audiences and contexts 

I would like to highlight my code review (review: https://youtu.be/WiMjnybejEk, proposed enhancements: https://youtu.be/4Wp_lF4yWx8) to demonstrate strategies for effectively communicating important information to stakeholders in a concise manor.  Best practices suggest not only considering your audience when presenting issues or prospective revisions.  One should also be mindful of burnout, as reviewing too much in one sitting makes you more likely to overlook vulnerabilities.  For each artifact, I cover structure, documentation, variables, arithmetic operations, loops & branches, and defensive programming.  Each component has multiple aspects that are explored in accordance with documentation which implements a standard (and standards are important in delivering a consistent product to clients).

-Design and evaluate computing solutions that solve a given problem using algorithmic principles and computer science practices and standards appropriate to its solution, while managing the trade-offs involved in design choices (data structures and algorithms) 


-Demonstrate an ability to use well-founded and innovative techniques, skills, and tools in computing practices for the purpose of implementing computer solutions that deliver value and accomplish industry-specific goals (software engineering/design/database) 

The first artifact highlighted here was initially a c++ program created from a reverse-engineered binary file.  To highlight my strengths in data structures and algorithms I decided to then convert this c++ program into a java program to further demonstrate my ability to break down, re-purpose and re-invent software projects. Through the conversion process there were a few minor snags, but to ensure security standards and Java best practices, new try/catch blocks had to be implemented.  

C++:
```
#include <iostream>
#include <string>
#include <vector>
using namespace std;

//tsk tsk.. global variables
vector<int> serviceChoice{ 1, 2, 1, 1, 2 };
string name1 = "Bob Jones";
string name2 = "Sarah Davis";
string name3 = "Amy Friendly";
string name4 = "Johnny Smith";
string name5 = "Carol Spears";
int num1 = serviceChoice[0];
int num2 = serviceChoice[1];
int num3 = serviceChoice[2];
int num4 = serviceChoice[3];
int num5 = serviceChoice[4];


vector<int> changeCustomerChoice(vector<int> serviceChoice, int client, int service) {
	//serviceChoice[client] << -service;
	//cout << serviceChoice[client] << endl;
	if (client == 1) {
		num1 = service;
	}
	else if (client == 2) {
		num2 = service;
	}
	else if (client == 3) {
		num3 = service;
	}
	else if (client == 4) {
		num4 = service;
	}
	else if (client == 5) {
		num5 = service;
	}
	else {
		//TODO::Handle exceptions?
	}

	return serviceChoice;

}

void displayInfo() {

	cout << "You chose 1" << endl;
	cout << "  Client's Name    Service Selected (1 = Brokerage, 2 = Retirement)" << endl;
	cout << "1. " << name1 << " selected option " << num1  << endl;
	cout << "2. " << name2 << " selected option " << num2 << endl;
	cout << "3. " << name3 << " selected option " << num3 << endl;
	cout << "4. " << name4 << " selected option " << num4 << endl;
	cout << "5. " << name5 << " selected option " << num5 << endl;

}


void checkUserPermission() {
	int  option, password;
	int loopMenu = 1;
	cout << "Enter your password:" << endl;
	cin >> password;

	if (password == 123) {
		while (loopMenu){
		cout << "What would you like to do?" << endl;
		cout << "DISPLAY the client list (enter 1)" << endl;
		cout << "CHANGE a client's choice (enter 2)" << endl; 
		cout << "Exit the program.. (enter 3)" << endl;
		cin >> option;
		if (option == 1) {
			displayInfo();
		}
		else if (option == 2) {
			int client, service;
			cout << "You chose 2" << endl;
			cout << "Enter the number of the client that you wish to change" << endl;
			//This was a previous security vulnerability
			//cin >> client;
			if (!(cin >> client)) {
				cin.clear();
				cin.ignore(INT8_MAX, '\n');
				cout << "invalid input" << endl;
				loopMenu = 1;
				
			}else
			cout << "Please enter the client's new service choice (1 = Brokerage, 2 = Retirement)" << endl;
			//More vulnerability handling
			//cin >> service;
			if (!(cin >> service)) {
				cin.clear();
				cin.ignore(INT8_MAX, '\n');
				cout << "invalid input" << endl;
				loopMenu = 1;
			}
			else {
				changeCustomerChoice(serviceChoice, client, service);
				}
			
		}
		else if (option == 3) {
			cout << "You chose 3" << endl;
			loopMenu = 0;
		}
		else if (option > 3){
			loopMenu = 1;
		}
		else {
			//handle weird input
			cin.clear();
			cin.ignore(INT8_MAX, '\n');
			cout << "invalid input" << endl;
			checkUserPermission();
		}
		}

	}
	else {
		cout << "Invalid Password. Please try again\n";
		password = '\0';
		checkUserPermission();

	}
}



int main() {
	string user;
	cout << "Created by Dilli Vanilli" << endl;
	cout << "Hello! Welcome to our Investment Company" << endl;
	cout << "Enter your username:" << endl;
	//possible issues in this getline
	getline(cin, user);
	checkUserPermission();


}
```
Java:
```
package investments;

//import java.util.HashMap;
//import java.util.Map;
import java.util.Scanner;

public class Investments {
	static int[] serviceChoice = {1,2,1,1,2};
	static String name1 = "Bob Jones";
	static String name2 = "Sarah Davis";
	static String name3 = "Amy Friendly";
	static String name4 = "Johnny Smith";
	static String name5 = "Carol Spears";
	
	/*	This could be a better way to handle the clients
	
	String[] clientList = {"Bob Jones", "Sarah Davis",
							"Amy Friendly", "Johnny Smith",
							"Carol Spears"};
	*/
	static int clientChoice1 = serviceChoice[0];
	static int clientChoice2 = serviceChoice[1];
	static int clientChoice3 = serviceChoice[2];
	static int clientChoice4 = serviceChoice[3];
	static int clientChoice5 = serviceChoice[4];
	
	public static int[] changeCustomerChoice(int[] serviceChoice, int client, int service) {
		if(client == 1) {
			clientChoice1 = service;
		}
		else if (client == 2) {
			clientChoice2 = service;
		}
		else if (client == 3) {
			clientChoice3 = service;
		}
		else if (client == 4) {
			clientChoice4 = service;
		}
		else if (client == 5) {
			clientChoice5 = service;
		}else {
			//TODO:Handle fringe cases?
		}
		return serviceChoice;
		
	}
	
	static void displayInfo() {
		System.out.println("You chose 1");
		System.out.println("  Client's Name    Service Selected (1 = Brokerage, 2 = Retirement)");
		//this could be handled in a loop
		System.out.println("1. " + name1 + " selected option " + clientChoice1);
		System.out.println("2. " + name2 + " selected option " + clientChoice2);
		System.out.println("3. " + name3 + " selected option " + clientChoice3);
		System.out.println("4. " + name4 + " selected option " + clientChoice4);
		System.out.println("5. " + name5 + " selected option " + clientChoice2);
	}
	
	static void checkUserPermission() {
		int password;
		boolean loopMenu = true;
		Scanner in = new Scanner(System.in);		
		System.out.println("Enter your password:");
		int pw = in.nextInt();

		while(loopMenu == true) {
			if(pw == 123) {
				try {
				System.out.println("What would you like to do?");
				System.out.println("DISPLAY the client list (enter 1)");
				System.out.println("CHANGE a client's choice (enter 2)");
				System.out.println("Exit the program.. (enter 3)");
				int option = in.nextInt();

				
				if (option == 1) {
					displayInfo();
				}
				else if(option == 2) {
					int client, service;
					System.out.println("You chose 2");
					System.out.println("Enter the number of the client that you wish to change");
					client = in.nextInt();
					System.out.println("Please enter the client's new service choice "
									+ "(1 = Brokerage, 2 = Retirement)");
					service = in.nextInt();
					changeCustomerChoice(serviceChoice, client, service);
					//TODO: finish translating this
				}else if(option == 3){
					System.out.println("You chose 3");
					loopMenu = false;
				}else if(option > 3) {
					loopMenu = true;
				}else{
					checkUserPermission();
				}
			}catch(Exception e1) {
				System.out.println("An error has occured.");
				loopMenu = false;
				checkUserPermission();
				
			}
			}else loopMenu = true;

			
		}
		
	}
	
		public static void main(String[] argz) {
			Scanner in = new Scanner(System.in);
			System.out.println("Created by Dilli Vanilli");
			System.out.println("Hello! Welcome to our Investment Company");
			System.out.println("Enter your username:");
			String user = in.next();
			checkUserPermission();
		}
	}
```

The second artifact I would like to highlight here is a full-stack application developed specifically to implement a cloud Mongo database that interacts with a react.js-based front end.  Initial planned enhancements were flawed in scope, and technically unachievable so I decided to build an entirely new full-stack application

https://github.com/ebumping/CS499Capstone/tree/main/Capstone: 
`the_wired_volumes.zip.001- the_wired_volumes.zip.008`  

It currently functions as a simple user management system; however, this artifact was created with modularity in mind and could realistically hook into a wide range of applications.  The backend is run by a python module which contains much of the functional implementation of CRUD operations for our database, as well as handling the connection.

##Backend
```
from flask import Flask, render_template, request, jsonify
from pymongo import MongoClient
from bson.objectid import ObjectId
from flask_cors import CORS
import yaml
import certifi

ca = certifi.where()

app = Flask(__name__)
config = yaml.safe_load(open('database.yaml'))
client = MongoClient(config['uri'], tlsCAFile=ca)
db = client['Users']
CORS(app)

@app.route('/')
def index():
	return render_template('home.html')

@app.route('/users', methods=['POST', 'GET'])
def data():

	#Post data to database
	if request.method == 'POST':
		body = request.json
		firstName = body['firstName']
		lastName = body['lastName']
		emailId = body['emailId']
		db['users'].insert_one({
			"firstName": firstName,
			"lastName": lastName,
			"emailId": emailId
			})
		return jsonify({
			'status': 'Data is posted to MongoDB',
			'firstName': firstName,
			'lastName': lastName,
			'emailId': emailId
			})

	#GET all data from database
	if request.method == 'GET':
		allData = db['users'].find()
		dataJson = []
		for data in allData:
			id = data['_id']
			firstName = data['firstName']
			lastName = data['lastName']
			emailId = data['emailId']
			dataDict = {
				'id': str(id),
				'firstName': firstName,
				'lastName': lastName,
				'emailId': emailId
			}
			dataJson.append(dataDict)
			print(dataJson)
			return jsonify(dataJson)

@app.route('/users/<string:id>', methods=['GET', 'DELETE', 'PUT'])
def onedata(id):

	#GET specified data by id
	if request.method == 'GET':
		data = db['users'].find_one({'_id': ObjectId(id)})
		id = data['_id']
		firstName = data['firstName']
		lastName = data['lastName']
		emailId = data['emailId']
		dataDict = {
			'id': str(id),
			'firstName': firstName,
			'lastName': lastName,
			'emailId': emailId
		}
		print(dataDict)
		return jsonify(dataDict)

	#DELETE data
	if request.method == 'DELETE':
		db['users'].delete_many({'_id': ObjectId(id)})
		print('\n # Deletion successful # \n')
		return jsonify({'status': 'Data id: ' + id + ' is deleted.'})

	#UPDATE data by ID
	if request.method == 'PUT':
		body = request.json
		firstName = body['firstName']
		lastName = body['lastName']
		emailId = body['emailId']

		db['users'].update_one(
			{'_id': ObjectId(id)},
			{
				"$set": {
					"firstName":firstName,
					"lastName":lastName,
					"emailId": emailId
				}
			}
		)

		print('\n # Update Successful # \n')
		return jsonify({'status': 'Data id: ' + id + ' is updated.'})

if __name__ == '__main__':
	app.debug = True
	app.run()
```

-Develop a security mindset that anticipates adversarial exploits in software architecture and designs to expose potential vulnerabilities, mitigate design flaws, and ensure privacy and enhanced security of data and resources 

I would like to return to the `Investments` application first.  Even beginning with the c++ application, each function and input is explicitly designed to handle vulnerabilities.  In modern software development, we cannot afford to let security be an afterthought.  Each stage of the development lifecycle and each version must be designed and tested with security in mind.  This is illustrated further in the converted java program by utilizing try/catch blocks to handle exceptions. 

In addition, I developed an entire artifact around encrypting/decrypting files.  Originally, I had a previous encryption related program that I had intended on working with but decided that certain fundamental problems with the design of the original meant that I should rebuild from the ground up.  I wanted to give the new application more flexibility for the user, as most of the original relied on hardcoded values and did not provide users much independent value.  In a world with so much sensitive data, we must do our best to protect it.

###Encrypt.cpp
```
int main()
{
    //declare variables for filename, char c, and fstreams
    char fileName[30], c;
    fstream fs, ft;
    //prompt user for name of file
    cout << "Enter the Name of File with extension: ";
    //attempt to open specified file
    gets_s(fileName, 30);
    fs.open(fileName, fstream::in);
    //Handle errors with input
    if (!fs) {
        cout << "\nError Occurred Opening the Source file to read";
        return 0;
    }
    ft.open("temp.txt", fstream::out);
    //Handle errors with fstream ft
    if (!ft) {
        cout << "\nError Occured Opening/Creating the temp File";
        return 0;
    }
    while (fs >> noskipws >> c) {
        c = c + 100;
        ft << c;
    }
    fs.close();
    ft.close();
    fs.open(fileName, fstream::out);
    if (!fs) {
        cout << "\nError Occurred Opening the Source file to write";
        return 0;
    }
    ft.open("temp.txt", fstream::in);
    if (!ft) {
        cout << "\nError Occured Opening the temp file";
        return 0;
    }
    while (ft >> noskipws >> c) 
        fs << c;
    fs.close();
    ft.close();
    cout << "\nFile '" << fileName << "' Encrypted Successfully." << endl;
    return 0;
}
```
###Decrypt.cpp
```
int main()
{
    char fileName[30], ch;
    fstream fps, fpt;
    cout << "Enter the Name of File: ";
    gets_s(fileName);
    fps.open(fileName, fstream::out);
    if (!fps)
    {
        cout << "\nError Occurred while Opening the Source File!";
        return 0;
    }
    fpt.open("temp.txt", fstream::in);
    if (!fpt)
    {
        cout << "\nError Occurred while Opening/Creating tmp File!";
        return 0;
    }
    while (fpt >> noskipws >> ch)
    {
        ch = ch - 100;
        fps << ch;
    }
    fps.close();
    fpt.close();
    cout << "\nFile '" << fileName << "' Decrypted Successfully!";
    cout << endl;
    return 0;
}
```

Finally, in my full-stack application, login credentials to the database are obfuscated. 
```
config = yaml.safe_load(open('database.yaml'))
client = MongoClient(config['uri'], tlsCAFile=ca)
```


