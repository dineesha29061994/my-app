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
				git url:"https://github.com/javahometech/my-app.git"
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
				sh 'scp -o StrictHostKeyChecking=no target/*.war ec2-user@172.31.5.42:/opt/tomc/webapps'
				sh 'ssh ec2-user@172.31.5.42 /opt/tomcat3/bin/shutdown.sh'
				sh 'ssh ec2-user@172.31.5.42 /opt/tomcat3/bin/startup.sh'
			}
		}
	}
}
