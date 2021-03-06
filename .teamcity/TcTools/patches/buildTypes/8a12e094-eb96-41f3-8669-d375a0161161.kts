package TcTools.patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2017_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with uuid = '8a12e094-eb96-41f3-8669-d375a0161161' (id = 'TcTools_Test')
accordingly and delete the patch script.
*/
changeBuildType("8a12e094-eb96-41f3-8669-d375a0161161") {
    expectSteps {
        script {
            name = "TEZT"
            scriptContent = """
                ls
                pwd
                #git clone git@github.com:egormin/TC_Tools.git
                #cd TC_Tools 
                whatToFind=`cat .teamcity/TcTools/buildTypes/TcTools_Test.kt | grep " val curr"`
                newValue='val curr = "XXXXX"'
                sed -i "s/${'$'}whatToFind/${'$'}newValue/g" .teamcity/TcTools/buildTypes/TcTools_Test.kt
                echo ${'$'}whatToFind
                git commit -am "changed"
                #git push -u origin master
                git push
            """.trimIndent()
        }
    }
    steps {
        update<ScriptBuildStep>(0) {
            scriptContent = """
                ls
                pwd
                #git clone git@github.com:egormin/TC_Tools.git
                #cd TC_Tools 
                #whatToFind=`cat .teamcity/TcTools/buildTypes/TcTools_Test.kt | grep " val curr"`
                whatToFind=`cat .teamcity/TcTools/buildTypes/TcTools_Test.kt | grep " options = listOf"`
                #newValue='val curr = "XXXXX"'
                newValue='options = listOf("git", "java", "python", "gradle", "maven"))'
                sed -i "s/${'$'}whatToFind/${'$'}newValue/g" .teamcity/TcTools/buildTypes/TcTools_Test.kt
                echo ${'$'}whatToFind
                git commit -am "changed"
                #git push -u origin master
                git push
            """.trimIndent()
        }
    }
}
