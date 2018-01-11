package TcTools.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.triggers.vcs

object TcTools_Install : BuildType({
    uuid = "0660ed4a-f3f1-4603-8c1d-8051e6705b37"
    id = "TcTools_Install"
    name = "Install"

    vcs {
        root(TcTools.vcsRoots.TcTools_HttpsGithubComEgorminTcToolsRefsHeadsMaster)

    }

    triggers {
        vcs {
        }
    }
})
