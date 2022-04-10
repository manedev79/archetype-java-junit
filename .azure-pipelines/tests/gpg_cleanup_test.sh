#!/usr/bin/env bash

KEY_ID='386BEB0D1DE9312208BEEB698595C0870A2E554A'

oneTimeSetUp() {
    export set GNUPGHOME=$(pwd)/.gnupg
    rm -rf $GNUPGHOME
}

oneTimeTearDown() {
    rm -rf $GNUPGHOME
    unset GNUPGHOME
}

testCleanupDirectoryAndEnvironment() {
    ../scripts/gpg_import.sh ./private_signing_key.gpg
    ../scripts/gpg_cleanup.sh
    assertFalse 'GPG directory has not been deleted!' "[ -d $GNUPGHOME ]"
}

. ./bin/shunit2