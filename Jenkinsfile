pipeline {
    environment {
        QODANA_TOKEN = credentials('eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJvcmdhbml6YXRpb24iOiIzdzdZbyIsInByb2plY3QiOiJwbmpRTCIsInRva2VuIjoicG5qVk8ifQ.sPbqSLQsh3nmUDvgjUmjoTM0rrUNOjVpYASqxoaHvZI')
    }
    agent {
        docker {
            args '''
                -v "${WORKSPACE}":/data/project
                --entrypoint=""
                '''
            image 'jetbrains/qodana-jvm'
        }
    }
    stages {
        stage('Qodana') {
            when {
                branch 'main'
                branch 'patrice'
            }
            steps {
                sh '''qodana'''
            }
        }
    }
}