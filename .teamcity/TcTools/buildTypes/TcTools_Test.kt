package TcTools.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.script

object TcTools_Test : BuildType({
    uuid = "8a12e094-eb96-41f3-8669-d375a0161161"
    id = "TcTools_Test"
    name = "Test"

    params {
        text("text", "fgsdfd", label = "text", display = ParameterDisplay.PROMPT, allowEmpty = true)
    }

    vcs {
        root(TcTools.vcsRoots.TcTools_HttpsGithubComEgorminTcToolsRefsHeadsMaster)

    }

    steps {
        script {
            name = "TEZT"
            scriptContent = """
                ls
                pwd
            """.trimIndent()
        }
    }
})
