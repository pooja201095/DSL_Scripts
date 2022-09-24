job('React SSR Docker example') {
    scm {
        git('https://github.com/pooja201095/server-side-rendering.git') {  node -> // is hudson.plugins.git.GitSCM
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
        dockerBuildAndPublish {
            repositoryName('poojac2010/ssr-react')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
