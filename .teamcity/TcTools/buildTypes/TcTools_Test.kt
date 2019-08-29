package TcTools.buildTypes

import TcTools.vcsRoots.TcTools_HttpsGithubComEgorminTcToolsRefsHeadsMaster
import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.buildFeatures.commitStatusPublisher
import jetbrains.buildServer.configs.kotlin.v2017_2.buildFeatures.merge
import jetbrains.buildServer.configs.kotlin.v2017_2.buildFeatures.replaceContent
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.script

object TcTools_Test : BuildType({
    uuid = "8a12e094-eb96-41f3-8669-d375a0161161"
    id = "TcTools_Test"
    name = "Test"

    params {
        text("text", "XXXXX", label = "text", display = ParameterDisplay.PROMPT, allowEmpty = true)
        select("Tools List", "yyy", label = "List", display = ParameterDisplay.PROMPT,
                allowMultiple = true,
options = listOf("git", "java", "python", "gradle", "maven"))
    }

    vcs {
        root(TcTools.vcsRoots.TcTools_HttpsGithubComEgorminTcToolsRefsHeadsMaster)

        checkoutMode = CheckoutMode.ON_AGENT
        cleanCheckout = true
    }

    steps {
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

    features {
        merge {
            enabled = false
            branchFilter = "+:develop"
            destinationBranch = "master"
            commitMessage = "Merge into master"
        }
        commitStatusPublisher {
            vcsRootExtId = TcTools_HttpsGithubComEgorminTcToolsRefsHeadsMaster.id
            publisher = github {
                githubUrl = "https://api.github.com"
                authType = personalToken {
                    token = "credentialsJSON:327e4e72-e868-42d1-9387-62a67dded66d"
                }
            }
        }
        replaceContent {
            enabled = false
            fileRules = ".teamcity/TcTools/buildTypes/TcTools_Test.kt"
            pattern = """"__kurr__""""
            replacement = "SUPER"
        }
    }
})
