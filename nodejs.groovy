job('NodeJS example') {
    scm {
        git('https://github.com/pooja201095/Node-Docker-Demo.git')
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
