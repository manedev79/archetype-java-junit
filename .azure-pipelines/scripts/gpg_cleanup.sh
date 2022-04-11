#!/usr/bin/env bash

set -o errexit
set -o pipefail
set -o nounset

echo "Cleanup: $GNUPGHOME"
rm -rf "$GNUPGHOME" 
