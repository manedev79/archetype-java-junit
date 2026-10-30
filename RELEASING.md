# Releasing

Releases are published to Maven Central through the [Central Publisher Portal](https://central.sonatype.com)
with the `central-publishing-maven-plugin`.

## How to release

Run the `azure-pipelines-release.yml` pipeline in Azure DevOps and enter the version, e.g. `1.1.0`.
The pipeline will

1. set the version and build and test the project,
2. commit the version, tag it and push the tag,
3. sign the artifacts and upload them to the Central Portal, then wait until they are published,
4. create a GitHub release with generated notes (marked as pre-release for versions like `1.1.0-rc1`).

## Required secrets

All of them live in Azure DevOps.

| Where | Name | Content |
|---|---|---|
| Variable group `oss-secrets` | `CENTRAL_TOKEN_USERNAME` | Username of a Central Portal user token |
| Variable group `oss-secrets` | `CENTRAL_TOKEN_PASSWORD` | Password of a Central Portal user token |
| Variable group `oss-secrets` | `GPG_PASSPHRASE` | Passphrase of the signing key |
| Variable group `oss-secrets` | `GITHUB_TOKEN` | GitHub fine-grained PAT for this repository with *Contents: Read and write*, used to create the GitHub release |
| Secure files | `secret_signing_key_F5CE35A802DF35C1.gpg` | Secret signing key, exported with `gpg --export-secret-keys <key id>` |

Generate the user token at <https://central.sonatype.com/account>.

The public part of the signing key must be available on a public key server, e.g. `keyserver.ubuntu.com`
or `keys.openpgp.org`, because Maven Central verifies the signatures against it.
After extending the key's expiry date, upload the public key again and replace the secure file with a fresh export.
