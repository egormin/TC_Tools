package TcTools.patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2017_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2017_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, create a buildType with uuid = '7de85d10-e3d8-4e42-b9c5-7eda97c552b5' (id = 'TcTools_Build')
in the project with uuid = '50967372-bc45-4f8c-908e-44012f72ed5b' and delete the patch script.
*/
create("50967372-bc45-4f8c-908e-44012f72ed5b", BuildType({
    uuid = "7de85d10-e3d8-4e42-b9c5-7eda97c552b5"
    id = "TcTools_Build"
    name = "TC_agent_tools_sync"

    vcs {
        root("TcTools_HttpsGithubComEgorminTcAgentToolsSyncRefsHeadsMaster")

    }

    steps {
        script {
            scriptContent = """
                ls
                pwd 
                hostname
            """.trimIndent()
        }
    }

    triggers {
        vcs {
        }
    }
}))

