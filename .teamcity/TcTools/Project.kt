package TcTools

import TcTools.buildTypes.*
import TcTools.vcsRoots.*
import TcTools.vcsRoots.TcTools_HttpsGithubComEgorminTcToolsRefsHeadsMaster
import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.Project
import jetbrains.buildServer.configs.kotlin.v2017_2.projectFeatures.VersionedSettings
import jetbrains.buildServer.configs.kotlin.v2017_2.projectFeatures.versionedSettings

object Project : Project({
    uuid = "50967372-bc45-4f8c-908e-44012f72ed5b"
    id = "TcTools"
    parentId = "_Root"
    name = "TC Tools"

    vcsRoot(TcTools_HttpsGithubComEgorminTcToolsRefsHeadsMaster)

    buildType(TcTools_Install)
    buildType(TcTools_SynchronizeToolsList)

    params {
        password("env.Pass", "credentialsJSON:d7d4c88c-7774-43d7-9660-f6640ff3f65b", label = "pass")
        param("env.User", "user")
    }

    features {
        versionedSettings {
            id = "PROJECT_EXT_3"
            mode = VersionedSettings.Mode.ENABLED
            buildSettingsMode = VersionedSettings.BuildSettingsMode.PREFER_SETTINGS_FROM_VCS
            rootExtId = TcTools_HttpsGithubComEgorminTcToolsRefsHeadsMaster.id
            showChanges = true
            settingsFormat = VersionedSettings.Format.KOTLIN
            storeSecureParamsOutsideOfVcs = true
        }
    }
})
