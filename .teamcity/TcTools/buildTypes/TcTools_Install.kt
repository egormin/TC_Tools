package TcTools.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.triggers.vcs

object TcTools_Install : BuildType({
    uuid = "0660ed4a-f3f1-4603-8c1d-8051e6705b37"
    id = "TcTools_Install"
    name = "Install"

    params {
        select("Choose Tool", "tool", label = "Tool", display = ParameterDisplay.PROMPT,
                allowMultiple = true,
                options = listOf("Java 1.7", "Java 1.8", "Gradle 3", "Gradle 4", "Terraform 3", "Terraform 4"))
    }

    vcs {
        root(TcTools.vcsRoots.TcTools_HttpsGithubComEgorminTcToolsRefsHeadsMaster)

    }

    triggers {
        vcs {
        }
    }
})
