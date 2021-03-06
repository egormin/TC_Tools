package TcTools.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.buildFeatures.replaceContent
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.script

object TcTools_SynchronizeToolsList : BuildType({
    uuid = "16fd2e58-e892-4e1f-a1cf-72029a86765c"
    id = "TcTools_SynchronizeToolsList"
    name = "Synchronize Tools list"

    vcs {
        root(TcTools.vcsRoots.TcTools_HttpsGithubComEgorminTcToolsRefsHeadsMaster)

    }

    steps {
        script {
            name = "=== Synchronization script running ==="
            enabled = false
            scriptContent = """
                chmod +x artifactory_getToolList.py
                ./artifactory_getToolList.py
                git push
            """.trimIndent()
        }
        script {
            name = "push"
            scriptContent = "git push"
        }
    }

    features {
        replaceContent {
            fileRules = "artifactory_getToolList.py"
            pattern = "__myUser__"
            replacement = "%env.User%"
        }
        replaceContent {
            fileRules = "artifactory_getToolList.py"
            pattern = "__myPassword__"
            replacement = "%env.Pass%"
        }
    }
})
