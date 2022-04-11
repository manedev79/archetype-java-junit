#!/usr/bin/env bash

set -o errexit
set -o pipefail
set -o nounset

keyfile="$1"

# Need --batch to avoid 'Inappropriate ioctl for device' on CI
gpg --batch --import "$keyfile" 
