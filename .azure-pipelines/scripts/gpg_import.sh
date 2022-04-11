#!/usr/bin/env bash

set -o errexit
set -o pipefail
set -o nounset

keyfile="$1"

gpg --import "$keyfile" 
