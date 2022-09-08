pipeline{
parameters {
  choice choices: ['master', 'develop', 'qa'], description: 'choose a branch', name: 'choice'
}
	agent any
	stages{
		stage("git"){
			when {
				expression{
					params.choice == 'master'
				}
			}
			steps{
				git url:https://github.com/ravi057/myapp-2022
			}
		}
		stage("maven"){
			when{
				expression{
					params.choice == 'develop'
				}
			}
			steps{
				sh 'mvn clean package -DskipTests=true'
			}
		}
		stage("tomcat deploy"){
			when{
				expression{
					params.choice == 'qa'
				}
			}
			steps{
				sh 'scp -o StrictHostKeyChecking=no target/*.war ec2-user@tomcat-priv-IP:/opt/tomcat9/webapps'
				sh 'ssh ec2-user@tomcat-priv-IP /opt/tomcat9/bin/shutdown.sh'
				sh 'ssh ec2-user@tomcat-priv-IP /opt/tomcat9/bin/startup.sh'
			}
		}
	}
}
