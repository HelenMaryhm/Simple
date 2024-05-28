

# gcloud spanner instance-configs list

ERROR: (gcloud.spanner.instance-configs.list) There was a problem refreshing your current auth tokens: ('Error code invalid_grant: ID Token issued at 1713260741 is stale to sign-in.', '{"error":"invalid_grant","error_description":"ID Token issued at 1713260741 is stale to sign-in."}')
Please run:

  $ gcloud auth login

to obtain new credentials.

If you have already logged in with a different account, run:

  $ gcloud config set account ACCOUNT


# When creating dbClient using java:

Caused by: com.google.cloud.spanner.SpannerException: UNAUTHENTICATED: com.google.api.gax.rpc.UnauthenticatedException: io.grpc.StatusRuntimeException: UNAUTHENTICATED: Request is missing required authentication credential. Expected OAuth 2 access token, login cookie or other valid authentication credential. See https://developers.google.com/identity/sign-in/web/devconsole-project.
