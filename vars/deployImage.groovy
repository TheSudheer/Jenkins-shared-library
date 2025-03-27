def call(String imageName) {
    echo 'Deploying docker image to EC2 using Docker Compose...'
    // Define the shell command to execute our script on EC2
    def shellCmd = "bash ./server-cmds.sh ${imageName}"
    def ec2IP = "ubuntu@52.87.160.165"
    
    sshagent(['ec2-server-key']) {
        // List files to verify the docker-compose file is in the workspace.
        sh "ls -l"
        // Copy the version-controlled docker-compose.yml file and server-cmds.sh to the remote EC2 instance.
        sh "scp docker-compose.yml ${ec2IP}:/home/ubuntu"
        sh "scp server-cmds.sh ${ec2IP}:/home/ubuntu"
        // SSH into the remote EC2 instance and execute the shell command.
        sh "ssh -o StrictHostKeyChecking=no ${ec2IP} '${shellCmd}'"
    }
}
