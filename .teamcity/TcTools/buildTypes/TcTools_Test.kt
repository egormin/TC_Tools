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
        text("text", "2018-01-13T14:01:24.525", label = "text", display = ParameterDisplay.PROMPT, allowEmpty = true)
    }

    vcs {
        root(TcTools.vcsRoots.TcTools_HttpsGithubComEgorminTcToolsRefsHeadsMaster)

        cleanCheckout = true
    }

    steps {
        script {
            name = "TEZT"
            scriptContent = """
                ls
                pwd
                echo "ddd" >> README.md
                git clone git@github.com:egormin/TC_Tools.git
                cd TC_Tools 
                sed -i 's/_kurr_/SUPER/g' .teamcity/TcTools/buildTypes/TcTools_Test.kt
                git commit -am "changed"
                git push -u origin master
            """.trimIndent()
        }
    }

    features {
        merge {
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
            fileRules = ".teamcity/TcTools/buildTypes/TcTools_Test.kt"
            pattern = "_kurr_"
            replacement = "SUPER"
        }
    }
})
