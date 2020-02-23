pipeline {
    agent any
    stages {
        stage('Build') {
         environment{
                mavenHome = tool 'Maven'
            }
            steps {
                sh " ${mavenHome}/bin/mvn -B -Dversion=${BUILD_NUMBER} -DskipTests clean package"
            }
        }
        stage('Test') {
            environment{
                mavenHome = tool 'Maven'
            }
            steps {
                  sh " ${mavenHome}/bin/mvn test -Dversion=${BUILD_NUMBER}"
            }
            post {
                always {
                    tapdTestReport frameType: 'JUnit', onlyNewModified: true, reportPath: 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Quality'){
            environment{
                 mavenHome = tool 'Maven'
            }
            steps{
                withSonarQubeEnv('Sonar'){
                  sh  " ${mavenHome}/bin/mvn sonar:sonar -Dsonar.projectName=CTS-capital"
                }
            }
        }
        stage('Package'){
            steps{
                nexusPublisher nexusInstanceId: 'DevOpsNexus', nexusRepositoryId: 'releases', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: '', filePath: 'target/example-app-${BUILD_NUMBER}.jar']], mavenCoordinate: [artifactId: 'example-app', groupId: 'com.example.app', packaging: 'jar', version: '${BUILD_NUMBER}']]]
            }
        }
        stage('Deliver') {
            steps {
                sh 'sh ./deliver.sh'
            }
        }
    }
}
