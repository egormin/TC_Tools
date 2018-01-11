package TcTools

import TcTools.buildTypes.*
import TcTools.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.Project

object Project : Project({
    uuid = "50967372-bc45-4f8c-908e-44012f72ed5b"
    id = "TcTools"
    parentId = "_Root"
    name = "TC Tools"

    vcsRoot(TcTools_HttpsGithubComEgorminTcToolsRefsHeadsMaster)

    buildType(TcTools_Install)

    params {
        select("Choose Tool", "Tool", label = "Tool", display = ParameterDisplay.PROMPT,
                allowMultiple = true,
                options = listOf("Java 1.7", "Java 1.8", "Gradle 3", "Gradle 4", "Terraform 3"))
    }
})
