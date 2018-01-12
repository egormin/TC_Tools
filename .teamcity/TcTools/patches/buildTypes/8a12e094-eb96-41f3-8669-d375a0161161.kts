package TcTools.patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2017_2.ui.*

import java.io.File
import java.io.InputStream

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, create a buildType with uuid = '8a12e094-eb96-41f3-8669-d375a0161161' (id = 'TcTools_Test')
in the project with uuid = '50967372-bc45-4f8c-908e-44012f72ed5b' and delete the patch script.
*/
create("50967372-bc45-4f8c-908e-44012f72ed5b", BuildType({
    uuid = "8a12e094-eb96-41f3-8669-d375a0161161"
    id = "TcTools_Test"
    name = "Test"

    val sss = "kurasan"
    //val inputStream: InputStream = File("/tmp/fileX").inputStream()
    //val inputString = inputStream.bufferedReader().use { it.readText() }

    val path = System.getProperty("user.dir")

    params {
        text("text", path, label = "text", display = ParameterDisplay.PROMPT, allowEmpty = true)
    }

    vcs {
        root("TcTools_HttpsGithubComEgorminTcToolsRefsHeadsMaster")

    }

    steps {
        script {
            name = "TEZT"
            scriptContent = "ls"
        }
    }
}))

