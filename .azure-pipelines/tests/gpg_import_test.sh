#!/usr/bin/env bash

KEY_ID='386BEB0D1DE9312208BEEB698595C0870A2E554A'

oneTimeSetUp() {
    rm -rf $(pwd)/.gnupg
    export set GNUPGHOME=$(pwd)/.gnupg
}

oneTimeTearDown() {
    unset GNUPGHOME
    rm -rf $(pwd)/.gnupg
}

testFailsWithoutParameter() {
    assertContains "$(../scripts/gpg_import.sh 2>&1)" 'unbound variable'
}

testImportsPrivateKey() {
    ../scripts/gpg_import.sh ./private_signing_key.gpg
    assertContains 'The private key has not been imported!' "$(gpg -K --keyid-format long)" "$KEY_ID"
}

. ./bin/shunit2