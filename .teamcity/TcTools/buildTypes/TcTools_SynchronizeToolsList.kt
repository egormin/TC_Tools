package TcTools.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.*
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
            scriptContent = """
                ls
                pwd
            """.trimIndent()
        }
    }
})
