//Reference help AWS API documentation http://docs.aws.amazon.com/AWSJavaScriptSDK/guide/node-intro.html

var os = require('os');
var fs = require('fs');
var AWS = require('aws-sdk');

//Keys
// AWS.config.secretAccessKey = "-----";  //Moved to local .aws/credentials file
// AWS.config.accessKeyId = "-----";  // Moved to local .aws/credentials file

//Set region
AWS.config.region = 'us-west-2';

var ec2 = new AWS.EC2();

//Set parameter values for image, groups, keys
var params = {
  ImageId: 'ami-d732f0b7', // Amazon Linux AMI x86_64 EBS
  InstanceType: 't2.micro',
  MinCount: 1, MaxCount: 1,
  SecurityGroupIds: ["sg-ee37f697"],
  SecurityGroups: ["hw1"],
  KeyName: "id_rsa"
};

// Create the instance
ec2.runInstances(params, function(err, data) {
  if (err) { console.log("Could not create instance", err); return; }

  var instanceId = data.Instances[0].InstanceId;
  console.log("Instance created: ", instanceId);

  // Add tags to the instance
  	ec2.describeInstances({InstanceIds:[instanceId]}, function(err, data){
	if (err) { 
        console.log("Could not find instance", err); 
        return; 
    }

    //Get the IP address and display the same
    var ip = data.Reservations[0].Instances[0].PublicIpAddress;
    console.log("IP Address: ",ip);

    //Write to inventory file
    console.log("Now writing to inventory file..");
    var appendInventory = "aws ansible_ssh_host=" + ip + " ansible_ssh_user=ubuntu ansible_ssh_private_key_file=~/.ssh/id_rsa\n";
    fs.appendFileSync('inventory', appendInventory, encoding='utf8');
    console.log("Inventory file has been written.");
  	});
});