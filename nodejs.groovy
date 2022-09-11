job('NodeJS example') {
    scm {
        git('https://github.com/pooja201095/Node-Docker-Demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('pooja201095')
            node / gitConfigEmail('poojachavan153@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('Node 16') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        shell("npm install")
    }
}
