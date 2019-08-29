package TcTools.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.vcs.GitVcsRoot

object TcTools_HttpsGithubComEgorminTcToolsRefsHeadsMaster : GitVcsRoot({
    uuid = "82e2cfe3-4a8b-4bde-bf7b-54c6235e1a98"
    id = "TcTools_HttpsGithubComEgorminTcToolsRefsHeadsMaster"
    name = "https://github.com/egormin/TC_Tools#refs/heads/master"
    url = "git@github.com:egormin/TC_Tools.git"
    pushUrl = "git@github.com:egormin/TC_Tools.git"
    branchSpec = "+:refs/heads/*"
    authMethod = uploadedKey {
        uploadedKey = "TC"
    }
})
