package TcTools.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.vcs.GitVcsRoot

object TcTools_HttpsGithubComEgorminTcToolsRefsHeadsMaster : GitVcsRoot({
    uuid = "82e2cfe3-4a8b-4bde-bf7b-54c6235e1a98"
    id = "TcTools_HttpsGithubComEgorminTcToolsRefsHeadsMaster"
    name = "https://github.com/egormin/TC_Tools#refs/heads/master"
    url = "https://github.com/egormin/TC_Tools"
    authMethod = password {
        userName = "egormin"
        password = "zxx8d720d5a19ffb6c43646437a1f735151d9d54503ece7f8b6006fb0a20fc56e8c77640e1d5225aab9775d03cbe80d301b"
    }
})
