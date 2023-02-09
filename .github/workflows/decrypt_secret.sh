#!/bin/sh

# Decrypt the file
# --batch to prevent interactive command
# --yes to assume "yes" for questions

gpg --quiet --batch --yes --decrypt --passphrase="$SECRET_PASSPHRASE" \
  --output app/google-services.json .github/workflows/secrets/google-services.json.gpg
