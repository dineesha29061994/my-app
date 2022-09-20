stage("tomcat deploy dev"){
            steps{
                sshagent(['tomcat-dev']) {
                 sh "scp -o StrictHostKeyChecking=no target/*.war ec2-user@172.31.36.27:/opt/tomcat9/webapps" 
                 sh "ssh ec2-user@172.31.36.27 /opt/tomcat9/bin/shutdown.sh"
                 sh "ssh ec2-user@172.31.36.27 /opt/tomcat9/bin/startup.sh"
                }
            }
