#!/bin/bash
set -e

URL="https://vcall-module.s3.ap-southeast-1.amazonaws.com/VialerPJSIP"
DEST="ios/VialerPJSIP.framework/VialerPJSIP"
DOWNLOAD=true

if ! type "curl" > /dev/null; then
    echo "Missed curl dependency" >&2;
    exit 1;
fi

if [ "$DOWNLOAD" = true ]; then
    curl -L --silent "${URL}" -o "${DEST}"
fi
