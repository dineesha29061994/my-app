def call (ip,user){
        ssh agent ([credid]){
        scp -o StrictHostKeyChecking=no target/myweb-0.0.9.war "${user}@${ip}:/opt/tomcat9/webapps" 
        ssh "${user}@${ip} /opt/tomcat9/bin/shutdown.sh"
        ssh "${user}@${ip} /opt/tomcat9/bin/startup.sh"
                }
            }
